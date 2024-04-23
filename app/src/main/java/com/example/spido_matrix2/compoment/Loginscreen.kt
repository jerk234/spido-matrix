package org.matrix.android.sdk.sample.compoment

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.net.Uri

import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.googlefonts.Font
//import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

import com.example.spido_matrix2.SampleApp
import com.example.spido_matrix2.ui.RoomListFragment
import com.example.spido_matrix2.ui.theme.fontFamily
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.matrix.android.sdk.api.auth.data.HomeServerConnectionConfig
import org.matrix.android.sdk.sample.AppTheme


@Suppress("UNUSED_PARAMETER","UNUSED_VARIABLE","unused")
@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun LoginScreen(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var homeserver by remember { mutableStateOf("") }
    val context = LocalContext.current
    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center, // 垂直方向上居中对齐
            horizontalAlignment = Alignment.CenterHorizontally // 水平方向上居中对齐
        ) {
            ElevatedCard(
                onClick = { /* Do something */ },
                modifier = Modifier
                    .padding(all = 24.dp)
                    .padding(top = 55.dp)
                    .padding(bottom = 75.dp)
            ) {
                Card(modifier = Modifier) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        TopSection()
                        Column(
                            modifier = Modifier
                                .padding(horizontal = 25.dp)
                        ) {
                            TextField(
                                value = username,
                                onValueChange = { username = it },
                                label = { Text("Username") },
                                modifier = Modifier.fillMaxWidth()
                            )

                            Spacer(modifier = Modifier.height(16.dp))

                            // Password input
                            TextField(
                                value = password,
                                onValueChange = { password = it },
                                label = { Text("Password") },
                                modifier = Modifier.fillMaxWidth()
                            )

                            Spacer(modifier = Modifier.height(16.dp))

                            // Homeserver input
                            TextField(
                                value = homeserver,
                                onValueChange = { homeserver = it },
                                label = { Text("Homeserver") },
                                modifier = Modifier.fillMaxWidth()
                            )

                            Spacer(modifier = Modifier.height(16.dp))
                            Button(
                                onClick = {
                                    if (username.isNotEmpty() && password.isNotEmpty() && homeserver.isNotEmpty()) {

                                        // 在 CoroutineScope 中执行异步操作
                                        CoroutineScope(Dispatchers.Main).launch {
                                            try {
                                                val homeServerConnectionConfig = HomeServerConnectionConfig
                                                    .Builder()
                                                    .withHomeServerUri(Uri.parse(homeserver))
                                                    .build()

                                                val session = SampleApp.getMatrix(context)
                                                    .authenticationService().directAuthentication(
                                                        homeServerConnectionConfig,
                                                        username,
                                                        password,
                                                        "matrix-sdk-android2-sample"
                                                    )

                                                // 在协程中显示 Toast
                                                Toast.makeText(context, "Login successful!", Toast.LENGTH_SHORT).show()

                                                // 登录成功后，执行其他操作，例如导航到下一个目标
                                                navController.navigate("Community")
                                            } catch (e: Throwable) {
                                                // 在协程中显示 Toast
                                                Toast.makeText(context, "Authentication failed: ${e.message}", Toast.LENGTH_SHORT).show()
                                            }
                                        }
//https://matrix.org
                                    } else {
                                        // 在协程中显示 Toast
                                        Toast.makeText(context, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                                    } },
                                modifier = Modifier.align(Alignment.CenterHorizontally)
                            ) {
                                Text("Login")
                            }
                            Spacer(modifier = Modifier.height(32.dp))

                        }

                    }

                }
            }
        }
        Box(modifier = Modifier
            .fillMaxSize(),
            contentAlignment = Alignment.BottomEnd
        ){
            SootheBottomNavigation3(navController = navController)
        }
    }
}

