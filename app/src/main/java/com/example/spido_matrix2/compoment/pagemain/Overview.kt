package com.example.spido.pagemain


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import org.commonmark.node.Text
import org.matrix.android.sdk.sample.compoment.AddButton
import org.matrix.android.sdk.sample.compoment.CustomProgressBarPreview
import org.matrix.android.sdk.sample.compoment.ExpandableCardViewModel
import org.matrix.android.sdk.sample.compoment.Happytopbar
import org.matrix.android.sdk.sample.compoment.OverViewCard1
import org.matrix.android.sdk.sample.compoment.OverViewCard2
import org.matrix.android.sdk.sample.compoment.SootheBottomNavigation
import org.matrix.android.sdk.sample.compoment.TestAppbar


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnrememberedMutableState")
@Suppress("UNUSED_PARAMETER","UNUSED_VARIABLE","unused","NAME_SHADOWING")
@Composable
fun Overview(navController: NavController,viewModel: ExpandableCardViewModel) {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            Column {
                TestAppbar(navController = navController)
                Happytopbar(navController = navController)
            }
        },
        bottomBar = {
            SootheBottomNavigation(navController = navController)
        },
        floatingActionButton = {
            AddButton()
        }

    ) { innerPadding ->
        Surface {
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .verticalScroll(rememberScrollState())
            ) {
                CustomProgressBarPreview()
//                Row(modifier = Modifier.fillMaxWidth()) {
//                    var name by remember { mutableStateOf("") }
//                    val expandableCardViewModel: ExpandableCardViewModel = viewModel()
//                    TextField(
//                        value = viewModel.name.value,
//                        onValueChange = {
//                            viewModel.name.value = it
//                        },
//                        label = { Text("输入文本") }
//                    )
//                }

                OverViewCard2(isDarkTheme = true)
                OverViewCard1()
                OverViewCard1()
            }
        }
    }
}






@Composable
@Preview(showBackground = true)
fun OverviewPreview() {
    val navController = rememberNavController()
    Overview(navController = navController, viewModel = viewModel())
}