package com.geektech.beauty.core.extensions

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AlertDialog
import androidx.viewbinding.ViewBinding

fun Context.showCustomDialog(binding: ViewBinding): AlertDialog {
    val builder = AlertDialog.Builder(this)
    builder.setView(binding.root)
    val bannerDialog = builder.create()
    bannerDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    bannerDialog.show()
    return bannerDialog
}
