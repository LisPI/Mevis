package com.epam.android.swimmer.data.utli.mapper

import com.epam.android.swimmer.data.api.Contacts
import com.epam.android.swimmer.data.db.Company
import javax.inject.Inject

class CompanyMapper @Inject constructor() : Mapper<Contacts, Company> {

    override fun map(from: Contacts): Company {
        return Company(from.name ?: "" , from.phone, from.email, from.full)
    }
}