package com.epam.android.swimmer.data.utli.mapper

import com.epam.android.swimmer.data.db.Cat
import javax.inject.Inject

class CatsMapper @Inject constructor() : Mapper<Cat, Cat> {

    override fun map(list: List<Cat>): List<Cat> {
        return list.map {
            Cat(it.id, it.url)
        }
    }
}