package com.example.movieapp.ui.components.dialog

import androidx.compose.runtime.Composable
import com.example.movieapp.ui.models.DialogButton
import com.example.movieapp.ui.models.DialogContent
import com.example.movieapp.ui.models.DialogText
import com.example.movieapp.ui.models.DialogTitle

@Composable
fun DialogPopup.Rating(
    movieName: String,
    rating: Float,
    buttons: List<DialogButton>
) {
    BaseDialogPopup(
        dialogTitle = DialogTitle.Large("Rate your Score!"),
        dialogContent = DialogContent.Rating(
            DialogText.Rating(
                text = movieName,
                rating = rating
            )
        ),
        buttons = buttons
    )
}