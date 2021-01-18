package com.epam.android.swimmer.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "company")
data class Company(
    @PrimaryKey
    val name: String="",
    val phone: String? = null,
    val email: String? = null,
    val full: String? = null
)