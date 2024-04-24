package org.matrix.android.sdk.sample.compoment.pagemain

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.isSystemInDarkTheme
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessAlarm
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.filled.Today
import androidx.compose.material.icons.outlined.AccessAlarm
import androidx.compose.material.icons.outlined.MonitorWeight
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

import org.matrix.android.sdk.sample.AppTheme
import org.matrix.android.sdk.sample.compoment.DatePicker2
import org.matrix.android.sdk.sample.compoment.ExpandableCardViewModel

import org.matrix.android.sdk.sample.md_theme_dark_primaryContainer
import org.matrix.android.sdk.sample.md_theme_light_primaryContainer


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Suppress("UNUSED_PARAMETER","UNUSED_VARIABLE","unused","NAME_SHADOWING")
@Composable
fun Weight(navController: NavController,viewModel: ExpandableCardViewModel) {
    val dateText = remember { mutableStateOf("") }
//    val weightText = remember { mutableStateOf("") }
//    val bodyFatText = remember { mutableStateOf("") }
    val Bbq: ExpandableCardViewModel = viewModel()
    val bodyFatText = rememberSaveable { mutableStateOf("") }
    AppTheme {
        Scaffold(
            topBar = {
                Column {
                    TestAppbar2(navController = navController, onSaveClick = {
//                        viewModel.weightText.value = weightText.value
                    })}
            },
            bottomBar = {},
            floatingActionButton = {}
        ) { innerPadding ->
            Surface(modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier
                        .padding(innerPadding)
                        .padding(horizontal = 26.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Spacer(Modifier.size(18.dp))
                    Text(
                        text = "Date",
                        style = TextStyle(fontSize = 18.sp)
                    )
                    Spacer(Modifier.size(18.dp))
//                    SingleLineUnderlineTextField(
//                        text = viewModel.dateText.value,
//                        onTextChanged = { newText ->
//                            dateText.value = newText // 更新文本状态
//                        }
//                    )
                    SingleLineUnderlineTextField(
                        text = viewModel.weightday.value,
                        onTextChanged = { newText ->
                            viewModel.weightday.value = newText // 更新文本状态
                        }
                    )

                    Spacer(Modifier.size(55.dp))
                    Text(
                        text = "Weight(kg)",
                        style = TextStyle(fontSize = 18.sp)
                    )
                    Spacer(Modifier.size(18.dp))
                    var Bbq:ExpandableCardViewModel = viewModel
                    SingleLineUnderlineTextField(
                        text = viewModel.weightText.value,
                        onTextChanged = {
//                            weightText.value = newText // 更新文本状态
                            viewModel.weightText.value = it
                        }
                    )

                    Spacer(Modifier.size(55.dp))
                    Text(
                        text = "%Body Fat",
                        style = TextStyle(fontSize = 18.sp)
                    )
                    Spacer(Modifier.size(18.dp))
                    SingleLineUnderlineTextField(
                        text = viewModel.weightfat.value,
                        onTextChanged = { newText ->
                            viewModel.weightfat.value = newText // 更新文本状态
                        }
                    )

                    Spacer(Modifier.size(55.dp))

                }
            }

        }
    }
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Suppress("unused","UNUSED_PARAMETER")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestAppbar2(navController: NavController,onSaveClick: () -> Unit) {
    CenterAlignedTopAppBar(
        title = { Text(text = "Record weight", maxLines = 1, overflow = TextOverflow.Ellipsis) },
        navigationIcon = {
            IconButton(onClick = {

                navController.navigate("Overview")
            }) {
                Icon(
                    imageVector = Icons.Filled.Clear,
                    contentDescription ="Localized description"
                )
            }
        },
        actions = {
            IconButton(onClick = {
                onSaveClick()
                navController.navigate("Overview")
            }) {
                Text(text = "Save")
            }
        }
    )
}







@Composable
fun SingleLineUnderlineTextField(
    text: String,
    onTextChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = LocalTextStyle.current.copy(fontSize = 23.sp)
) {
    Box {
        BasicTextField(
            value = text,
            onValueChange = onTextChanged,
            modifier = modifier,
            textStyle = textStyle,
            cursorBrush = SolidColor(Color.Black) // 设置光标颜色为黑色
        )
        Box(
            Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.Black)
                .align(Alignment.BottomStart) // 将装饰条放置在底部
        )
    }
}


