package org.matrix.android.sdk.sample.compoment.pagemain

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessAlarm
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Today
import androidx.compose.material.icons.outlined.AccessAlarm
import androidx.compose.material.icons.outlined.LocalDrink
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.spido.pagemain.Overview

import org.matrix.android.sdk.sample.compoment.BottomSheet1
import org.matrix.android.sdk.sample.compoment.CustomProgressBarPreview
import org.matrix.android.sdk.sample.compoment.ExpandableCardViewModel

import org.matrix.android.sdk.sample.compoment.Happytopbar
import org.matrix.android.sdk.sample.compoment.OutlinedTF


import org.matrix.android.sdk.sample.compoment.OverViewCard1
import org.matrix.android.sdk.sample.compoment.OverViewCard2
import org.matrix.android.sdk.sample.compoment.SootheBottomNavigation
import org.matrix.android.sdk.sample.compoment.TestAppbar

import org.matrix.android.sdk.sample.md_theme_dark_primaryContainer
import org.matrix.android.sdk.sample.md_theme_light_primaryContainer
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.Duration
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale
import java.util.concurrent.TimeUnit

@Suppress("UNUSED_PARAMETER","UNUSED_VARIABLE","unused","NAME_SHADOWING","unsafe")
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

@Composable
fun sleeptime(navController: NavController,viewModel: ExpandableCardViewModel) {
    val (text2, setText2) = remember { mutableStateOf("") }
    val (text4, setText4) = remember { mutableStateOf("") }
    val (sleepTime, setSleepTime) = remember { mutableStateOf("") }
    val dialogState = remember { mutableStateOf(false) }
    fun parseTime(formatter: SimpleDateFormat, timeString: String): Date? {
        var time: Date? = null
        try {
            time = formatter.parse(timeString)
        } catch (e: ParseException) {
            try {
                val formatterWithSemicolon = SimpleDateFormat("HH;mm", Locale.getDefault())
                time = formatterWithSemicolon.parse(timeString.replace(';', ':'))
            } catch (e: ParseException) {
                Log.e("ParseTime", "Failed to parse time: $timeString")
            }
        }
        return time
    }


    fun calculateSleepTime(text2: String, text4: String) {
        if (text2.isNotEmpty() && text4.isNotEmpty()) {
            // 进行时间计算，这里假设输入的时间格式为HH:mm
            val formatter = SimpleDateFormat("HH:mm", Locale.getDefault())
            val time2 = parseTime(formatter, text2)
            val time4 = parseTime(formatter, text4)

            if (time2 != null && time4 != null) {
                val sleepDuration = time4.time - time2.time
                val hours = TimeUnit.MILLISECONDS.toHours(sleepDuration)
                val minutes = TimeUnit.MILLISECONDS.toMinutes(sleepDuration) % 60
                val formattedTime = String.format("%02d:%02d", hours, minutes)
                setSleepTime(formattedTime)
            } else {
                setSleepTime("Invalid Time")
            }
        } else {
            setSleepTime("")
        }
    }
    Scaffold(
        topBar = {
            Column {
                TestAppbar1(navController = navController)
            }
        },
        bottomBar = {

        },
        floatingActionButton = {
        }
    ) { innerPadding ->
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(horizontal = 26.dp)
                    .verticalScroll(rememberScrollState())
            ) {

                Spacer(Modifier.size(18.dp))
                Text(text = "Sleep time",
                    style = TextStyle(fontSize = 18.sp)
                )

//                OutlinedTF1(onDateSelected = {
//                    // 当选择日期时，执行相应的操作
//                    dialogState.value = false // 关闭对话框
//                    // 这里可以执行其他操作，例如将选定的日期传递给其他组件
//                },
//                    dialogState = dialogState // 将dialogState传递给OutlinedTF1
//                    )
                Spacer(Modifier.size(18.dp))
                val datefruit = remember { mutableStateOf("") }
                SingleLineUnderlineTextField(
                    text = viewModel.sleepa.value,
                    onTextChanged = { newText ->
                        viewModel.sleepa.value = newText // 更新文本状态
                    }
                )
//                OutlinedTF2( onValueChanged = {
//                        text ->
//                    setText2(text)
//                    // 在第二个输入框的值发生变化时，重新计算睡眠时间
//                    calculateSleepTime(text2, text4, )
//                })
//                Spacer(Modifier.size(18.dp))
//                Text(text = "起床时间",
//                    style = TextStyle(fontSize = 18.sp))
//
////                OutlinedTF3(onDateSelected = {
////                    // 当选择日期时，执行相应的操作
////                    dialogState.value = false // 关闭对话框
////                    // 这里可以执行其他操作，例如将选定的日期传递给其他组件
////                },
////                    dialogState = dialogState // 将dialogState传递给OutlinedTF1
////                )
//                Spacer(Modifier.size(18.dp))
////                OutlinedTF4(onValueChanged = { text ->
////                    setText4(text)
////                    // 在第四个输入框的值发生变化时，重新计算睡眠时间
////                    calculateSleepTime(text2, text4, )
////                })
//
//                SingleLineUnderlineTextField(
//                    text = datefruit.value,
//                    onTextChanged = { newText ->
//                        datefruit.value = newText // 更新文本状态
//                    }
//                )
                Spacer(Modifier.size(18.dp))
                Text(text = "Sleeping Time(hours)",
                    style = TextStyle(fontSize = 18.sp))
//                OverViewCard6( sleepTime = sleepTime)
                Spacer(Modifier.size(18.dp))
                val sleepTime = remember { mutableStateOf("") }
                var Bbq:ExpandableCardViewModel = viewModel
                SingleLineUnderlineTextField(
                    text = viewModel.sleepTime.value,
                    onTextChanged = {
                        viewModel.sleepTime.value = it // 更新文本状态
                    }
                )

            }
        }
    }

}


