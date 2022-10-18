package com.geektech.beauty.core.extensions

import android.annotation.SuppressLint
import android.content.SharedPreferences

fun SharedPreferences.write(key: String, value: Any) =
    this.edit()?.apply {
        when (value) {
            is String -> putString(key, value)
            is Int -> putInt(key, value)
            is Long -> putLong(key, value)
            is Float -> putFloat(key, value)
            is Boolean -> putBoolean(key, value)
        }
        apply()
    }

/**
 * Extension function for [SharedPreferences] to modify it synchronously
 * @param key is the key for [SharedPreferences]
 * @param value is the data which will be stored into [SharedPreferences]
 * */
@SuppressLint("ApplySharedPref")
fun SharedPreferences.writeSync(key: String, value: Any) =
    this.edit()?.apply {
        when (value) {
            is String -> putString(key, value)
            is Int -> putInt(key, value)
            is Long -> putLong(key, value)
            is Float -> putFloat(key, value)
            is Boolean -> putBoolean(key, value)
        }
        commit()
    }

/**
 * Extension for set operator for [SharedPreferences] which will be
 * used to save data into [SharedPreferences]
 * */
operator fun SharedPreferences.set(key: String, value: Any) =
    this.edit()?.apply {
        when (value) {
            is String -> putString(key, value)
            is Int -> putInt(key, value)
            is Long -> putLong(key, value)
            is Float -> putFloat(key, value)
            is Boolean -> putBoolean(key, value)
        }
        apply()
    }

/**
 * Extension to clear [SharedPreferences]
 * */
fun SharedPreferences.clear() = this.edit().clear().apply()

/**
 * Extension function to remove a key-value pair from [SharedPreferences]
 * */
fun SharedPreferences.remove(key: String) = this.edit().remove(key).apply()