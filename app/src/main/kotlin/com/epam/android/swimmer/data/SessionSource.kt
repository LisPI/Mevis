package com.epam.android.swimmer.data

interface SessionSource {
    fun getSavedSession()
    fun saveSession()
    fun deleteSession()

    fun getSavedCookie() : Set<String>
    fun saveCookie(cookie: Set<String>)
    fun deleteCookie()
}
