package com.bulich.misha.workwithremotedb.data.repository.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.bulich.misha.workwithremotedb.data.models.FilmsModel
import com.bulich.misha.workwithremotedb.data.repository.dataSource.FilmsApiDataSource
import com.bulich.misha.workwithremotedb.data.repository.dataSource.FilmsDataSource
import com.bulich.misha.workwithremotedb.domain.repository.FilmsCall

class FilmsRepository(
    private val filmsApiDataSource: FilmsApiDataSource,
    private val filmsDataSource: FilmsDataSource
) : FilmsCall {

    override fun loadFilms(): LiveData<List<FilmsModel>> {
        return filmsDataSource.loadFilms()
    }

    override suspend fun startMigration(context: Context) {
        filmsDataSource.clear()
        filmsApiDataSource.startMigration(context)
    }
}