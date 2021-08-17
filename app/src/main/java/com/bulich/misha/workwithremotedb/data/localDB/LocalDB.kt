package com.bulich.misha.workwithremotedb.data.localDB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bulich.misha.workwithremotedb.data.models.FilmsModel

@Database(entities = [FilmsModel::class], version = 1)
abstract class LocalDB : RoomDatabase() {

    abstract val filmsDao: FilmsDao
}