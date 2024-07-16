package com.example.simpleplanner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.simpleplanner.enums.BottomNavMenu
import com.example.simpleplanner.enums.StateKey
import com.example.simpleplanner.ui.main.BottomNavBar
import com.example.simpleplanner.ui.main.dashboard.Dashboard
import com.example.simpleplanner.ui.main.TopNavBar
import com.example.simpleplanner.ui.theme.SimplePlannerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainContent()
        }
    }
}

@Preview
@Composable
private fun MainContent() {
    val states = remember {
        mutableStateMapOf<StateKey, Any?>(Pair(StateKey.SELECTED_MENU, BottomNavMenu.DASHBOARD))
    }
    SimplePlannerTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopNavBar()
            },
            bottomBar = {
                BottomNavBar(states)
            }) { innerPadding ->
            when (states[StateKey.SELECTED_MENU]) {
                BottomNavMenu.DASHBOARD ->
                    Dashboard(
                        modifier = Modifier.padding(innerPadding),
                        states
                    )
                BottomNavMenu.SPRINT -> Content2(Modifier.padding(innerPadding))
            }
        }
    }
}

@Composable
fun Content2(modifier: Modifier) {
    Text(
        modifier = modifier,
        text = "hi"
    )
}