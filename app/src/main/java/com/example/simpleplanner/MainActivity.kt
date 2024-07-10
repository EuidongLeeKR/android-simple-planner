package com.example.simpleplanner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.simpleplanner.ui.common.BottomNavBar
import com.example.simpleplanner.ui.common.TopNavBar
import com.example.simpleplanner.ui.theme.SimplePlannerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Content()
        }
    }
}

@Preview
@Composable
private fun Content() {
    SimplePlannerTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopNavBar()
            },
            bottomBar = {
                BottomNavBar()
            },
            floatingActionButton = {
                FloatingActionButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
                }
            }) { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SprintProgress()
            }
        }
    }
}

@Composable
fun SprintProgress() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "스프린트 진행도"
        )
        LinearProgressIndicator(
            progress = { 0.8F }
        )
    }
}