package com.geektech.beauty.data.local.preferences

import android.content.SharedPreferences
import com.geektech.beauty.data.local.preferences.PreferencesKeys.HAS_ONBOARD_BEEN_SEEN
import com.geektech.beauty.data.local.preferences.PreferencesKeys.IS_AUTHENTICATED_KEY
import com.geektech.beauty.data.local.preferences.PreferencesKeys.IS_USER_A_CLIENT
import javax.inject.Inject

class AuthenticationPreferencesManager @Inject constructor(private val preferences: SharedPreferences) {
    var isAuthenticated: Boolean
        get() = preferences.getBoolean(IS_AUTHENTICATED_KEY, false)
        set(value) = preferences.edit().putBoolean(IS_AUTHENTICATED_KEY, value).apply()
    var isUserAClient: Boolean
        get() = preferences.getBoolean(IS_USER_A_CLIENT, false)
        set(value) = preferences.edit().putBoolean(IS_USER_A_CLIENT, value).apply()
    var hasOnboardBeenSeen: Boolean
        get() = preferences.getBoolean(HAS_ONBOARD_BEEN_SEEN, false)
        set(value) = preferences.edit().putBoolean(HAS_ONBOARD_BEEN_SEEN, value).apply()

}