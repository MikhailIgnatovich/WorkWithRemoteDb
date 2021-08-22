package com.bulich.misha.workwithremotedb.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bulich.misha.workwithremotedb.domain.useCase.FilmsUseCase
import kotlinx.coroutines.launch

class FilmsViewModel(private val filmsUseCase: FilmsUseCase) : ViewModel() {

    val loadFilms = filmsUseCase.loadFilms()

    fun migration(context: Context) = viewModelScope.launch {
        filmsUseCase.startMigration(context)
    }
}