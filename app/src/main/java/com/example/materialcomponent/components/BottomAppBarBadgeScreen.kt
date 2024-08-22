package com.example.materialcomponent.components

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.ui.Modifier

@Composable
fun BottomAppBarBadgeScreen(){

    var selectedIndex by remember { mutableStateOf(0) }

    BottomAppBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.onSurface,
    ) {
        NavigationBar {
            NavigationBarItem(
                icon = {

                    BadgedBox(badge = { Text("5") }) {
                        Icon(
                            imageVector = Icons.Filled.Home,
                            contentDescription = "Home"
                        )
                    }
                },
                label = { Text("Home") },
                selected = selectedIndex == 0,
                onClick = { selectedIndex = 0 }
            )
            NavigationBarItem(
                icon = {
                    BadgedBox(
                        badge = { Text("3") }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Favorite,
                            contentDescription = "Favorite"
                        )
                    }
                },
                label = { Text("Favorites") },
                selected = selectedIndex == 1,
                onClick = { selectedIndex = 1 }
            )
            NavigationBarItem(
                icon = {
                    BadgedBox(
                        badge = { Text("99+") }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Notifications,
                            contentDescription = "Notifications"
                        )
                    }
                },
                label = { Text("Notifications") },
                selected = selectedIndex == 2,
                onClick = { selectedIndex = 2 }
            )
        }
    }

}