//@Suppress("UNUSED_PARAMETER","UNUSED_VARIABLE","unused")
//@Composable
//fun LoginScreen(navController: NavController) {
//    var username by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }
//    var homeserver by remember { mutableStateOf("") }
//    val context = LocalContext.current
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        verticalArrangement = Arrangement.Center
//    ) {
//        // Username input
//        TextField(
//            value = username,
//            onValueChange = { username = it },
//            label = { Text("Username") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // Password input
//        TextField(
//            value = password,
//            onValueChange = { password = it },
//            label = { Text("Password") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // Homeserver input
//        TextField(
//            value = homeserver,
//            onValueChange = { homeserver = it },
//            label = { Text("Homeserver") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // Login button
//        Button(
//            onClick = {
//                if (username.isNotEmpty() && password.isNotEmpty() && homeserver.isNotEmpty()) {
//
//                    // 在 CoroutineScope 中执行异步操作
//                    CoroutineScope(Dispatchers.Main).launch {
//                        try {
//                            val homeServerConnectionConfig = HomeServerConnectionConfig
//                                .Builder()
//                                .withHomeServerUri(Uri.parse(homeserver))
//                                .build()
//
//                            val session = SampleApp.getMatrix(context)
//                                .authenticationService().directAuthentication(
//                                    homeServerConnectionConfig,
//                                    username,
//                                    password,
//                                    "matrix-sdk-android2-sample"
//                                )
//
//                            // 在协程中显示 Toast
//                            Toast.makeText(context, "Login successful!", Toast.LENGTH_SHORT).show()
//
//                            // 登录成功后，执行其他操作，例如导航到下一个目标
//                             navController.navigate("Community")
//                        } catch (e: Throwable) {
//                            // 在协程中显示 Toast
//                            Toast.makeText(context, "Authentication failed: ${e.message}", Toast.LENGTH_SHORT).show()
//                        }
//                    }
////https://matrix.org
//                } else {
//                    // 在协程中显示 Toast
//                    Toast.makeText(context, "Please fill in all fields", Toast.LENGTH_SHORT).show()
//                } },
//            modifier = Modifier.align(Alignment.CenterHorizontally)
//        ) {
//            Text("Login")
//        }
//    }
//}


@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun TopSection(){

    Spacer(modifier=Modifier.height(20.dp))
    Box(modifier = Modifier.fillMaxWidth(),contentAlignment = Alignment.Center){


        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(22.dp)){



            Column(horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "Spido",
                    fontSize = 45.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = fontFamily

                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text="Login",
                    fontWeight = FontWeight.Normal,
                    fontSize = 27.sp,
                )
            }
        }
    }
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun LoginTextFields(
    modifier: Modifier=Modifier,
    label:String

){
    OutlinedTextField(
        modifier=modifier,
        value="",
        onValueChange = {},
        label={
            Text(text=label, fontWeight = FontWeight.Light)
        }
    )
}

@Suppress("UNUSED_PARAMETER","UNUSED_VARIABLE","unused")
@Composable
fun LoginButton(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var homeserver by remember { mutableStateOf("") }
    val context = LocalContext.current
    Column(modifier = Modifier.padding(bottom = 67.dp)) {
        TextButton(
            modifier = Modifier,
            onClick = { /*TODO*/ }) {
            Text(text = "Forgot your password?")
        }
        Spacer(modifier = Modifier.height(14.dp))
        ElevatedButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            onClick = {
                if (username.isNotEmpty() && password.isNotEmpty() && homeserver.isNotEmpty()) {

                    // 在 CoroutineScope 中执行异步操作
                    CoroutineScope(Dispatchers.Main).launch {
                        try {
                            val homeServerConnectionConfig = HomeServerConnectionConfig
                                .Builder()
                                .withHomeServerUri(Uri.parse(homeserver))
                                .build()

                            val session = SampleApp.getMatrix(context)
                                .authenticationService().directAuthentication(
                                    homeServerConnectionConfig,
                                    username,
                                    password,
                                    "matrix-sdk-android2-sample"
                                )

                            // 在协程中显示 Toast
                            Toast.makeText(context, "Login successful!", Toast.LENGTH_SHORT).show()

                            // 登录成功后，执行其他操作，例如导航到下一个目标
                            // navController.navigate("destination")
                        } catch (e: Throwable) {
                            // 在协程中显示 Toast
                            Log.e("Login", "Authentication failed: ${e.message}", e)
                            Toast.makeText(context, "Authentication failed: ${e.message}", Toast.LENGTH_SHORT).show()
                        }
                    }
//https://matrix.org
                } else {
                    // 在协程中显示 Toast
                    Toast.makeText(context, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                }
            },

            ) {
            Text(
                text = "Log In",
                fontStyle = FontStyle.Normal,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.Q)
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "Default Preview Light",
    device = Devices.PIXEL_7_PRO
)
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Default Preview Dark"
)
@Composable
fun Loginscreenpreview(){
    val navController = rememberNavController()
    AppTheme {
        MaterialTheme {
            LoginScreen(navController = navController)
        }
    }
}