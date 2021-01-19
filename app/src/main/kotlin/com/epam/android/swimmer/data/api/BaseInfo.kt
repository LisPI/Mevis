package com.epam.android.swimmer.data.api

import kotlinx.serialization.Serializable

@Serializable
data class BaseInfo(
	val company: Company? = null,
	val account: Account? = null,
	val users: List<UsersItem?>? = null,
)
@Serializable
data class UsersItem(
	val filials: List<Int?>? = null,
	val availableBalance: Int? = null,
	val balance: Int? = null,
	val jivoSiteUserToken: String? = null,
	val phone: String? = null,
	val name: String? = null,
	val id: Int? = null,
	val email: String? = null
)
@Serializable
data class Company(
	val name: String? = null,
	val currency: String? = null
)
@Serializable
data class Params(
	val calendarFields: List<String?>? = null,
	val searchLessonsDefault: String? = null,
	val searchFilialsDefault: String? = null,
	val calendarZoom: String? = null,
	val calendarStartHour: Int? = null
)
@Serializable
data class Account(
	val id: Int? = null,
	val params: Params? = null,
	val email: String? = null
)

