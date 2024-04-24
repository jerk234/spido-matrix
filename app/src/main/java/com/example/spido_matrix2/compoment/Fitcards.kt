package com.example.spido_matrix2.compoment

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.PlayCircle
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.spido_matrix2.R
import org.matrix.android.sdk.sample.AppTheme

@Composable
fun fitcard(navController: NavController) {
    ElevatedCard(modifier = Modifier.padding(all = 8.dp),
        onClick = { navController.navigate("Cardpage") },
    ) {
        Box(
            modifier = Modifier
                .width(300.dp)
                .height(175.dp) // 设置图片占据卡片的上半部分
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(1f),
                shape = RoundedCornerShape(8.dp),

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
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start // 设置左对齐
        ) {
            Text(
                text = "Weelchair med ball cardio",
                modifier = Modifier.padding(bottom = 12.dp),
                fontSize = 20.sp,
                style = TextStyle(fontWeight = FontWeight.SemiBold),
                textAlign = TextAlign.Start // 设置左对齐
            )
            Row {
                Icon(imageVector = Icons.Outlined.PlayCircle, contentDescription = null)
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "18 minutes · Fitness",
                    textAlign = TextAlign.Start, // 设置左对齐,
                    modifier = Modifier.padding(top =1.dp),
                    fontSize = 16.sp,fontWeight = FontWeight.Normal

                )
            }

        }
    }
}
@Preview
@Composable
fun fitcardpv() {
    AppTheme {
        val navController = rememberNavController()
        fitcard(navController = navController)
    }
}