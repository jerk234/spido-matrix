package com.example.spido_matrix2.compoment.Cardpages

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.PlayCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.spido_matrix2.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

@Composable
fun Cardpage(navController: NavController){
    Scaffold (
        topBar = {
        Topbarcp(navController = navController)
    }
    ){
        Surface {
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(420.dp) // 设置图片占据卡片的上半部分
                ) {
                    androidx.compose.material3.Card(
                        modifier = Modifier
                            .size(width = 550.dp, height = 470.dp),
                        shape = RoundedCornerShape(0.dp),

                        ) {
                        Image(
                            painter = painterResource(id = R.drawable.pexels2), // 请用正确的文件名替换
                            contentDescription = "Your Image",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop // 填满整个区域
                        )
                    }
                }
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Lifts Trainning make you stronger",
                        fontSize = 30.sp,
                        modifier = Modifier.padding(all = 16.dp))
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp)) {
                        Icon(
                            imageVector = Icons.Outlined.PlayCircle,
                            contentDescription = null)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(modifier = Modifier.fillMaxHeight(1f),text = "19 min · fitness"
                        , fontSize = 20.sp,
                            fontWeight = FontWeight.Light)
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Button(onClick = { /*TODO*/ }, modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 14.dp)) {
                        Text(text = "Start",fontSize = 16.sp,)
                    }
                    Text(text = "Compound lifts like squats, deadlifts, bench presses, and overhead " +
                            "presses are great for building overall strength and muscle mass. Include these i" +
                            "n your routine for a solid foundation.",
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Light,
                        modifier = Modifier.padding(all = 16.dp))

                    Text(text = "Device",modifier = Modifier.padding(all = 16.dp),
                        fontSize = 19.sp,)
                    Text(text = "Barbells · Dumbbells",modifier = Modifier.padding(start = 16.dp),
                        fontSize = 18.5.sp,fontWeight = FontWeight.W300)
                }
            }
        }

    }
}





@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Suppress("UNUSED_PARAMETER")
@Composable
fun Topbarcp(navController: NavController) {
    var isPressed by remember { mutableStateOf(false) }
    Column(modifier = Modifier
        .fillMaxWidth(1f)
        .padding(all = 8.dp)) {
        Row(modifier = Modifier.fillMaxWidth(1f)) {
            IconButton(onClick = { navController.navigateUp() },
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Localized description",tint = Color.White

                )
            }
            Spacer(modifier = Modifier.weight(1f)) // 占位符
            IconButton(
                onClick = {
                    isPressed = !isPressed
                }
            ) {
                val icon = if (isPressed) {
                    Icons.Outlined.Bookmark // 改变图标为按下状态时的图标
                } else {
                    Icons.Outlined.BookmarkBorder // 默认图标
                }

                Icon(
                    modifier = Modifier.weight(1f),
                    imageVector = icon,
                    contentDescription = "Localized description",
                    tint = Color.White
                )
            }
        }

    }
}

@Preview
@Composable
fun Cardpagepv(){
    val navController = rememberNavController()
    Cardpage(navController = navController)
}