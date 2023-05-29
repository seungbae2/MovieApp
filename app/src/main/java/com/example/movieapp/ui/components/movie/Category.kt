package com.example.movieapp.ui.components.movie

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.movieapp.features.common.entity.CategoryEntity
import com.example.movieapp.features.feed.presentation.input.IFeedViewModelInput
import com.example.movieapp.ui.theme.MovieAppTheme
import com.example.movieapp.ui.theme.Paddings

@Composable
fun CategoryRow(
    categoryEntity: CategoryEntity,
    input: IFeedViewModelInput
) {
    Column {
        CategoryTitle(categoryEntity.genre)
        LazyRow(
            contentPadding = PaddingValues(
                horizontal = Paddings.large
            )
        ) {
            itemsIndexed(categoryEntity.movieFeedEntities) {
                _, item ->
                MovieItem(
                    movie = item,
                    input = input
                )
            }
        }
    }
}

@Composable
fun CategoryTitle(genre: String) {
    Text(
        text = genre,
        modifier = Modifier.padding(
            vertical = Paddings.large,
            horizontal = Paddings.extra
        ),
        style = MaterialTheme.typography.h5
    )
}