package org.matrix.android.sdk.sample.compoment.pagemain

import android.os.Bundle
import android.widget.FrameLayout
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.fragment.FragmentNavigator
import com.example.spido_matrix2.ui.RoomListFragment
import org.matrix.android.sdk.sample.compoment.ExpandableCard5
import org.matrix.android.sdk.sample.compoment.ExpandableCard6
import org.matrix.android.sdk.sample.compoment.HappyBar
import org.matrix.android.sdk.sample.compoment.HappyCard
import org.matrix.android.sdk.sample.compoment.SootheBottomNavigation3


@Composable

fun Community(navController: NavController) {
    Scaffold(
        topBar = {
            Column {
            }
        },
        bottomBar = {
            SootheBottomNavigation3(navController = navController)
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier.padding(innerPadding)
        ) {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
            ) {
                // 使用AndroidView嵌入RoomListFragment
                AndroidView(factory = { context ->
                    // 创建RoomListFragment实例
                    val fragment = RoomListFragment()
                    // 获取Fragment的根布局
                    val view = fragment.requireView()
                    // 返回根布局
                    view
                })
            }
        }
    }
}


@Preview(showBackground = true)
@Composable

fun CommunityPreview() {
    val navController = rememberNavController() // 创建 NavController 对象
    Community(navController = navController) // 将 NavController 对象传递给 Overview 函数
}
