package com.example.simpleplanner.enums

import androidx.compose.runtime.snapshots.SnapshotStateMap

enum class StateKey {
    SELECTED_MENU
}

// 하단 메뉴 바 관련 상태
enum class BottomNavMenu(val desc: String) {
    DASHBOARD("dashboard"),
    SPRINT("sprint"),
    PHONE("phone"), // mock
    FACE("face"), // mock
    FAVORITE("favorite") // mock
}

typealias StateMap = SnapshotStateMap<StateKey, Any?>