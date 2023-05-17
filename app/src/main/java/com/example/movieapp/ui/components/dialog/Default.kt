package com.example.movieapp.ui.components.dialog

import androidx.compose.runtime.Composable
import com.example.movieapp.ui.models.DialogButton
import com.example.movieapp.ui.models.DialogContent
import com.example.movieapp.ui.models.DialogText
import com.example.movieapp.ui.models.DialogTitle

object DialogPopup

@Composable
fun DialogPopup.Default(
    title: String,
    bodyText: String,
    buttons: List<DialogButton>
) {
    BaseDialogPopup(
        dialogTitle = DialogTitle.Default(title),
        dialogContent = DialogContent.Default(
            DialogText.Default(bodyText)
        ),
        buttons = buttons
    )
}