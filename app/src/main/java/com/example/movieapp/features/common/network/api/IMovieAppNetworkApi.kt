package com.example.movieapp.features.common.network.api

import com.example.movieapp.features.common.network.model.MovieResponse
import com.example.movieapp.library.network.model.ApiResult

interface IMovieAppNetworkApi {
    suspend fun getMovies(): ApiResult<List<MovieResponse>>
}