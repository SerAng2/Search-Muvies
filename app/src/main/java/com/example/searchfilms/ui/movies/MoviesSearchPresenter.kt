package com.example.searchfilms.ui.movies

import android.content.Context
import android.os.Handler
import android.os.Looper
import com.example.searchfilms.R
import com.example.searchfilms.domain.api.MoviesInteractor
import com.example.searchfilms.domain.models.Movie
import com.example.searchfilms.presentation.util.Creator
import com.example.searchfilms.ui.movies.models.MoviesState
import moxy.MvpPresenter

class MoviesSearchPresenter(
    private val context: Context
) : MvpPresenter<MoviesView>() {

    companion object {
        private const val SEARCH_DEBOUNCE_DELAY = 2000L
    }

    private val moviesInteractor = Creator.provideMoviesInteractor(context)
    private val handler = Handler(Looper.getMainLooper())
    private var lastSearchText: String? = null

    private val searchRunnable = Runnable {
        val newSearchText = lastSearchText ?: ""
        searchRequest(newSearchText)
    }

    override fun onDestroy() {
        handler.removeCallbacksAndMessages(SEARCH_DEBOUNCE_DELAY)
    }

    fun searchDebounce(changedText: String) {
        this.lastSearchText = changedText
        handler.removeCallbacks(searchRunnable)
        handler.postDelayed(searchRunnable, SEARCH_DEBOUNCE_DELAY)
    }

    private fun searchRequest(newSearchText: String) {
        if (newSearchText.isNotEmpty()) {
            renderState(MoviesState(emptyList(), true, null))

            moviesInteractor.searchMovies(newSearchText, object : MoviesInteractor.MoviesConsumer {
                override fun consume(foundMovies: List<Movie>?, errorMessage: String?) {
                    handler.post {
                        when {
                            errorMessage != null -> {
                                renderState(MoviesState(emptyList(), false, context.getString(R.string.something_went_wrong)))
                                // showToast останется в render? Нет, уберём из здесь — UI сам обработает в showError
                            }
                            foundMovies.isNullOrEmpty() -> {
                                renderState(MoviesState(emptyList(), false, context.getString(R.string.nothing_found)))
                            }
                            else -> {
                                renderState(MoviesState(foundMovies, false, null))
                            }
                        }
                    }
                }
            })
        }
    }

    private fun renderState(state: MoviesState) {
      viewState.render(state)
    }
}
