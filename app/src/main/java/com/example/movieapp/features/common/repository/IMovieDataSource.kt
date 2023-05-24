package com.example.movieapp.features.common.repository

interface IMovieDataSource {
    suspend fun getMovieList()
}