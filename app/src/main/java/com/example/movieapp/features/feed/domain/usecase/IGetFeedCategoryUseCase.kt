package com.example.movieapp.features.feed.domain.usecase

import com.example.movieapp.features.common.entity.CategoryEntity
import com.example.movieapp.features.common.entity.EntityWrapper
import com.example.movieapp.features.feed.domain.enum.SortOrder

interface IGetFeedCategoryUseCase {
    suspend operator fun invoke(sortOrder: SortOrder? = null): EntityWrapper<List<CategoryEntity>>
}