package com.epam.android.swimmer

import android.content.Context
import androidx.preference.PreferenceManager
import com.epam.android.swimmer.data.SessionSource
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SharedPrefSessionSource @Inject constructor(@ApplicationContext val context: Context): SessionSource {

    private val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
    private val cookiesKey = "appCookies"

    override fun getSavedSession() {
        TODO("Not yet implemented")
    }

    override fun saveSession() {
        TODO("Not yet implemented")
    }

    override fun deleteSession() {
        TODO("Not yet implemented")
    }

    override fun getSavedCookie(): Set<String> {
        return sharedPreferences.getStringSet(cookiesKey, HashSet()) as HashSet<String>
    }

    override fun saveCookie(cookie: Set<String>) {
        with(sharedPreferences.edit()) {
            putStringSet(cookiesKey, cookie)
            apply()
        }
    }

    override fun deleteCookie() {
        with(sharedPreferences.edit()) {
            remove(cookiesKey)
            apply()
        }
    }
}
