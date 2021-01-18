package com.epam.android.swimmer.data.utli.mapper

interface Mapper<I, O> {
    fun map(from: I): O
}