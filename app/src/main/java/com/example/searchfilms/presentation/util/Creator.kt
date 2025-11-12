package com.example.searchfilms.presentation.util

import android.app.Activity
import android.content.Context
import com.example.searchfilms.data.MoviesRepositoryImpl
import com.example.searchfilms.data.network.RetrofitNetworkClient
import com.example.searchfilms.domain.api.MoviesInteractor
import com.example.searchfilms.domain.api.MoviesRepository
import com.example.searchfilms.domain.impl.MoviesInteractorImpl
import com.example.searchfilms.presentation.MoviesSearchController
import com.example.searchfilms.presentation.PosterController
import com.example.searchfilms.ui.movies.MoviesAdapter

object Creator {
    private fun getMoviesRepository(context: Context): MoviesRepository {
        return MoviesRepositoryImpl(RetrofitNetworkClient(context))
    }

    fun provideMoviesInteractor(context: Context): MoviesInteractor {
        return MoviesInteractorImpl(getMoviesRepository(context))
    }

    fun provideMoviesSearchController(activity: Activity, adapter: MoviesAdapter): MoviesSearchController {
        return MoviesSearchController(activity, adapter)
    }

    fun providePosterController(activity: Activity): PosterController {
        return PosterController(activity)
    }
}