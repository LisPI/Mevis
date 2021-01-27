package com.epam.android.swimmer.data

interface SessionSource {
    fun getSavedSession(): String
    fun saveSession(session: String)
    fun deleteSession()

    fun getSavedCookie(): Set<String>
    fun saveCookie(cookie: Set<String>)
    fun deleteCookie()
}
