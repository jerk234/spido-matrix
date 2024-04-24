package org.matrix.android.sdk.sample.compoment

import android.content.res.Configuration
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AppRegistration
import androidx.compose.material.icons.filled.DensitySmall
import androidx.compose.material.icons.filled.MarkUnreadChatAlt

import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Radar
import androidx.compose.material.icons.filled.RunCircle
import androidx.compose.material.icons.filled.Today
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.spido_matrix2.R
import org.matrix.android.sdk.sample.AppTheme


@Composable

fun CustomProgressBar(
    imageResId: Int,
    startColor: Color,
    endColor: Color,
    sweepAngle: Float,
    strokeWidth: Dp,
    modifier: Modifier = Modifier
) {
    val strokeStyle = remember { Stroke(width = strokeWidth.value, cap = StrokeCap.Round) }

    Box(
        modifier = modifier
            .size(90.dp)
            .padding(vertical = 1.dp, horizontal = 1.dp)
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = null,
            modifier = Modifier
                .size(width = 900.dp, height = 900.dp)
                .background(Color.Transparent),
            contentScale = ContentScale.Inside
        )

        Canvas(modifier = Modifier.fillMaxSize()) {
            // Background Arc
            drawArc(
                color = startColor,
                startAngle = 140f,
                sweepAngle = 260f,
                useCenter = false,
                style = strokeStyle
            )

            // Foreground Arc
            drawArc(
                color = endColor,
                startAngle = 140f,
                sweepAngle = sweepAngle,
                useCenter = false,
                style = strokeStyle
            )
        }
    }
}

