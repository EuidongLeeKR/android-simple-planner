package com.example.simpleplanner.ui.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.simpleplanner.enums.BottomNavMenu
import com.example.simpleplanner.enums.StateKey
import com.example.simpleplanner.enums.StateMap

@Composable
fun BottomNavBar(
    state: StateMap
) {
    BottomAppBar {
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
                menu = BottomNavMenu.PHONE,
                state = state
            )
            ClickableIconButton(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                imageVector = Icons.Outlined.Face,
                menu = BottomNavMenu.FACE,
                state = state
            )
            ClickableIconButton(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                imageVector = Icons.Outlined.MailOutline,
                menu = BottomNavMenu.DASHBOARD,
                state = state
            )
            ClickableIconButton(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                imageVector = Icons.Outlined.AccountBox,
                menu = BottomNavMenu.SPRINT,
                state = state
            )
            ClickableIconButton(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                imageVector = Icons.Outlined.Favorite,
                menu = BottomNavMenu.FAVORITE,
                state = state
            )
        }
    }
}

@Composable
fun ClickableIconButton(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    menu: BottomNavMenu,
    state: StateMap
) {
    IconButton(
        modifier = modifier,
        onClick = {
            if (state[StateKey.SELECTED_MENU] !== menu) {
                // Do Something
                state[StateKey.SELECTED_MENU] = menu
            }
        }
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = menu.desc,
            tint = if (state[StateKey.SELECTED_MENU] == menu) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.surfaceDim
            }
        )
    }
}