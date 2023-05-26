package com.example.movieapp.features.common.repository

import com.example.movieapp.features.common.entity.CategoryEntity
import com.example.movieapp.features.common.entity.EntityWrapper
import com.example.movieapp.features.common.entity.MovieDetailEntity
import com.example.movieapp.features.feed.domain.enum.SortOrder

interface IMovieDataSource {
    suspend fun getCategories(sortOrder: SortOrder? = null): EntityWrapper<List<CategoryEntity>>
    suspend fun getMovieDetail(movieName: String): MovieDetailEntity
}