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
import com.example.spido_matrix2.compoment.zxj
import org.matrix.android.sdk.sample.compoment.ExpandableCard3
import org.matrix.android.sdk.sample.compoment.ExpandableCardViewModel
import org.matrix.android.sdk.sample.compoment.HappyCard
import org.matrix.android.sdk.sample.compoment.HappyCard2
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
                            val intent = Intent(context, zxj::class.java)
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
//                    OutlinedTextField(value = viewModel.name.value,
//                        onValueChange = { newValue -> viewModel.name.value = newValue },
//                        label = { Text("Name") },
//                    )
                    val expandableCardViewModel: ExpandableCardViewModel = viewModel()
                    Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
                        ExpandableCard3(expandableCardViewModel,titletext =viewModel.name.value)
                        ExpandableCard3(expandableCardViewModel,titletext =viewModel.name.value)
                        ExpandableCard3(expandableCardViewModel,titletext =viewModel.name.value)
                        ExpandableCard3(expandableCardViewModel,titletext =viewModel.name.value)
                        ExpandableCard3(expandableCardViewModel,titletext =viewModel.name.value)
                    }
                    Text(
                        text = "  Like", modifier = Modifier
                            .padding(all = 4.dp)
                            .padding(start = 8.dp), fontSize = 25.sp
                    )
                    Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
                        HappyCard2()
                        HappyCard2()
                        HappyCard2()
                    }
//                    Text(
//                        text = "  Fit", modifier = Modifier
//                            .padding(all = 4.dp)
//                            .padding(start = 8.dp), fontSize = 25.sp
//                    )
                    Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
//                        HappyCard()
//                        HappyCard()
//                        HappyCard()
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