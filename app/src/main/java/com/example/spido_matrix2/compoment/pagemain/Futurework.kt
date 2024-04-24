package com.example.spido_matrix2.compoment.pagemain

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.spido_matrix2.compoment.Cardpages.Topbarcp
import com.example.spido_matrix2.ui.theme.fontFamily
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
import org.matrix.android.sdk.sample.compoment.topappbarA
import org.matrix.android.sdk.sample.compoment.topappbarB

@Composable
fun Future(navController: NavController) {
    Scaffold(
        topBar = {
            TestAppbar(navController)
            },
    ) { innerPadding ->
        Surface {
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .verticalScroll(rememberScrollState())
            ) {
                Box(modifier = Modifier.fillMaxWidth(),contentAlignment = Alignment.Center){


                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(22.dp)){



                        Column(horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceBetween
                        ) {

                            Text(
                                text = "敬请期待",
                                fontSize = 45.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = fontFamily

                            )
                            Spacer(modifier = Modifier.height(15.dp))
                            Text(
                                text="Working in progress",
                                fontWeight = FontWeight.Normal,
                                fontSize = 27.sp,
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun Futurepv(){
    val navController = rememberNavController()
    Future(navController = navController)
}