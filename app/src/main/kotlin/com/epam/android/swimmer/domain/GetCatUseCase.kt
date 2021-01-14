package com.epam.android.swimmer.domain

import com.epam.android.swimmer.data.db.Cat
import com.epam.android.swimmer.data.repository.CatsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetCatUseCase @Inject constructor(
    private val repository: CatsRepository
) {
    fun getCats(): Flow<List<Cat>> {
        return repository.getCats().map { list ->
            list.sortedBy { it.id }
        }
    }
}