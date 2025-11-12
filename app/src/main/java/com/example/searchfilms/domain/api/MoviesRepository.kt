package com.example.searchfilms.domain.api

import com.example.searchfilms.domain.models.Movie
import com.example.searchfilms.presentation.util.Resource

interface MoviesRepository {
    fun searchMovies(expression: String): Resource <List<Movie>>
}