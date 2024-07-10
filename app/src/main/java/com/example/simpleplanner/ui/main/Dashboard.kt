package com.example.simpleplanner.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.simpleplanner.enums.BottomNavMenu
import com.example.simpleplanner.enums.StateKey
import com.example.simpleplanner.enums.StateMap

@Composable
fun Dashboard(
    modifier: Modifier = Modifier,
    state: StateMap
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        SprintDashboard(state = state)
    }
}

@Composable
fun SprintDashboard(
    modifier: Modifier = Modifier,
    state: StateMap
) {
    Row(
        modifier = Modifier.padding(20.dp)
    ) {
        Box(
            modifier = modifier.then(
                Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.surfaceContainer)
                    .clickable {
                        state[StateKey.SELECTED_MENU] = BottomNavMenu.SPRINT
                    }
            ),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "현재 스프린트",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "86%",
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
    }
}