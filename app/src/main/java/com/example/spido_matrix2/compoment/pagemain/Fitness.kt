package org.matrix.android.sdk.sample.compoment.pagemain


import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.spido_matrix2.R
import com.example.spido_matrix2.compoment.PicCardwithtext
import com.example.spido_matrix2.compoment.fitcard
import org.matrix.android.sdk.sample.compoment.ExpandableCard3
import org.matrix.android.sdk.sample.compoment.ExpandableCard5
import org.matrix.android.sdk.sample.compoment.ExpandableCard6
import org.matrix.android.sdk.sample.compoment.ExpandableCardViewModel
import org.matrix.android.sdk.sample.compoment.HappyCard

import org.matrix.android.sdk.sample.compoment.PoseActivity
import org.matrix.android.sdk.sample.compoment.SootheBottomNavigation2
import org.matrix.android.sdk.sample.compoment.TestAppbar


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Suppress("NAME_SHADOWING","UNUSED_PARAMETER","UNUSED_VARIABLE","unused")
fun Fitness(navController: NavController,viewModel: ExpandableCardViewModel) {
//    val backgroundColor2 = Color(0xFFF1F3E9)
//    val scrollState = rememberScrollState()
    val context = LocalContext.current
//    val navController = rememberNavController()
    var expanded by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TestAppbar(navController = navController)
        },
        bottomBar = {
            SootheBottomNavigation2(navController = navController)
        }
    ) { innerPadding ->
        Surface {
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .verticalScroll(rememberScrollState()),
            ) {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .horizontalScroll(rememberScrollState())
                ) {
                    OutlinedButton(modifier = Modifier.padding(horizontal = 6.dp),
                        onClick = {
                            val intent = Intent(context, PoseActivity::class.java)
                            context.startActivity(intent)
                        }) {
                        Text(text = "Sit-ups")
                    }
                    OutlinedButton(modifier = Modifier.padding(horizontal = 6.dp),
                        onClick = { /*TODO*/ }) {
                        Text(text = "Swimming")
                    }
                    OutlinedButton(modifier = Modifier.padding(horizontal = 6.dp),
                        onClick = { /*TODO*/ }) {
                        Text(text = "Running")
                    }
                    OutlinedButton(modifier = Modifier.padding(horizontal = 6.dp),
                        onClick = { /*TODO*/ }) {
                        Text(text = "Tennis")
                    }
                }
                Column {var name by remember { mutableStateOf("") }
                    Text(
                        text = "  Special", modifier = Modifier
                            .padding(all = 4.dp)
                            .padding(start = 8.dp), fontSize = 25.sp
                    )
                    val expandableCardViewModel: ExpandableCardViewModel = viewModel()
                    Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
                        PicCardwithtext(navController,
                            img = R.drawable.pexels2,go = "Cardpage",title = "Lifts Trainning make you stronger")
                        PicCardwithtext(navController,
                            img = R.drawable.pexelsfit4,go = "Cardpage2",title = "Start your yoga routine")
                        PicCardwithtext(navController,
                            img = R.drawable.pexelsfit1,go = "Cardpage3",title = "Sure, here are some cycling exercise tips")
                        PicCardwithtext(navController,
                            img = R.drawable.pexelsfit2,go = "Cardpage4",title = "Now is time for Swimming")
                    }
                    Text(
                        text = "  Like", modifier = Modifier
                            .padding(all = 4.dp)
                            .padding(start = 8.dp), fontSize = 25.sp
                    )
                    Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
                        fitcard(navController,
                            img = R.drawable.pexelsfit1,go = "Cardpage3",title = "Cycling exercise tips")
                        fitcard(navController,
                            img = R.drawable.pexelsfit2,go = "Cardpage4",title = "Now is time for Swimming")
                        fitcard(navController,
                            img = R.drawable.pexelsfit4,go = "Cardpage2",title = "Start your yoga routine")
                    }
                    Text(
                        text = "  Fit", modifier = Modifier
                            .padding(all = 4.dp)
                            .padding(start = 8.dp), fontSize = 25.sp
                    )
                    Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
                        fitcard(navController,
                            img = R.drawable.pexelsfit1,go = "Cardpage3",title = "Cycling exercise tips")
                        fitcard(navController,
                            img = R.drawable.pexelsfit2,go = "Cardpage4",title = "Now is time for Swimming")
                        fitcard(navController,
                            img = R.drawable.pexels2,go = "Cardpage",title = "Lifts Trainning make you stronger")
                    }
                }
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun FitnessPreview(){
    val navController = rememberNavController() // 创建 NavController 对象
    Fitness(navController=navController, viewModel = ExpandableCardViewModel()) // 将 NavController 对象传递给 Overview 函数
}