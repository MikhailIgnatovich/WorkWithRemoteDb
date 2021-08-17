package com.bulich.misha.workwithremotedb.data.repository.dataSource

import androidx.lifecycle.LiveData
import com.bulich.misha.workwithremotedb.data.models.FilmsModel

interface FilmsDataSource {

    fun insert(filmsModel: FilmsModel)

    fun loadFilms(): LiveData<List<FilmsModel>>

    suspend fun clear()
}