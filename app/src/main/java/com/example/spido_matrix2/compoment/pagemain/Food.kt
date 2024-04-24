package org.matrix.android.sdk.sample.compoment.pagemain

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.outlined.AccessAlarm
import androidx.compose.material.icons.outlined.Fastfood
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
//import com.example.spido_matrix2.compoment.bbq
import com.example.spido_matrix2.ui.theme.fontFamily
import org.matrix.android.sdk.sample.AppTheme
import org.matrix.android.sdk.sample.compoment.ExpandableCardViewModel

import org.matrix.android.sdk.sample.md_theme_dark_primaryContainer
import org.matrix.android.sdk.sample.md_theme_light_primaryContainer




@Suppress("UNUSED_PARAMETER","UNUSED_VARIABLE","unused","NAME_SHADOWING")
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Food(navController: NavController, viewModel: ExpandableCardViewModel) {
    val workfood = remember { mutableStateOf("") }

    val datefruit = remember { mutableStateOf("") }


    AppTheme {
        Scaffold(
            topBar = {

                TestAppbar4(navController = navController, onSaveClick = {


                })
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
                    Spacer(Modifier.size(38.dp))
                    Text(
                        text = "How many calories did you eat today?",
                        style = TextStyle(fontSize = 18.sp)
                    )
                    Spacer(Modifier.size(18.dp))
                    SingleLineUnderlineTextField(
                        text = viewModel.workfood.value,
                        onTextChanged = {
                            viewModel.workfood.value = it
                        }
                    )
                    Spacer(Modifier.size(48.dp))
                    Text(
                        text = "Fruit quantity",
                        style = TextStyle(fontSize = 18.sp)
                    )
                    Spacer(Modifier.size(18.dp))
                    SingleLineUnderlineTextField(
                        text = viewModel.fooda.value,
                        onTextChanged = {
                            viewModel.fooda.value = it
                        }
                    )
                }
            }
        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Suppress("unused","UNUSED_PARAMETER")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestAppbar4(navController: NavController, onSaveClick: () -> Unit) {
    CenterAlignedTopAppBar(
        title = { Text(text = "Add food intake", maxLines = 1, fontFamily = fontFamily, overflow = TextOverflow.Ellipsis) },
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
            }){
                Text(text = "Save")
            }
        }
    )
}
@Suppress("UNUSED_PARAMETER","UNUSED_VARIABLE","unused","NAME_SHADOWING")
@Composable
fun OverViewCard5(viewModel: ExpandableCardViewModel,foodtext:String) {
    Column {
        val Bbq: ExpandableCardViewModel = viewModel()
        Text(
            text = "Food",
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
                        text = "Diet",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
//                color = fontcolor
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        fontSize = 36.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontStyle = FontStyle.Normal,
                        text = "$foodtext K",
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
                            imageVector = Icons.Outlined.Fastfood,
                            contentDescription = null,
                        )
                    }
                }

            }
        }
    }
}

//
//@Composable
//@Preview(showBackground = true)
//fun FoodPreview() {
//    val navController = rememberNavController()
//    Food(navController = navController)
//}

