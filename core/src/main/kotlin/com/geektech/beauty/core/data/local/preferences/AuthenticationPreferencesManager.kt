package com.geektech.beauty.core.data.local.preferences

import android.content.SharedPreferences
import com.geektech.beauty.core.data.local.preferences.PreferencesKeys.HAS_CLIENT_ONBOARD_BEEN_SEEN_KEY
import com.geektech.beauty.core.data.local.preferences.PreferencesKeys.HAS_SALON_OWNER_ONBOARD_BEEN_SEEN_KEY
import com.geektech.beauty.core.data.local.preferences.PreferencesKeys.IS_CLIENT_AUTHENTICATED_KEY
import com.geektech.beauty.core.data.local.preferences.PreferencesKeys.IS_SALON_OWNER_AUTHENTICATED_KEY
import com.geektech.beauty.core.data.local.preferences.PreferencesKeys.IS_USER_A_SALON_OWNER_KEY
import com.geektech.beauty.core.data.local.preferences.PreferencesKeys.UNDEFINED_KEY
import com.geektech.beauty.core.data.local.preferences.PreferencesKeys.USER_ROLE_KEY
import javax.inject.Inject

class AuthenticationPreferencesManager @Inject constructor(private val preferences: SharedPreferences) {
    var isClientAuthenticated: Boolean
        get() = preferences.getBoolean(IS_CLIENT_AUTHENTICATED_KEY, false)
        set(value) = preferences.edit().putBoolean(IS_CLIENT_AUTHENTICATED_KEY, value).apply()
    var isSalonOwnerAuthenticated: Boolean
        get() = preferences.getBoolean(IS_SALON_OWNER_AUTHENTICATED_KEY, false)
        set(value) = preferences.edit().putBoolean(IS_SALON_OWNER_AUTHENTICATED_KEY, value).apply()
    var isUserASalonOwner: Boolean
        get() = preferences.getBoolean(IS_USER_A_SALON_OWNER_KEY, false)
        set(value) = preferences.edit().putBoolean(IS_USER_A_SALON_OWNER_KEY, value).apply()
    var userRole: String?
        get() = preferences.getString(USER_ROLE_KEY, UNDEFINED_KEY)
        set(value) = preferences.edit().putString(USER_ROLE_KEY, value).apply()
    var hasClientOnboardBeenSeen: Boolean
        get() = preferences.getBoolean(HAS_CLIENT_ONBOARD_BEEN_SEEN_KEY, false)
        set(value) = preferences.edit().putBoolean(HAS_CLIENT_ONBOARD_BEEN_SEEN_KEY, value).apply()
    var hasSalonOwnerOnboardBeenSeen: Boolean
        get() = preferences.getBoolean(HAS_SALON_OWNER_ONBOARD_BEEN_SEEN_KEY, false)
        set(value) = preferences.edit().putBoolean(HAS_SALON_OWNER_ONBOARD_BEEN_SEEN_KEY, value)
            .apply()

}