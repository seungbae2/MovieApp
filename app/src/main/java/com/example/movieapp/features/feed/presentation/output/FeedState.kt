package com.example.movieapp.features.feed.presentation.output

import com.example.movieapp.features.common.entity.CategoryEntity

sealed class FeedState {
    object Loading : FeedState()
    class Main(
        val categories: List<CategoryEntity>
    ) : FeedState()

    class Failed(
        val reason: String
    ) : FeedState()
}