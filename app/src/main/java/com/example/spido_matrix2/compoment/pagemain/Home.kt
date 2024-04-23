//package com.example.spido.pagemain
//
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.navigation.NavController
//import androidx.navigation.compose.rememberNavController
//import org.matrix.android.sdk.sample.compoment.SootheBottomNavigation
//import org.matrix.android.sdk.sample.compoment.TestAppbar
//
//
//@Composable
//fun Home(navController: NavController){
//    Column(Modifier.fillMaxSize()) { // 使用 Column 包裹
//        TestAppbar(navController = navController)
//    }
//    Box(modifier = Modifier.fillMaxWidth(),contentAlignment = Alignment.Center){ }
//    Box(modifier = Modifier
//        .fillMaxSize(),
//        contentAlignment = Alignment.BottomEnd
//    ){
//        SootheBottomNavigation(navController = navController)
//    }
//
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//    ) {
//
//    }
//}
//@Preview(showBackground = true)
//@Composable
//fun Homepreview(){
//    val navController = rememberNavController() // 创建 NavController 对象
//    Home(navController = navController) // 将 NavController 对象传递给 Overview 函数
//}