package com.epam.android.swimmer.data.repository

import com.epam.android.swimmer.data.db.Cat
import kotlinx.coroutines.flow.Flow

interface CatsRepository {

    fun getCats(): Flow<List<Cat>>
}