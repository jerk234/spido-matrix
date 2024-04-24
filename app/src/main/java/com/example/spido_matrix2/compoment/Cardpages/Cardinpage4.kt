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
import androidx.compose.material.icons.outlined.PlayCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
fun Cardpage4(navController: NavController){
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
                    Card(
                        modifier = Modifier
                            .size(width = 550.dp, height = 470.dp),
                        shape = RoundedCornerShape(0.dp),

                        ) {
                        Image(
                            painter = painterResource(id = R.drawable.pexelsfit2), // 请用正确的文件名替换
                            contentDescription = "Your Image",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop // 填满整个区域
                        )
                    }
                }
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Now is time for Swimming",
                        fontSize = 30.sp,
                        modifier = Modifier.padding(all = 16.dp))
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp)) {
                        Icon(
                            imageVector = Icons.Outlined.PlayCircle,
                            contentDescription = null)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(modifier = Modifier.fillMaxHeight(1f),text = "1 h 20 min · fitness"
                            , fontSize = 20.sp,
                            fontWeight = FontWeight.Light)
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Button(onClick = { /*TODO*/ }, modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 14.dp)) {
                        Text(text = "Start",fontSize = 16.sp,)
                    }
                    Text(text = "Start Slow: If you're new to swimming or haven't swum in a while, start with shorter dista"+
                            "nces and gradually build up your endurance. Don't push yourself too hard initially.\n"+
                            "Focus on Technique: Proper technique is crucial in swimming to prevent injuries and improve " +
                                    "efficiency. Work on your breathing, body position, and stroke mechanics. Consider taking lessons " +
                                    "or working with a coach to refine your technique.",
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Light,
                        modifier = Modifier.padding(all = 16.dp))

                    Text(text = "Device",modifier = Modifier.padding(all = 16.dp),
                        fontSize = 19.sp,)
                    Text(text = "Swimming Pants · Swmming Glasses",modifier = Modifier.padding(start = 16.dp),
                        fontSize = 18.5.sp,fontWeight = FontWeight.W300)
                }
            }
        }

    }
}


@Preview
@Composable
fun Cardpag4pv(){
    val navController = rememberNavController()
    Cardpage(navController = navController)
}