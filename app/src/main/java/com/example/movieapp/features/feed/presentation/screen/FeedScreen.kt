package com.example.movieapp.features.feed.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.movieapp.R
import com.example.movieapp.features.feed.presentation.input.IFeedViewModelInput
import com.example.movieapp.features.feed.presentation.output.FeedState
import com.example.movieapp.ui.components.movie.CategoryRow
import com.example.movieapp.ui.theme.Paddings
import timber.log.Timber

val COMMON_HORIZONTAL_PADDING = Paddings.medium

@Composable
fun FeedScreen(
    feedStateHolder: State<FeedState>,
    input: IFeedViewModelInput,
//    buttonColor: State<Color>,
//    changeAppColor: () -> Unit
) {
//    val btnColor by remember { buttonColor }

    Scaffold(
        topBar = {
            TopAppBar(
                elevation = 0.dp,
                modifier = Modifier
                    .background(MaterialTheme.colors.primarySurface)
                    .requiredHeight(70.dp),
                title = {
                    Text(
                        modifier = Modifier.padding(
                            start = COMMON_HORIZONTAL_PADDING
                        ),
                        text = stringResource(id = R.string.app_name),
                        style = MaterialTheme.typography.h3
                    )
                },
                actions = {
//                    AppBarMenu(
//                        btnColor = btnColor,
//                        changeAppColor = changeAppColor,
//                        input = input
//                    )
                }
            )
        }
    ) {
        BodyContent(
            feedState = feedStateHolder.value,
            input = input
        )
    }
}

@Composable
fun AppBarMenu(
    btnColor: Color,
    changeAppColor: () -> Unit,
    input: IFeedViewModelInput
) {
    Row(
        modifier = Modifier.padding(
            end = COMMON_HORIZONTAL_PADDING
        )
    ) {
        IconButton(
            onClick = {
                changeAppColor()
            }
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(color = btnColor)
            )
        }

        IconButton(
            onClick = {
                input.openInfoDialog()
            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_information),
                contentDescription = "Information",
                tint = MaterialTheme.colors.onPrimary
            )
        }
    }
}

@Composable
fun BodyContent(
    feedState: FeedState,
    input: IFeedViewModelInput
) {
    when (feedState) {
        is FeedState.Loading -> {
            Timber.d("MoviesScreen: Loading")
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }

        is FeedState.Main -> {
            Timber.d("MoviesScreen: Success")
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                itemsIndexed(feedState.categories) { _, category ->
                    CategoryRow(
                        categoryEntity = category,
                        input = input
                    )
                }
            }
        }

        is FeedState.Failed -> {
            Timber.d("MoviesScreen: Error")
            RetryMessage(
                message = feedState.reason,
                input = input
            )
        }
    }
}

val IMAGE_SIZE = 48.dp

@Composable
fun RetryMessage(
    modifier: Modifier = Modifier,
    message: String,
    input: IFeedViewModelInput
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier
                .requiredSize(IMAGE_SIZE),
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_warning),
            contentDescription = null
        )

        Text(
            text = message,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(
                top = Paddings.xlarge,
                bottom = Paddings.extra
            )
        )

        Button(
            onClick = { input.refreshFeed() }
        ) {
            Text("RETRY")
        }
    }
}