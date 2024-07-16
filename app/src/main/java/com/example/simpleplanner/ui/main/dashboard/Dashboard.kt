package com.example.simpleplanner.ui.main.dashboard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
    states: StateMap
) {
    Column(
        modifier = modifier.then(
            Modifier.padding(20.dp)
        ),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        SprintDashboard(states = states)
    }
}

@Composable
fun SprintDashboard(
    modifier: Modifier = Modifier,
    states: StateMap
) {
    Surface(
        shadowElevation = 50.dp,
        shape = RoundedCornerShape(7.dp)
    ) {
        Box(
            modifier = modifier.then(
                Modifier
                    .fillMaxWidth()
                    .padding(30.dp)
                    .clickable {
                        states[StateKey.SELECTED_MENU] = BottomNavMenu.SPRINT
                    }
            ),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "현재 스프린트",
                        style = MaterialTheme.typography.headlineSmall
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "${states[StateKey.SPRINT_START]} ~ ${states[StateKey.SPRINT_END]}",
                        style = MaterialTheme.typography.labelSmall
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                ProgressBar(states)
            }
        }
    }
}