@Composable
fun OutlinedTF2(onValueChanged: (String) -> Unit){

    var text by rememberSaveable { mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = text,
        onValueChange = { text = it
            onValueChanged(it)},// 当值发生变化时，调用传入的回调函数
        label = { Text("Time") },
        leadingIcon = {
            // 这里放置您想要的图标
            Icon(
                imageVector = Icons.Default.AccessAlarm,
                contentDescription = null // 可选的内容描述
            )
        }
    )

}



@Composable
fun OutlinedTF4(onValueChanged: (String) -> Unit){

    var text by rememberSaveable { mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = text,
        onValueChange = { text = it
            onValueChanged(it)   },
        label = { Text("Time") },
        leadingIcon = {
            // 这里放置您想要的图标
            Icon(
                imageVector = Icons.Default.AccessAlarm,
                contentDescription = null // 可选的内容描述
            )
        },

    )

}



@Suppress("UNUSED_PARAMETER","UNUSED_VARIABLE","unused","NAME_SHADOWING")
@Composable
fun OverViewCard6(viewModel: ExpandableCardViewModel, sleepTime:String) {
    Column {
        val Bbq: ExpandableCardViewModel = viewModel()
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
                        text = "Sleep Duration",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
//                color = fontcolor
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        fontSize =36.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontStyle = FontStyle.Normal,
                        text = "$sleepTime h",
//                color = fontcolor
                    )
                    Spacer(modifier = Modifier.height(2.dp))
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
                            imageVector = Icons.Outlined.LocalDrink,
                            contentDescription = null,
                        )
                    }
                }

            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Suppress("UNUSED_PARAMETER")
@Composable
fun OutlinedTF1(onDateSelected: (Long) -> Unit, dialogState: MutableState<Boolean>) { // 将dialogState作为参数传递进来
    var text by rememberSaveable { mutableStateOf("") }


        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { dialogState.value = true },
            value = text,
            onValueChange = { text = it },
            label = { Text("开始日期") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Today,
                    contentDescription = null
                )
            }
        )
    // 如果对话框状态为 true，则显示日期选择器
    if (dialogState.value) {
        // 显示日期选择对话框，并将选定的日期传递给回调函数
        DatePickerDialog(
            onDateSelected = { selectedDate ->
                onDateSelected(selectedDate) // 将选定的日期传递给回调函数
                dialogState.value = false // 关闭日期选择对话框
            },
            onDismissRequest = {
                dialogState.value = false // 关闭日期选择对话框
            }
        )
    }

    }

@Composable
fun OutlinedTF6(){

    var text by rememberSaveable { mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = text,
        onValueChange = { text = it },
        label = { Text("时间")
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.AccessAlarm,
                contentDescription = null
            )
        }
    )

}


@Composable
fun DatePickerDialog(
    onDateSelected: (Long) -> Unit, // 回调函数，用于将选定的日期传递出去
    onDismissRequest: () -> Unit // 回调函数，用于关闭日期选择对话框
) {
    // 显示一个日期选择对话框
    Dialog(onDismissRequest = onDismissRequest) {
        Surface(
            modifier = Modifier.padding(16.dp),
            shape = MaterialTheme.shapes.medium
        ) {
            // 在表面上显示日期选择器组件
            DatePicker3(onDateSelected = onDateSelected)
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)

@Suppress("UNUSED_PARAMETER")
@Composable
fun DatePicker3(
    onDateSelected: (Long) -> Unit // 回调函数，当选择日期时调用并传递选定的日期时间戳
){
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            val datePickerState = rememberDatePickerState(initialDisplayedMonthMillis = 1578096000000)
            DatePicker(
                state = datePickerState,
                modifier = Modifier
                    .padding(16.dp)
            )

            Text(
                "Selected date timestamp: ${datePickerState.selectedDateMillis ?: "no selection"}",
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.size(20.dp))
        }
    }
}




