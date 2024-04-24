/*
 * Copyright (c) 2020 New Vector Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.spido_matrix2.ui

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.spido.pagemain.Overview
import com.example.spido_matrix2.R
import com.example.spido_matrix2.SessionHolder
import com.example.spido_matrix2.sensor.SensorInfoScreen
import com.example.spido_matrix2.ui.RoomListFragment
import com.example.spido_matrix2.ui.SimpleLoginFragment
import org.matrix.android.sdk.sample.AppTheme
import org.matrix.android.sdk.sample.compoment.ExpandableCardViewModel
import org.matrix.android.sdk.sample.compoment.LoginScreen
import org.matrix.android.sdk.sample.compoment.Userallow
import org.matrix.android.sdk.sample.compoment.pagemain.Community
import org.matrix.android.sdk.sample.compoment.pagemain.Fitness


class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.statusBarColor = ContextCompat.getColor(this, R.color.divider)
        setContent {
            val expandableCardViewModel: ExpandableCardViewModel = viewModel()
            val navController = rememberNavController()
            this@MainActivity.navController = navController // Assigning to the class-level variable

            AppTheme {

                NavHost(navController = navController, startDestination = "Userallow") {

                    composable("LoginButton") {
                        LoginScreen(navController) }

                    composable("Userallow") {
                        Userallow(navController)
                    }
                    composable("LoginScreen") {
                        LoginScreen(navController)
                    }
                    composable("Overview") {
                        Overview(navController, expandableCardViewModel)
                    }
                    composable("Fitness") {
                        Fitness(navController,expandableCardViewModel)
                    }
                    composable("Community") {
                        Community(navController)
                    }
                    composable("SimpleLoginFragment"){
                        SimpleLoginFragment()
                    }
                    composable("SimpleLoginFragment") {
                        FragmentLoginScreen(navController = navController)
                    }

                    composable("sensorInfoScreen") {
                        val context = LocalContext.current
                        SensorInfoScreen(
                            context = context,
                            errorMessage = "Example Error Message",
                            onResetSteps = {}
                        )
                    }
                }
            }
        }
    }

    @Deprecated("Deprecated in Java")
    @Suppress("DEPRECATION")
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onBackPressed() {
        super.onBackPressed()
        // Intercept the back button press event and navigate to "Overview" always
        navController.navigate("Overview")
    }




    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressedDispatcher.onBackPressed()
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    private fun displayLogin() {
        val fragment = SimpleLoginFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
    }

    private fun displayRoomList() {
        val fragment = RoomListFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
    }
}

@Suppress("UNUSED_PARAMETER")
@Composable
fun FragmentLoginScreen(navController: NavController) {
    AndroidView(
        factory = { context ->
            // 使用布局加载器加载 XML 布局文件
            LayoutInflater.from(context).inflate(R.layout.fragment_login, null)
        }
    )
}
