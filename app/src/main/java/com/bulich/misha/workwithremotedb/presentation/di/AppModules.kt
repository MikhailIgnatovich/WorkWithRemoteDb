package com.bulich.misha.workwithremotedb.presentation.di

import androidx.room.Room
import com.bulich.misha.workwithremotedb.data.localDB.LocalDB
import com.bulich.misha.workwithremotedb.data.repository.dataSource.FilmsApiDataSource
import com.bulich.misha.workwithremotedb.data.repository.dataSource.FilmsDataSource
import com.bulich.misha.workwithremotedb.data.repository.dataSourceIMPL.FilmsApiDataSourceIMPL
import com.bulich.misha.workwithremotedb.data.repository.dataSourceIMPL.FilmsDataSourceIMPL
import com.bulich.misha.workwithremotedb.data.repository.repository.FilmsRepository
import com.bulich.misha.workwithremotedb.domain.repository.FilmsCall
import com.bulich.misha.workwithremotedb.domain.useCase.FilmsUseCase
import com.bulich.misha.workwithremotedb.presentation.FilmsViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.get
import org.koin.dsl.module
import org.koin.dsl.single

val moduleFilms = module {

    single {
        Room.databaseBuilder(
            androidContext(), LocalDB::class.java,
            "LocalDB"
        ).build()
    }

    single { get<LocalDB>().filmsDao }

    single<FilmsDataSource> {
        FilmsDataSourceIMPL(
            get()
        )
    }

    single<FilmsApiDataSource> {
        FilmsApiDataSourceIMPL(
            get()
        )
    }

    single<FilmsCall> {
        FilmsRepository(
            get(), get()
        )
    }

    single {
        FilmsUseCase(
            get()
        )
    }

    viewModel { FilmsViewModel(get()) }
}