package com.example.searchfilms.presentation

import com.example.searchfilms.ui.movies.PosterView

class PosterPresenter(
    private val view: PosterView,
    private val imageUrl: String
) {

    fun onCreate() {
        view.setupPosterImage(imageUrl)
    }
}