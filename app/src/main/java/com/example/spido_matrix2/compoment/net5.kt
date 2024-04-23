package org.matrix.android.sdk.sample.compoment

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.OutlinedTextField
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.spido_matrix2.R
import org.matrix.android.sdk.sample.AppTheme


@OptIn(ExperimentalMaterialApi::class)


@Preview
@Composable
fun ExpandableCard4Preview() {
    AppTheme {
        val titletext = String()
        val maintext = String()
        val subtitle = String()
        ExpandableCard4(titletext,maintext, subtitle)
    }
}
@Composable
@Suppress("UNUSED_PARAMETER","UNUSED_VARIABLE","unused","NAME_SHADOWING")
fun ExpandableCard3(viewModel: ExpandableCardViewModel,titletext: String) {
    AppTheme {
        var expanded by remember { mutableStateOf(false) }
        Card(
            modifier = Modifier.padding(8.dp),
            onClick = { expanded = !expanded }
        ) {
            var name by remember { mutableStateOf("") }

            Box(
                modifier = Modifier
                    .width(180.dp)
                    .height(200.dp) // 设置图片占据卡片的上半部分
            ) {
                androidx.compose.material3.Card(
                    modifier = Modifier
                        .size(width = 550.dp, height = 270.dp),
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
                Spacer(modifier = Modifier.height(1.dp))
                Text(
                    text = viewModel.name.value,
                    modifier = Modifier.padding(bottom = 8.dp),
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    textAlign = TextAlign.Start, // 设置左对齐
                    fontSize = 20.sp
                )
                Text(
                    text = name,
                    modifier = Modifier.padding(bottom = 12.dp),
                    fontSize = 20.sp,
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    textAlign = TextAlign.Start // 设置左对齐
                )
                Text(
                    text = titletext,
                    textAlign = TextAlign.Start, // 设置左对齐,
                    modifier = Modifier.padding(top = 1.dp)
                )
                if (expanded) {
                    OutlinedTextField(value = viewModel.name.value,
                        onValueChange = { viewModel.name.value = it },
                        label = { Text("Name") }
                    )
                    Text(
                        text = "1",
                        fontSize = 16.sp,
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier
                            .width(148.dp)
                            .padding(vertical = 16.dp)
                    )
                }
            }
        }
    }
}


@Composable
fun ExpandableCard4(titletext: String,maintext: String,subtitle:String) {
    AppTheme {
        var expanded by remember { mutableStateOf(false) }
        Card(
            modifier = Modifier.padding(8.dp),

            onClick = { expanded = !expanded }
        ) {
            Box(
                modifier = Modifier
                    .width(180.dp)
                    .height(200.dp) // 设置图片占据卡片的上半部分
            ) {
                androidx.compose.material3.Card(
                    modifier = Modifier
                        .size(width = 550.dp, height = 270.dp),
                    shape = RoundedCornerShape(8.dp),

                    ) {
                    Image(
                        painter = painterResource(id = R.drawable.pexels), // 请用正确的文件名替换
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
                Spacer(modifier = Modifier.height(1.dp))
                Text(
                    text = titletext,
                    modifier = Modifier.padding(bottom = 12.dp),
                    fontSize = 20.sp,
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    textAlign = TextAlign.Start // 设置左对齐
                )
                Text(
                    text = subtitle,
                    textAlign = TextAlign.Start, // 设置左对齐,
                    modifier = Modifier.padding(top =1.dp)

                )
                if (expanded) {
                    Text(
                        text = maintext,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier
                            .width(148.dp)
                            .padding(vertical = 16.dp)
                    )
                }
            }
        }
    }
}
@Composable
fun ExpandableCard5() {
    AppTheme {
        var expanded by remember { mutableStateOf(false) }
        Card(
            modifier = Modifier.padding(8.dp),

            onClick = { expanded = !expanded }
        ) {
            Box(
                modifier = Modifier
                    .width(180.dp)
                    .height(200.dp) // 设置图片占据卡片的上半部分
            ) {
                androidx.compose.material3.Card(
                    modifier = Modifier
                        .size(width = 550.dp, height = 270.dp),
                    shape = RoundedCornerShape(8.dp),

                    ) {
                    Image(
                        painter = painterResource(id = R.drawable.pexels3), // 请用正确的文件名替换
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
                Spacer(modifier = Modifier.height(1.dp))
                Text(
                    text = "At Peace",
                    modifier = Modifier.padding(bottom = 12.dp),
                    fontSize = 20.sp,
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    textAlign = TextAlign.Start // 设置左对齐
                )
                Text(
                    text = "23 episodes",

                    textAlign = TextAlign.Start, // 设置左对齐,
                    modifier = Modifier.padding(top =1.dp)

                )
                if (expanded) {
                    Text(
                        text = "ss",
                        fontSize = 16.sp,
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier
                            .width(148.dp)
                            .padding(vertical = 16.dp)
                    )
                }
            }
        }
    }
}
@Composable
fun ExpandableCard6() {
    AppTheme {
        var expanded by remember { mutableStateOf(false) }
        Card(
            modifier = Modifier.padding(8.dp),

            onClick = { expanded = !expanded }
        ) {
            Box(
                modifier = Modifier
                    .width(180.dp)
                    .height(200.dp) // 设置图片占据卡片的上半部分
            ) {
                androidx.compose.material3.Card(
                    modifier = Modifier
                        .size(width = 550.dp, height = 270.dp),
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
                Spacer(modifier = Modifier.height(1.dp))
                Text(
                    text = "At Peace",
                    modifier = Modifier.padding(bottom = 12.dp),
                    fontSize = 20.sp,
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    textAlign = TextAlign.Start // 设置左对齐
                )
                Text(
                    text = "23 episodes",

                    textAlign = TextAlign.Start, // 设置左对齐,
                    modifier = Modifier.padding(top =1.dp)

                )
                if (expanded) {
                    Text(
                        text = "ss",
                        fontSize = 16.sp,
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier
                            .width(148.dp)
                            .padding(vertical = 16.dp)
                    )
                }
            }
        }
    }
}
