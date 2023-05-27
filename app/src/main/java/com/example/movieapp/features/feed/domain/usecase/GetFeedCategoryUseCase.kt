package com.example.movieapp.features.feed.domain.usecase

import com.example.movieapp.features.common.entity.CategoryEntity
import com.example.movieapp.features.common.entity.EntityWrapper
import com.example.movieapp.features.common.repository.IMovieDataSource
import com.example.movieapp.features.feed.domain.enum.SortOrder
import javax.inject.Inject

class GetFeedCategoryUseCase @Inject constructor(
    private val dataSource: IMovieDataSource
) : IGetFeedCategoryUseCase {
    override suspend fun invoke(sortOrder: SortOrder?): EntityWrapper<List<CategoryEntity>> {
        return dataSource.getCategories(sortOrder)
    }
}