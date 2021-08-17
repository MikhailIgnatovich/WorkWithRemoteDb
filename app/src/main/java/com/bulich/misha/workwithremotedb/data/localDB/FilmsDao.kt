package com.bulich.misha.workwithremotedb.data.localDB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bulich.misha.workwithremotedb.data.models.FilmsModel

@Dao
interface FilmsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFilm(filmsModel: FilmsModel)

    @Query("SELECT * FROM films_data_table")
    fun loadFilms(): LiveData<List<FilmsModel>>

    @Query("DELETE from films_data_table")
    suspend fun clear()

}