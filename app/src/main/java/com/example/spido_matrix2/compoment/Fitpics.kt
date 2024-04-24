package com.example.spido_matrix2.compoment

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.PlayCircle
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.spido_matrix2.R
import org.matrix.android.sdk.sample.AppTheme

@Composable
fun PicCardwithtext(
    navController: NavController,
    img: Int, // 图片资源 ID
    go:String,
    title:String
) {
    Card(
        onClick = { navController.navigate(go) },
        modifier = Modifier
            .padding(8.dp)
            .width(300.dp)
            .height(300.dp) // 调整卡片的大小以适应文本
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = img), // 使用传入的图片资源 ID
                contentDescription = "Your Image",
                modifier = Modifier.fillMaxSize(), // 图片填充整个 Box 区域
                contentScale = ContentScale.Crop // 填满整个区域
            )
            Column(modifier = Modifier.align(Alignment.BottomStart)) {
                Text(
                    text = title, // 替换为您想要显示的文本
                    style = TextStyle(color = Color.White), // 调整文本样式和颜色
                    modifier = Modifier
                        .padding(start = 16.dp) // 可选：调整文本与图片之间的间距
                    , fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .padding(start = 16.dp)
                        .padding(bottom = 16.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.PlayCircle,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = " 18 minute · Fitness", // 替换为您想要显示的文本
                        style = TextStyle(color = Color.White), // 调整文本样式和颜色
                        modifier = Modifier
                    )
                }

            }

        }
    }
}

//@Preview
//@Composable
//fun ExpandableCard4Preview() {
//    AppTheme {
//        val navController = rememberNavController()
//        val imageResource = "s"
//        PicCardwithtext(navController = navController, imageResource = imageResource)
//    }
//}