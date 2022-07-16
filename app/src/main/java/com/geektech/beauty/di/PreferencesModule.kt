package com.geektech.beauty.di

import android.content.Context
import android.content.SharedPreferences
import com.geektech.beauty.common.Constants.PREFERENCES_NAME_KEY
import com.geektech.beauty.data.local.preferences.AuthenticationPreferencesManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PreferencesModule {
    @Singleton
    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences(PREFERENCES_NAME_KEY, Context.MODE_PRIVATE)

    @Singleton
    @Provides
    fun provideAuthenticationPreferencesManager(sharedPreferences: SharedPreferences) =
        AuthenticationPreferencesManager(sharedPreferences)
}