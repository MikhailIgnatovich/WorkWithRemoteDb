package com.bulich.misha.workwithremotedb.data.repository.dataSource

import android.content.Context

interface FilmsApiDataSource {

    fun startMigration(context: Context)
}