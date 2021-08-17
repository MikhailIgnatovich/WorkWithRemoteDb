package com.bulich.misha.workwithremotedb.data.repository.dataSourceIMPL

import androidx.lifecycle.LiveData
import com.bulich.misha.workwithremotedb.data.localDB.FilmsDao
import com.bulich.misha.workwithremotedb.data.models.FilmsModel
import com.bulich.misha.workwithremotedb.data.repository.dataSource.FilmsDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FilmsDataSourceIMPL(private val filmsDao: FilmsDao) :
    FilmsDataSource {

    override fun insert(filmsModel: FilmsModel) {
        CoroutineScope(Dispatchers.IO).launch {
            filmsDao.insertFilm(filmsModel)
        }
    }

    override fun loadFilms(): LiveData<List<FilmsModel>> {
        return filmsDao.loadFilms()
    }

    override suspend fun clear() {
        CoroutineScope(Dispatchers.IO).launch {
            filmsDao.clear()
        }
    }
}