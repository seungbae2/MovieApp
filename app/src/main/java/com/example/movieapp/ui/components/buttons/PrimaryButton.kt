package com.example.movieapp.ui.components.buttons

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieapp.ui.models.buttons.LeadingIconData
import com.example.movieapp.ui.theme.MovieAppTheme
import com.example.movieapp.ui.theme.Paddings
import com.example.movieapp.ui.theme.colorScheme

val LEADING_ICON_SIZE = 24.dp
@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    @StringRes id: Int? = null,
    text: String = "",
    leadingIconData: LeadingIconData? = null,
    onClick: () -> Unit
) {
    Button(
        modifier= modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            disabledContentColor = MaterialTheme.colorScheme.background,
            disabledBackgroundColor = MaterialTheme.colorScheme.disabledSecondary,
        )
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            leadingIconData?.let {
                Icon(
                    modifier = Modifier.size(LEADING_ICON_SIZE),
                    painter = painterResource(id = leadingIconData.iconDrawable),
                    contentDescription = leadingIconData.iconContentDescription?.let { desc ->
                        stringResource(
                            id = desc
                        )
                    }
                )
                Spacer(modifier = Modifier.width(Paddings.small))
            }
            Text(
                text = id?.let { stringResource(id = id) } ?: text,
                style = MaterialTheme.typography.button,
                modifier = Modifier.padding(Paddings.small)
            )
        }
    }

}

@Preview
@Composable
fun PrimaryButtonPreview() {
    MovieAppTheme {
        PrimaryButton(
            text = "SUBMIT"
        ) {

        }
    }
}