@Suppress("UNUSED_PARAMETER","UNUSED_VARIABLE","unused","NAME_SHADOWING")
@Composable
fun OverViewCard3(viewModel: ExpandableCardViewModel, heavytext:String) {
    val Bbq: ExpandableCardViewModel = viewModel()


    Column {
        Text(
            text = "Healthy",
            fontSize = 24.sp, // 设置字体大小
            fontWeight = FontWeight.Bold, // 设置字体粗细
//            color = Color(0xFFE8EDDE),
            modifier = Modifier.padding(start = 38.dp, top = 35.dp, end = 16.dp, bottom = 15.dp)
        )



        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            modifier = Modifier.padding(horizontal = 20.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(all = 8.dp)
                    .clip(RoundedCornerShape(18.dp)) // Adding rounded corners to the card
//            .background(backgroundColor) // Changing background color to the specified color
                    .padding(all = 12.dp) // Padding to create space between the border and content
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Weight",
                        fontSize = 20.sp,

//                color = fontcolor
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        fontSize = 36.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontStyle = FontStyle.Normal,
                        text ="$heavytext kg"
//                color = fontcolor
                    )
                    Spacer(modifier = Modifier.height(2.dp))
//                    Text(text = dateText.value)
                    Text(text = "Today")
                }

                // Add a horizontal space between the column and the image
                Spacer(modifier = Modifier.width(8.dp))
                val backgroundColor = if (isSystemInDarkTheme()) {
                    md_theme_dark_primaryContainer
                } else {
                    md_theme_light_primaryContainer
                }

                Column(modifier = Modifier.padding(horizontal = 12.dp)
                    .height(100.dp)) {
                    Box(modifier = Modifier
                        .padding(vertical = 18.dp)
                        .clip(CircleShape)
                        .size(68.dp)
                        .background(backgroundColor)
                        .clickable { }
                    ) {
                        Icon(modifier = Modifier
                            .fillMaxSize()
                            .padding(all = 10.dp),
                            imageVector = Icons.Outlined.MonitorWeight,
                            contentDescription = null,
                        )
                    }
                }

            }
        }
    }
}















//@Preview
//@Composable
//fun DatePicker2preview() {
//    AppTheme {
//        val navController = rememberNavController()
//        Weight(navController= navController,viewModel:bbq)
//
//    }
//}

//@Preview
//@Composable
//fun DatePicker3preview() {
//    AppTheme {
////        val navController = rememberNavController()
//        OverViewCard3(viewModel: bbq)
//    }
//}
//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//@Suppress("UNUSED_PARAMETER")
//@Composable
//fun OutlinedTF6(onDateSelected: (Long) -> Unit, dialogState: MutableState<Boolean>) { // 将dialogState作为参数传递进来
//    var text by rememberSaveable { mutableStateOf("") }
//
//
//    OutlinedTextField(
//        modifier = Modifier
//            .fillMaxWidth()
//            .clickable { dialogState.value = true },
//        value = text,
//        onValueChange = { text = it },
//        label = { Text("开始日期") },
//
//        )
//    // 如果对话框状态为 true，则显示日期选择器
//    if (dialogState.value) {
//        // 显示日期选择对话框，并将选定的日期传递给回调函数
//        DatePickerDialog(
//            onDateSelected = { selectedDate ->
//                onDateSelected(selectedDate) // 将选定的日期传递给回调函数
//                dialogState.value = false // 关闭日期选择对话框
//            },
//            onDismissRequest = {
//                dialogState.value = false // 关闭日期选择对话框
//            }
//        )
//    }
//
//}
//@Composable
//fun SingleLineUnderlineTextField2(
//    text: String,
//    onTextChanged: (String) -> Unit,
//    modifier: Modifier = Modifier,
//    textStyle: TextStyle = LocalTextStyle.current.copy(fontSize = 23.sp)
//) {
//    Box {
//        BasicTextField(
//            value = text,
//            onValueChange = onTextChanged,
//            modifier = modifier,
//            textStyle = textStyle,
//            cursorBrush = SolidColor(Color.Black) // 设置光标颜色为黑色
//        )
//        Box(
//            Modifier
//                .fillMaxWidth()
//                .height(1.dp)
//                .background(Color.Black)
//                .align(Alignment.BottomStart) // 将装饰条放置在底部
//        )
//    }
//}
//@Composable
//fun SingleLineUnderlineTextField3(
//    text: String,
//    onTextChanged: (String) -> Unit,
//    modifier: Modifier = Modifier,
//    textStyle: TextStyle = LocalTextStyle.current.copy(fontSize = 23.sp)
//) {
//    Box {
//        BasicTextField(
//            value = text,
//            onValueChange = onTextChanged,
//            modifier = modifier,
//            textStyle = textStyle,
//            cursorBrush = SolidColor(Color.Black) // 设置光标颜色为黑色
//        )
//        Box(
//            Modifier
//                .fillMaxWidth()
//                .height(1.dp)
//                .background(Color.Black)
//                .align(Alignment.BottomStart) // 将装饰条放置在底部
//        )
//    }
//}
