package org.matrix.android.sdk.sample.compoment

import android.content.res.Configuration
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.matrix.android.sdk.sample.AppTheme
import org.matrix.android.sdk.sample.md_theme_dark_primary
import org.matrix.android.sdk.sample.md_theme_dark_primaryContainer
import org.matrix.android.sdk.sample.md_theme_light_primary
import org.matrix.android.sdk.sample.md_theme_light_primaryContainer


@Composable
fun OverViewCard1() {
    Column {
        Text(
            text = "Sleep",
            fontSize = 24.sp, // 设置字体大小
            fontWeight = FontWeight.Bold, // 设置字体粗细
//            color = Color(0xFFE8EDDE),
            modifier = Modifier.padding(start = 38.dp, top = 35.dp, end = 16.dp, bottom = 15.dp)
        )



        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            modifier = Modifier.padding(horizontal = 18.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(all = 8.dp)
                    .clip(RoundedCornerShape(18.dp)) // Adding rounded corners to the card
//            .background(backgroundColor) // Changing background color to the specified color
                    .padding(all = 18.dp) // Padding to create space between the border and content
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Duration",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
//                color = fontcolor
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        fontSize = 50.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontStyle = FontStyle.Normal,
                        text = "7hr 25m",
//                color = fontcolor
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(text = "today")
                }

                // Add a horizontal space between the column and the image
                Spacer(modifier = Modifier.width(8.dp))
                val backgroundColor = if (isSystemInDarkTheme()) {
                    md_theme_dark_primaryContainer
                } else {
                    md_theme_light_primaryContainer
                }

                Column(modifier = Modifier.padding(horizontal = 12.dp)) {
                    Box(modifier = Modifier
                        .padding(vertical = 28.dp)
                        .clip(CircleShape)
                        .size(68.dp)
                        .background(backgroundColor)
                        .clickable { }
                    ) {
                        Icon(modifier = Modifier
                            .fillMaxSize()
                            .padding(all = 15.dp),
                            imageVector = Icons.Outlined.AccountCircle,
                            contentDescription = null,
                        )
                    }
                }

            }
        }}
}

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
fun Ovcard1Preview() {
    AppTheme {
        OverViewCard1()
    }
}



@Composable
fun OverViewCard2(isDarkTheme: Boolean) {
    Column {
        Text(
            text = "Health",
            fontSize = 24.sp, // 设置字体大小
            fontWeight = FontWeight.Bold, // 设置字体粗细
//            color = Color(0xFFE8EDDE),
            modifier = Modifier.padding(start = 38.dp, top = 0.dp, end = 16.dp, bottom = 15.dp)
        )
        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            modifier = Modifier.padding(horizontal = 18.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(all = 8.dp)
                    .clip(RoundedCornerShape(18.dp)) // Adding rounded corners to the card
                    .padding(all = 18.dp) // Padding to create space between the border and content
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Duration",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        //color = fontcolor
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        fontSize = 50.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontStyle = FontStyle.Normal,
                        text = "7hr 25m",
                        //color = fontcolor
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(text = "today")
                }

                // Add a horizontal space between the column and the image
                Spacer(modifier = Modifier.width(8.dp))

                // Second column containing the image
                Column(modifier = Modifier.padding(horizontal = 12.dp)) {
                    Box(modifier = Modifier
                        .padding(vertical = 2.dp)
                        .size(68.dp)
                        .clickable { }
                    ) {
                        Box(modifier = Modifier) {
                            Canvas(modifier = Modifier.matchParentSize()) {
                                val barWidth = 40f // 每个竖条的宽度
                                val barSpacing = 7f // 竖条之间的间距
                                val bars = listOf(150f, 150f, 150f, 150f, 150f, 150f, 150f, 150f) // 竖条的长度列表
                                var xPosition = 200f // 初始 x 位置

                                for (barHeight in bars) {
                                    // 绘制竖条
                                    drawLine(
                                        color = if (isDarkTheme) md_theme_dark_primaryContainer else md_theme_light_primaryContainer,
                                        start = Offset(xPosition, 255f),
                                        end = Offset(xPosition, 255f - barHeight),
                                        strokeWidth = barWidth,
                                        cap = StrokeCap.Round
                                    )
                                    // 更新 x 位置
                                    xPosition -= barSpacing + barWidth
                                }
                            }
                            Canvas(modifier = Modifier.matchParentSize()) {
                                val barWidth = 40f // 每个竖条的宽度
                                val barSpacing = 7f // 竖条之间的间距
                                val bars = listOf(125f, 150f, 32f, 150f, 150f, 144f, 150f, 40f) // 竖条的长度列表
                                var xPosition = 200f // 初始 x 位置

                                for (barHeight in bars) {
                                    // 绘制竖条
                                    drawLine(
                                        color = if (isDarkTheme) md_theme_dark_primary else md_theme_light_primary,
                                        start = Offset(xPosition, 255f),
                                        end = Offset(xPosition, 255f - barHeight),
                                        strokeWidth = barWidth,
                                        cap = StrokeCap.Round
                                    )
                                    // 更新 x 位置
                                    xPosition -= barSpacing + barWidth
                                }
                            }
                        }
                    }
                }
            }}
    }
}




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
fun Cardpreview() {
    AppTheme {
        val isDarkTheme = isSystemInDarkTheme()
        OverViewCard2(isDarkTheme)
    }
}

