package com.example.spido.pagemain


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

import org.matrix.android.sdk.sample.compoment.BottomSheet1
import org.matrix.android.sdk.sample.compoment.CustomProgressBarPreview
import org.matrix.android.sdk.sample.compoment.ExpandableCardViewModel
import org.matrix.android.sdk.sample.compoment.Happytopbar
import org.matrix.android.sdk.sample.compoment.OverViewCard1
import org.matrix.android.sdk.sample.compoment.OverViewCard2
import org.matrix.android.sdk.sample.compoment.SootheBottomNavigation
import org.matrix.android.sdk.sample.compoment.TestAppbar
import org.matrix.android.sdk.sample.compoment.pagemain.OverViewCard3
import org.matrix.android.sdk.sample.compoment.pagemain.OverViewCard4
import org.matrix.android.sdk.sample.compoment.pagemain.OverViewCard5
import org.matrix.android.sdk.sample.compoment.pagemain.OverViewCard6


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnrememberedMutableState")
@Suppress("UNUSED_PARAMETER","UNUSED_VARIABLE","unused","NAME_SHADOWING")
@Composable
fun Overview(navController: NavController, viewModel: ExpandableCardViewModel) {
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
//            AddButton()
            BottomSheet1(navController = navController)
        }

    ) { innerPadding ->
        Surface {
            val Bbq: ExpandableCardViewModel = viewModel()
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

                OverViewCard3(Bbq,heavytext = viewModel.weightText.value)
                OverViewCard4(Bbq, titletext = viewModel.waterml.value)
                OverViewCard5(Bbq, foodtext = viewModel.workfood.value)
                OverViewCard6(Bbq, sleepTime = viewModel.sleepTime.value)
            }
        }
    }
}






@Composable
@Preview(showBackground = true)
fun OverviewPreview() {
    val navController = rememberNavController()
    Overview(navController = navController, viewModel = viewModel(), )
}