package com.example.searchfilms.presentation.util

import android.app.Activity
import android.content.Context
import com.example.searchfilms.data.MoviesRepositoryImpl
import com.example.searchfilms.data.network.RetrofitNetworkClient
import com.example.searchfilms.domain.api.MoviesInteractor
import com.example.searchfilms.domain.api.MoviesRepository
import com.example.searchfilms.domain.impl.MoviesInteractorImpl
import com.example.searchfilms.ui.movies.MoviesSearchPresenter
import com.example.searchfilms.presentation.PosterPresenter
import com.example.searchfilms.ui.movies.MoviesActivity
import com.example.searchfilms.ui.movies.PosterView
import com.example.searchfilms.ui.poster.PosterActivity

object Creator {
    private fun getMoviesRepository(context: Context): MoviesRepository {
        return MoviesRepositoryImpl(RetrofitNetworkClient(context))
    }

    fun provideMoviesInteractor(context: Context): MoviesInteractor {
        return MoviesInteractorImpl(getMoviesRepository(context))
    }

    fun provideMoviesSearchPresenter(
        context: Context
    ): MoviesSearchPresenter {

        return MoviesSearchPresenter(
            context = context
        )
    }

    fun providePosterPresenter(
        posterView: PosterView,
        imageUrl: String
    ): PosterPresenter {
        return PosterPresenter(
            posterView,
            imageUrl
        )
    }
}