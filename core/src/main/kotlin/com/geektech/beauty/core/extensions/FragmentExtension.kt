package com.geektech.beauty.core.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.provider.MediaStore
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.activity.OnBackPressedCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar

fun Fragment.showShortDurationSnackbar(text: CharSequence) {
    view?.let { Snackbar.make(it, text, Snackbar.LENGTH_SHORT).show() }
}

fun Fragment.showLongDurationSnackbar(text: CharSequence) {
    view?.let { Snackbar.make(it, text, Snackbar.LENGTH_LONG).show() }
}


fun Fragment.checkWhetherPermissionHasBeenGrantedOrNot(
    context: Context,
    permission: String,
    activity: Activity
): Intent {
    val galleryIntent =
        Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)

    when (ContextCompat.checkSelfPermission(context, permission)) {
        -1 -> ActivityCompat.requestPermissions(
            activity, arrayOf(
                permission
            ), 0
        )
    }
    return galleryIntent
}

fun Fragment.hasPermissionCheckAndRequest(
    requestPermissionLauncher: ActivityResultLauncher<Array<String>>,
    permission: Array<String>,
): Boolean {
    for (per in permission) {
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                per
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissionLauncher.launch(permission)
            return false
        }
    }
    return true
}

fun Fragment.checkForPermissionStatusAndRequestIt(
    requestPermissionLauncher: ActivityResultLauncher<String>,
    permission: String,
): Boolean {
    return when (ContextCompat.checkSelfPermission(
        requireContext(),
        permission
    ) == PackageManager.PERMISSION_GRANTED) {
        true -> true

        else -> {
            requestPermissionLauncher.launch(permission)
            false
        }
    }
}

fun Fragment.hideSoftKeyboard() {
    val inputMethodManager =
        context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view?.windowToken, 0)
}

fun Fragment.checkWhetherSoftKeyboardIsOpenedOrNot(): Boolean {
    val inputMethodManager =
        context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    return inputMethodManager.isAcceptingText

}

typealias Bind<T> = (View) -> T

inline fun <reified Binding : ViewBinding> Fragment.getBinding(layoutId: Int, bind: Bind<Binding>) =
    bind(
        layoutInflater.inflate(
            layoutId,
            null
        )
    )

fun Fragment.overrideOnBackPressed(actionWhenBackButtonPressed: () -> Unit) {
    activity?.onBackPressedDispatcher?.addCallback(
        requireActivity(),
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                actionWhenBackButtonPressed.invoke()
            }

        })
}

fun Fragment.setStatusBarColor(color: Int) {
    WindowCompat.setDecorFitsSystemWindows(requireActivity().window, true)
    requireActivity().window.statusBarColor = ContextCompat.getColor(requireActivity(), color)

}

fun Fragment.setStatusBarLightAppearance(isAppearanceLightStatusBars: Boolean) {
    view?.let {
        WindowInsetsControllerCompat(
            requireActivity().window, it
        ).isAppearanceLightStatusBars = isAppearanceLightStatusBars
    }

}
