package org.matrix.android.sdk.sample.compoment

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Alarm
import androidx.compose.material.icons.filled.EmojiPeople
import androidx.compose.material.icons.filled.Height
import androidx.compose.material.icons.filled.MonitorWeight
import androidx.compose.material.icons.filled.Water
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


import kotlinx.coroutines.launch
import org.matrix.android.sdk.sample.AppTheme
import org.matrix.android.sdk.sample.compoment.pagemain.Weight

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Suppress("unused","UNUSED_PARAMETER")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
//@Preview
fun BottomSheet1(navController: NavController) {
    var openBottomSheet by rememberSaveable { mutableStateOf(false) }
    var skipPartiallyExpanded by remember { mutableStateOf(false) }
    var edgeToEdgeEnabled by remember { mutableStateOf(false) }

    val bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = skipPartiallyExpanded
    )
    var isDatePickerDialogVisible1 by remember { mutableStateOf(false) }

// App content
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {


        Button(
            onClick = { openBottomSheet = !openBottomSheet },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
//            Text(text = "日")
            Icon(
                Icons.Filled.Add,"Localized description",
                modifier = Modifier.size(46.dp))
        }
    }

// Sheet content
    if (openBottomSheet) {
        val windowInsets = if (edgeToEdgeEnabled)
            WindowInsets(0) else BottomSheetDefaults.windowInsets

        ModalBottomSheet(
            onDismissRequest = { openBottomSheet = false },
            sheetState = bottomSheetState,
            windowInsets = windowInsets
        ) {
            Row() {
                Text(
                    "Manual recording",
                    fontSize = 20.sp, // 设置字体大小为 18sp，你可以根据需要调整大小
                    modifier = Modifier.padding(start = 26.dp, top = 17.dp, bottom = 16.dp)
                )
            }
            Surface {



                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {


                    Button(
                        // Note: If you provide logic outside of onDismissRequest to remove the sheet,
                        // you must additionally handle intended state cleanup, if any.
                        onClick = {
//                        scope.launch { bottomSheetState.hide() }.invokeOnCompletion {
//                            if (!bottomSheetState.isVisible) {
//                                openBottomSheet = false
//                            }
//                        }
                            navController.navigate("Water")
                        }, modifier = Modifier
                            .weight(1f)
                            .align(Alignment.CenterVertically)
                            .padding(start = 20.dp)
                            .height(60.dp)
                    ) {

                        Row(
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(start = 1.dp)
                        ) {
                            Icon(
                                Icons.Filled.Water, // 设置睡眠时间图标
                                contentDescription = null,
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(Modifier.width(4.dp))
                            Text(text = "Drink")
                        }

                    }
                    Spacer(Modifier.width(18.dp))
                    Button(
                        // Note: If you provide logic outside of onDismissRequest to remove the sheet,
                        // you must additionally handle intended state cleanup, if any.
                        onClick = {
//                            scope.launch { bottomSheetState.hide() }.invokeOnCompletion {
//                                if (!bottomSheetState.isVisible) {
//                                    openBottomSheet = false
//                                }
//                            }

                            navController.navigate("sleeptime")
                        }, modifier = Modifier
                            .weight(1f)
                            .align(Alignment.CenterVertically)
                            .height(60.dp)
                            .padding(end = 20.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(start = 1.dp)
                        ) {
                            Icon(
                                Icons.Filled.Alarm, // 设置睡眠时间图标
                                contentDescription = null,
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(Modifier.width(4.dp))
                            Text(text = "Sleep")
                        }
                    }
                }
            }
            Spacer(Modifier.size(18.dp))//设置按钮行间距
            Surface {

                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {

                    Button(
                        // Note: If you provide logic outside of onDismissRequest to remove the sheet,
                        // you must additionally handle intended state cleanup, if any.
                        onClick = {
//                            scope.launch { bottomSheetState.hide() }.invokeOnCompletion {
//                                if (!bottomSheetState.isVisible) {
//                                    openBottomSheet = false
//                                }
//                            }
//                            selectedNavItem = "Fitness"
                            navController.navigate("Weight")
                        }, modifier = Modifier
                            .weight(1f)
                            .align(Alignment.CenterVertically)
                            .padding(start = 20.dp)
                            .height(60.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(start = 1.dp)
                        ) {
                            Icon(
                                Icons.Filled.MonitorWeight, // 设置睡眠时间图标
                                contentDescription = null,
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(Modifier.width(4.dp))
                            Text(text = "Weight")
                        }
                    }
                    Spacer(Modifier.width(18.dp))
                    Button(
                        // Note: If you provide logic outside of onDismissRequest to remove the sheet,
                        // you must additionally handle intended state cleanup, if any.
                        onClick = {
                            navController.navigate("Food")


                        }, modifier = Modifier
                            .weight(1f)
                            .align(Alignment.CenterVertically)
                            .padding(end = 20.dp)
                            .height(60.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(start = 1.dp)
                        ) {
                            Icon(
                                Icons.Filled.EmojiPeople, // 设置睡眠时间图标
                                contentDescription = null,
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(Modifier.width(4.dp))
                            Text(text = "Diet")
                        }
                    }

                }
            }
            Spacer(modifier = Modifier.size(50.dp))
        }
//            var text by remember { mutableStateOf("") }
        Spacer(modifier = Modifier.size(20.dp))
//            OutlinedTextField(
//                value = text,
//                onValueChange = { text = it },
//                modifier = Modifier.padding(horizontal = 16.dp),
//                label = { Text("Text field") }
//            )
//            Spacer(modifier = Modifier.size(10.dp))
//            Spacer(modifier = Modifier.size(30.dp))
    }
    if (isDatePickerDialogVisible1) {
        DatePickerAlertDialog(onDismissRequest = { isDatePickerDialogVisible1 = false })
    }
}










@Preview
@Composable
fun DatePicker2preview2() {
    AppTheme {
        val navController = rememberNavController()
        BottomSheet1(navController=navController)
    }
}





































//import androidx.compose.foundation.layout.*
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.RectangleShape
//import androidx.compose.ui.unit.dp
//import kotlinx.coroutines.launch
//
//@Composable
//fun BottomSheetWithElements() {
//    var openBottomSheet by remember { mutableStateOf(false) }
//    var skipPartiallyExpanded by remember { mutableStateOf(false) }
//    var edgeToEdgeEnabled by remember { mutableStateOf(false)}
//
//    val scope = rememberCoroutineScope()
//    val bottomSheetState = rememberModalBottomSheetState(
//        skipPartiallyExpanded = skipPartiallyExpanded
//    )
//
//    Column(
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center,
//        modifier = Modifier.fillMaxSize()
//    ) {
//        Button(
//            onClick = { openBottomSheet = true },
//            modifier = Modifier.padding(16.dp)
//        ) {
//            Text(text = "日")
//        }
//    }
//
//    if (openBottomSheet) {
//        val windowInsets =if (edgeToEdgeEnabled)
//            windowInsets(0)else BottomSheetDefaults.windowInsets
//        ModalBottomSheet(onDismissRequest = {openBottomSheet =false) },
//        she{
//
//        }
//}
//
//@Composable
//fun BottomSheetContent(
//    bottomSheetState: ModalBottomSheetState,
//    openBottomSheet: (Boolean) -> Unit
//) {
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp),
//        verticalArrangement = Arrangement.spacedBy(8.dp)
//    ) {
//        Row(
//            horizontalArrangement = Arrangement.spacedBy(8.dp),
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            // 第一行按钮
//            Button(
//                onClick = {
//                    openBottomSheet(false)
//                },
//                modifier = Modifier.weight(1f)
//            ) {
//                Text(text = "水")
//            }
//            Button(
//                onClick = {
//                    openBottomSheet(false)
//                },
//                modifier = Modifier.weight(1f)
//            ) {
//                Text(text = "火")
//            }
//        }
//        Row(
//            horizontalArrangement = Arrangement.spacedBy(8.dp),
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            // 第二行按钮
//            Button(
//                onClick = {
//                    openBottomSheet(false)
//                },
//                modifier = Modifier.weight(1f)
//            ) {
//                Text(text = "土")
//            }
//            Button(
//                onClick = {
//                    openBottomSheet(false)
//                },
//                modifier = Modifier.weight(1f)
//            ) {
//                Text(text = "金")
//            }
//        }
//    }
//}
//
//



























//
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.FlowColumnScopeInstance.align
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.material.Button
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Add
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.saveable.rememberSaveable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.vector.ImageVector
//import androidx.compose.ui.tooling.preview.Preview
//import org.matrix.android.sdk.sample.AppTheme
//
//
//@Preview
//@Composable
//fun hobbit(){
//
//    var opeanhobbit by rememberSaveable { mutableStateOf() }
//    AppTheme {
//        Column(
//            modifier = Modifier.fillMaxSize()
//        ) {
//            Button(onClick = { opeanhobbit = !opeanhobbit },
//            modifier = Modifier.align(Alignment.CenterHorizontally))
//            {
//                ButtonA(icon =Icons.Filled.Add) {
//
//                }
//
//            }
//
//        }
//
//    }
//}
//
//
//fun ButtonA(icon: ImageVector, onClick: () -> Unit)
//{
//
//}
//

















//fun hobbit(){
//    var openBottomSheet1 by rememberSaveable { mutableStateOf(false) }
//    var skipPartiallyExpanded by remember { mutableStateOf(false) }
//    val scope = rememberCoroutineScope()
//
//    // 创建 ModalBottomSheetState 对象，用于跟踪底部表单的状态
//    val bottomSheetState = rememberModalBottomSheetState(
//        skipPartiallyExpanded = skipPartiallyExpanded
//    )
//
//    AppTheme {
//        Box(modifier = Modifier.fillMaxSize()) {
//            Button(
//                onClick = { openBottomSheet1 = !openBottomSheet1 },
//                modifier = Modifier.size(size = 16.dp)) {
//                Text(text = "饮水")
//            }
//        }
//    }
//}