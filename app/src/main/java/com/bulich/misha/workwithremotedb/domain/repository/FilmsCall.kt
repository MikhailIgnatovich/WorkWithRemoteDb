package com.bulich.misha.workwithremotedb.domain.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.agrawalsuneet.dotsloader.loaders.ZeeLoader
import com.bulich.misha.workwithremotedb.data.models.FilmsModel

interface FilmsCall {

    fun loadFilms(): LiveData<List<FilmsModel>>

    suspend fun startMigration(context: Context, loader: ZeeLoader)
}