package com.geektech.beauty.data.local.preferences

import android.content.SharedPreferences
import com.geektech.beauty.data.local.preferences.PreferencesKeys.IS_AUTHENTICATED_KEY
import javax.inject.Inject

class AuthenticationPreferencesManager @Inject constructor(private val preferences: SharedPreferences) {
    var isAuthenticated: Boolean
        get() = preferences.getBoolean(IS_AUTHENTICATED_KEY, false)
        set(value) = preferences.edit().putBoolean(IS_AUTHENTICATED_KEY, value).apply()
}