@Preview
@Composable
fun CustomProgressBarPreview() {
    val configuration = LocalConfiguration.current
    val isDarkMode = configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES

    // 根据当前的 UI 模式选择要使用的图片资源
    val progressBarImageResIds = if (isDarkMode) {
        listOf(R.drawable.b0, R.drawable.b1, R.drawable.b2, R.drawable.b3)
    } else {
        listOf(R.drawable.x0, R.drawable.x1, R.drawable.x2, R.drawable.x3)
    }

    // 根据当前的 UI 模式设置不同的颜色
    val startColor = if (isDarkMode) Color(android.graphics.Color.parseColor("#0D4400")) else Color(android.graphics.Color.parseColor("#E8EDDE"))
    val endColor = if (isDarkMode) Color(android.graphics.Color.parseColor("#6FB650")) else Color(android.graphics.Color.parseColor("#3B6A1C"))
    @Suppress("UNUSED_VARIABLE")
    val darkGrayColor = Color(0xFF141613)
    MaterialTheme {
        Column(
            modifier = Modifier
                .background(if (isDarkMode) Color(0xFF141613) else Color(0xFFFCFDF3)) // 设置背景颜色，根据当前的 UI 模式
                .fillMaxWidth() // 填充父布局
        ) {
            CustomProgressBar(
                imageResId = progressBarImageResIds[0],
                startColor = startColor,
                endColor = endColor,
                sweepAngle = 180f,
                strokeWidth = 40.dp,
                modifier = Modifier
                    .size(200.dp)
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
            )

            Row(
                modifier = Modifier.size(width = 540.dp, height = 200.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CustomProgressBar(
                    imageResId = progressBarImageResIds[1],
                    startColor = startColor,
                    endColor = endColor,
                    sweepAngle = 270f,
                    strokeWidth = 23.dp,
                )

                CustomProgressBar(
                    imageResId = progressBarImageResIds[2],
                    startColor = startColor,
                    endColor = endColor,
                    sweepAngle = 120f,
                    strokeWidth = 23.dp,
                )

                CustomProgressBar(
                    imageResId = progressBarImageResIds[3],
                    startColor = startColor,
                    endColor = endColor,
                    sweepAngle = 240f,
                    strokeWidth = 23.dp,
                )
            }
        }
    }
}

//
//@OptIn(ExperimentalMaterial3Api::class)
//@Suppress("UNUSED_PARAMETER")
//@Composable//标题栏1
//fun topappbarA(navController: NavController){
//    androidx.compose.material.TopAppBar(
//        modifier = Modifier.fillMaxWidth()
////            .height(80.dp), // 设置首选高度为80dp
//        , backgroundColor = Color(0xFFF1F3E9)
//    ) {
//        Spacer(modifier = Modifier.width(12.dp))
//        androidx.compose.material.IconButton(onClick = { /*TODO*/ }) {
//            Icon(imageVector = Icons.Default.DensitySmall, contentDescription = null)
//        }
//
//        Spacer(modifier = Modifier.width(19.dp))
//        Text(
//            text = "               Firearms wiki",
//            textAlign = TextAlign.Center,
//            modifier = Modifier.weight(1f)
//        )
//
//        Spacer(modifier = Modifier.width(100.dp))
////        IconButton(onClick = { /*TODO*/ }) {
////            Icon(imageVector = Icons.Default.AttachFile, contentDescription = null)
////        }
////
////        IconButton(onClick = { /*TODO*/ }) {
////            Icon(imageVector = Icons.Default.CalendarToday, contentDescription = null)
////        }
//
//        androidx.compose.material.IconButton(onClick = { /*TODO*/ }) {
//            Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
//        }
//    }
//}

//@OptIn(ExperimentalMaterial3Api::class)
//@Suppress("UNUSED_PARAMETER")
//@Composable//标题栏2
//fun topappbarB(){
//    androidx.compose.material.TopAppBar(
//        modifier = Modifier.fillMaxWidth(), backgroundColor = Color(0xFFF1F3E9)
//    ) {
//        Spacer(modifier = Modifier.width(12.dp))
//        androidx.compose.material.IconButton(onClick = { /*TODO*/ }) {
//            Icon(imageVector = Icons.Default.AppRegistration, contentDescription = null)
//        }
//
//        Spacer(modifier = Modifier.width(12.dp))
//        Text(
//            text = "                       Today",
//            textAlign = TextAlign.Center,
//            modifier = Modifier.weight(1f)
//        )
//
//
//        Spacer(modifier = Modifier.width(100.dp))
//        androidx.compose.material.IconButton(onClick = { /*TODO*/ }) {
//            Icon(imageVector = Icons.Default.Today, contentDescription = null)
//        }
//
//        androidx.compose.material.IconButton(onClick = { /*TODO*/ }) {
//            Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
//        }
//
////        IconButton(onClick = { /*TODO*/ }) {
////            Icon(imageVector = Icons.Default.DensitySmall, contentDescription = null)
////        }
//    }
//}

//@Composable//底边栏
//fun SootheBottomNavigationA() {
//    Box(
//        Modifier.navigationBarsPadding(),
//        contentAlignment = Alignment.BottomCenter
//    ) {
//        Row(
//            modifier = Modifier
//                .background(Color(0xFFECEFE3)) // 设置背景颜色为#ECEFE3
//                .fillMaxWidth()
//                .padding(1.dp),
//            horizontalArrangement = Arrangement.SpaceEvenly
//        ) {
//            NavigationBarItem(
//                icon = {
//                    androidx.compose.material3.Icon(
//                        imageVector = Icons.Default.Radar,
//                        contentDescription = null
//                    )
//                },
//                label = {
//                    androidx.compose.material3.Text(
//                        text = "Overview"
//                    )
//                },
//                selected = false,
//                onClick = {
//                    // navController.navigate("Overview")
//                },
//                modifier = Modifier.background(Color(0xFFECEFE3))
//            )
//            NavigationBarItem(
//                icon = {
//                    androidx.compose.material3.Icon(
//                        imageVector = Icons.Default.RunCircle,
//                        contentDescription = null
//                    )
//                },
//                label = {
//                    androidx.compose.material3.Text(
//                        text = "Fitness"
//                    )
//                },
//                selected = false,
//                onClick = {
//                    // navController.navigate("Fitness")
//                },
//                modifier = Modifier.background(Color(0xFFECEFE3))
//            )
//            NavigationBarItem(
//                icon = {
//                    androidx.compose.material3.Icon(
//                        imageVector = Icons.Default.MarkUnreadChatAlt,
//                        contentDescription = null
//                    )
//                },
//                label = {
//                    androidx.compose.material3.Text(
//                        text = "Community"
//                    )
//                },
//                selected = false,
//                onClick = {
//                    // navController.navigate("Community")
//                },
//                modifier = Modifier.background(Color(0xFFECEFE3))
//            )
//        }
//    }
//}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Default Preview Dark"
)

// see your app with light theme
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "Default Preview Dark"
)
@Composable
fun CustomProgressBarPreviewPreview() {
    AppTheme {
        CustomProgressBarPreview()
    }
}