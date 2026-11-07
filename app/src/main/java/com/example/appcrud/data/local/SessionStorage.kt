package com.example.appcrud.data.local

import android.content.Context
import android.content.SharedPreferences

class SessionStorage private constructor(
    private val preferences: SharedPreferences
) {
    companion object {
        private const val PREF_NAME = "app_session"
        private const val KEY_TOKEN = "access_token"
        private const val KEY_EMAIL = "user_mail"

        fun getInstance(context: Context): SessionStorage {
            val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            return SessionStorage(prefs)
        }
    }

    fun getInstance(context: Context): SessionStorage {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return SessionStorage(prefs)

    }

    fun getToken(): String? = preferences.getString(KEY_TOKEN, null)

    fun getEmail(): String? = preferences.getString(KEY_EMAIL, null)

    fun isLoggedIn(): Boolean = getToken()?.isNotBlank() == true

    fun clearSession() {
        val editor = preferences.edit()
        editor.remove(KEY_TOKEN)
        editor.remove(KEY_EMAIL)
        editor.apply()
    }

}


