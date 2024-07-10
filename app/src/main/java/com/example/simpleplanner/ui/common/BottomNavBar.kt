package com.example.simpleplanner.ui.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun BottomNavBar() {

    val selectedIcon = remember { mutableStateOf<String?>(null) }
    BottomAppBar(
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ClickableIconButton(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                imageVector = Icons.Outlined.Phone,
                contentDescription = "phone",
                parentState = selectedIcon
            )
            ClickableIconButton(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                imageVector = Icons.Outlined.Face,
                contentDescription = "face",
                parentState = selectedIcon
            )
            ClickableIconButton(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                imageVector = Icons.Outlined.AccountBox,
                contentDescription = "accountBox",
                parentState = selectedIcon
            )
            ClickableIconButton(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                imageVector = Icons.Outlined.Favorite,
                contentDescription = "favorite",
                parentState = selectedIcon
            )
        }
    }
}

@Composable
fun ClickableIconButton(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    contentDescription: String?,
    parentState: MutableState<String?>
) {
    IconButton(
        modifier = modifier,
        onClick = {
            if (parentState.value !== contentDescription) {
                // Do Something
                parentState.value = contentDescription
            }
        }
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = contentDescription,
            tint = if (parentState.value == contentDescription) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.surfaceDim
            }
        )
    }
}