package com.example.searchfilms.data.dto

/* import com.example.searchfilms.domain.models.Movie

data class MoviesSearchResponse(val searchType: String,
                                val expression: String,
                                val results: List<Movie>) */
data class MoviesSearchResponse(
    val searchType: String,
    val expression: String,
    val results: List<MovieDto>) : Response()
/* Класс MoviesSearchResponse нужно перенести в пакет data.dto,
поскольку он содержит информацию об ответе с сервера
 */