package com.epam.android.swimmer.data.repository

import android.content.Context
import com.epam.android.swimmer.data.api.ApiService
import com.epam.android.swimmer.data.db.Cat
import com.epam.android.swimmer.data.db.CatsDao
import com.epam.android.swimmer.data.utli.mapper.CatsMapper
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class CatsRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val dao: CatsDao,
    private val catsMapper: CatsMapper,
    @ApplicationContext private val appContext: Context
) : CatsRepository {

    private val scope = CoroutineScope(Dispatchers.Default)

    init {
        scope.launch {
            loadCats()
        }
    }

    private suspend fun loadCats() {
//        withContext(Dispatchers.IO) {
//            val result = api.getCats()
//            if (result.isSuccess()) {
//                val list = result.asSuccess().value
//                val cats = catsMapper.map(list)
//                dao.addCats(cats)
//            } else {
//                withContext(Dispatchers.Main) {
//                    Toast.makeText(
//                        appContext,
//                        result.asFailure().error.toString(),
//                        Toast.LENGTH_LONG
//                    ).show()
//                }
//            }
//        }
    }

    override fun getCats(): Flow<List<Cat>> {
        return dao.getCats()
    }
}