package com.epam.android.swimmer.data.utli.mapper

interface Mapper<I, O> {
    fun map(list: List<I>): List<O>
}