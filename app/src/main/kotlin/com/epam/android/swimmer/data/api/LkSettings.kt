package com.epam.android.swimmer.data.api

import kotlinx.serialization.Serializable

@Serializable
data class LkSettings(
	val cancelRecordsTimeout: Int? = null,
	val onlinePayment: OnlinePayment? = null,
	val color: String? = null,
	val accentColor: String? = null,
	val answerActions: AnswerActions? = null,
	val companyName: String? = null,
	val allowRecords: Boolean? = null,
	val showSubsTotalDebit: Boolean? = null,
	val fileActions: FileActions? = null,
	val cancelRecords: String? = null,
	val allowPages: AllowPages? = null,
	val allowRecordsTimeout: Int? = null,
	val showSubsDebits: Boolean? = null,
	val logo: String? = null,
	val selectLessons: String? = null,
	val showAvatar: Boolean? = null,
	val contacts: Contacts,
	val useTerms: String? = null
)
@Serializable
data class AnswerActions(
	val file: Boolean? = null,
	val create: Boolean? = null,
	val comment: Boolean? = null,
	val delete: Boolean? = null
)
@Serializable
data class FileActions(
	val upload: Boolean? = null,
	val comment: Boolean? = null,
	val avatar: Boolean? = null,
	val delete: Boolean? = null
)
@Serializable
data class Contacts(
	val phone: String? = null,
	val name: String? = null,
	val email: String? = null,
	val full: String? = null
)
@Serializable
data class AllowPages(
	val pageFiles: Boolean? = null,
	val pageLessons: Boolean? = null,
	val pageSubscriptions: Boolean? = null,
	val pageCourses: Boolean? = null,
	val pagePayments: Boolean? = null
)
@Serializable
data class OnlinePayment(
	val integrationIds: List<String?>? = null,
	val depositOnBalans: Boolean? = null,
	val enabled: Boolean? = null
)