@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Suppress("UNUSED_PARAMETER")
@Composable
fun OutlinedTF3(onDateSelected: (Long) -> Unit, dialogState: MutableState<Boolean>) { // 将dialogState作为参数传递进来
    var text by rememberSaveable { mutableStateOf("") }


    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { dialogState.value = true },
        value = text,
        onValueChange = { text = it },
        label = { Text("开始日期") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Today,
                contentDescription = null
            )
        }
    )
    // 如果对话框状态为 true，则显示日期选择器
    if (dialogState.value) {
        // 显示日期选择对话框，并将选定的日期传递给回调函数
        DatePickerDialog(
            onDateSelected = { selectedDate ->
                onDateSelected(selectedDate) // 将选定的日期传递给回调函数
                dialogState.value = false // 关闭日期选择对话框
            },
            onDismissRequest = {
                dialogState.value = false // 关闭日期选择对话框
            }
        )
    }

}





@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Suppress("unused","UNUSED_PARAMETER")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestAppbar1(navController: NavController) {
    CenterAlignedTopAppBar(
        title = { Text(text = "Record Sleep", maxLines = 1, overflow = TextOverflow.Ellipsis) },
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

                navController.navigate("Overview")
            }) {
                Text(text = "Save")
            }
        }
    )
}










//
//@Composable
//fun OutlinedTF2(){
//
//    var text by rememberSaveable { mutableStateOf("") }
//
//    OutlinedTextField(
//        modifier = Modifier.fillMaxWidth(),
//        value = text,
//        onValueChange = { text = it },
//        label = { Text("时间") },
//        leadingIcon = {
//            // 这里放置您想要的图标
//            Icon(
//                imageVector = Icons.Default.AccessAlarm,
//                contentDescription = null // 可选的内容描述
//            )
//        }
//    )
//
//}
//
//
//
//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//@Suppress("UNUSED_PARAMETER")
//@Composable
//fun OutlinedTFWithDatePicker(
//    onDateSelected: (Long) -> Unit // 回调函数，当选择日期时调用并传递选定的日期时间戳
//) {
//    var text by rememberSaveable { mutableStateOf("") }
//
//    // 声明一个状态用于标记日期选择器是否应该显示
//    val (showDatePicker, setShowDatePicker) = remember { mutableStateOf(false) }
//
//    // 当文本框被点击时，显示日期选择器
//    val onClick = {
//        setShowDatePicker(true)
//    }
//
//    // 当日期选择器中的日期被选中时，更新文本框的值，并隐藏日期选择器
//    val onDatePickerDateSelected: (Long) -> Unit = { selectedDate ->
//        text = SimpleDateFormat("yyyy-MM-dd").format(Date(selectedDate))
//        onDateSelected(selectedDate)
//        setShowDatePicker(false)
//    }
//
//    // 如果显示日期选择器，则显示日期选择器
//    if (showDatePicker) {
//        DatePicker3(onDateSelected = onDatePickerDateSelected)
//    }
//
//    // 显示带有点击事件的文本框
//    OutlinedTextField(
//        modifier = Modifier.fillMaxWidth(),
//        value = text,
//        onValueChange = { text = it },
//        label = { Text("开始日期") },
//        leadingIcon = {
//            // 这里放置您想要的图标
//            Icon(
//                imageVector = Icons.Default.Today,
//                contentDescription = null // 可选的内容描述
//            )
//        },
//        // 添加点击事件，当文本框被点击时显示日期选择器
//        onClick = onClick
//    )
//}











//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//@Suppress("UNUSED_PARAMETER")
//@Composable
//fun sleeptime(navController: NavController) {
//    Scaffold(
//        topBar = {
//            Column {
//                TestAppbar1(navController = navController)
//            }
//        },
//        bottomBar = {
//
//        },
//        floatingActionButton = {
////
//
//
//
//        }
//
//
//    ) { innerPadding ->
//        Surface (modifier = Modifier.fillMaxSize()){
//            Column(
//                modifier = Modifier
//                    .padding(innerPadding)
//                    .verticalScroll(rememberScrollState())
//            ) {
//                Spacer(Modifier.size(18.dp))
//                Text(text = "就寝时间")
//                Spacer(Modifier.size(18.dp))
//                OutlinedTF1(navController = navController)
//                Spacer(Modifier.size(18.dp))
//                OutlinedTF2()
//                Spacer(Modifier.size(18.dp))
//                Text(text = "起床时间")
//                Spacer(Modifier.size(18.dp))
//                OutlinedTF3()
//                Spacer(Modifier.size(18.dp))
//                OutlinedTF4()
//            }
//        }
//    }
//}
//
//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//@Suppress("UNUSED_PARAMETER")
//@Composable
//@Preview(showBackground = true)
//fun OverviewPreview() {
//    val navController = rememberNavController()
//    sleeptime(navController = navController)
//}
//
