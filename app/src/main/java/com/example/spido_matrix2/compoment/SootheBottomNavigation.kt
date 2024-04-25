package org.matrix.android.sdk.sample.compoment

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MarkUnreadChatAlt
import androidx.compose.material.icons.filled.Radar
import androidx.compose.material.icons.filled.RunCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.spido_matrix2.ui.Roomactivity


@Suppress("UNUSED_VARIABLE","unused")
@Composable
fun SootheBottomNavigation(navController: NavController){
    var selectedNavItem by remember { mutableStateOf("Overview") }
    val context = LocalContext.current
    NavigationBar {
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp),
            horizontalArrangement = Arrangement.SpaceEvenly){
            NavigationBarItem(selected = true,
                onClick = { selectedNavItem = "Overview"
                    navController.navigate("Overview") }, icon = { Icon(
                imageVector = Icons.Default.Radar,
                contentDescription = null
                )},label = { Text(text = "Overview")})
            NavigationBarItem(selected = false,
                onClick = { selectedNavItem = "Fitness"
                    navController.navigate("Fitness") }, icon = { Icon(
                    imageVector = Icons.Default.RunCircle,
                    contentDescription = null
                )}, label = { Text(text = "Fitness")})
            NavigationBarItem(selected = false,
                onClick = {
                    val intent = Intent(context, Roomactivity::class.java)
                    context.startActivity(intent)
                }, icon = { Icon(
                    imageVector = Icons.Default.MarkUnreadChatAlt,
                    contentDescription = null
                )},label = { Text(text = "Community")})
        }
    }
}

@Suppress("UNUSED_VARIABLE","unused")
@Composable
fun SootheBottomNavigation2(navController: NavController) {
    var selectedNavItem by remember { mutableStateOf("Overview") }
    val context = LocalContext.current
    NavigationBar {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(1.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            NavigationBarItem(
                selected = false,
                onClick = {
                    selectedNavItem = "Overview"
                    navController.navigate("Overview")
                },
                icon = {
                    Icon(
                        imageVector = Icons.Default.Radar,
                        contentDescription = null
                    )
                },
                label = { Text(text = "Overview") })
            NavigationBarItem(
                selected = true,
                onClick = {
                    selectedNavItem = "Fitness"
                    navController.navigate("Fitness")
                },
                icon = {
                    Icon(
                        imageVector = Icons.Default.RunCircle,
                        contentDescription = null
                    )
                },
                label = { Text(text = "Fitness") })
            NavigationBarItem(
                selected = false,
                onClick = {
                    val intent = Intent(context, Roomactivity::class.java)
                    context.startActivity(intent)
                },
                icon = {
                    Icon(
                        imageVector = Icons.Default.MarkUnreadChatAlt,
                        contentDescription = null
                    )
                },
                label = { Text(text = "Community") })
        }
    }
}

//m
@Suppress("UNUSED_VARIABLE","unused")
@Composable
fun SootheBottomNavigation3(navController: NavController) {
    var selectedNavItem by remember { mutableStateOf("Overview") }
    val context = LocalContext.current
    NavigationBar {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(1.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            NavigationBarItem(
                selected = false,
                onClick = {
                    selectedNavItem = "Overview"
                    navController.navigate("Overview")
                },
                icon = {
                    Icon(
                        imageVector = Icons.Default.Radar,
                        contentDescription = null
                    )
                },
                label = { Text(text = "Overview") }
            )
            NavigationBarItem(
                selected = false,
                onClick = {
                    selectedNavItem = "Fitness"
                    navController.navigate("Fitness")
                },
                icon = {
                    Icon(
                        imageVector = Icons.Default.RunCircle,
                        contentDescription = null
                    )
                },
                label = { Text(text = "Fitness") }
            )
            NavigationBarItem(
                selected = true,
                onClick = {
                    val intent = Intent(context, Roomactivity::class.java)
                    context.startActivity(intent)
                },
                icon = {
                    Icon(
                        imageVector = Icons.Default.MarkUnreadChatAlt,
                        contentDescription = null
                    )
                },
                label = { Text(text = "Community") }
            )
        }
    }
}

