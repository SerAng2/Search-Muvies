package com.example.searchfilms.ui.movies.models

import com.example.searchfilms.domain.models.Movie

data class MoviesState(
    val movies: List<Movie>,
    val isLoading: Boolean,
    val errorMessage: String?
)
