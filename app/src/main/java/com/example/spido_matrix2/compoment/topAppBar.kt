package org.matrix.android.sdk.sample.compoment

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.PhonelinkSetup
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.spido_matrix2.ui.theme.fontFamily


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Suppress("UNUSED_PARAMETER")
@Composable
fun TestAppbar(navController: NavController) {
    val context = LocalContext.current
    CenterAlignedTopAppBar(
        title = { Text(text = "Spido", maxLines = 1, fontFamily = fontFamily, overflow = TextOverflow.Ellipsis) },
        navigationIcon = {
            IconButton(onClick = { Toast.makeText(context, "Working in progress", Toast.LENGTH_SHORT).show() }) {
                Icon(
                    imageVector = Icons.Filled.PhonelinkSetup,
                    contentDescription ="Localized description"
                )
            }
        },
        actions = {
            IconButton(onClick = { Toast.makeText(context, "Working in progress", Toast.LENGTH_SHORT).show() }) {
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = "Localized description"
                )
            }
        }
    )
}

@Preview
@Composable
fun TestAppbarPv(){
    val navController = rememberNavController()

    TestAppbar(navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Suppress("UNUSED_PARAMETER")

@Composable
fun Happytopbar(navController: NavController) {
    val context = LocalContext.current
    var isDatePickerDialogVisible by remember { mutableStateOf(false) }

    CenterAlignedTopAppBar(
        title = { Text(text = "Today", maxLines = 1, fontFamily = fontFamily, overflow = TextOverflow.Ellipsis) },
        navigationIcon = {
            IconButton(onClick = {Toast.makeText(context, "Working in progress", Toast.LENGTH_SHORT).show() }) {
                Icon(
                    imageVector = Icons.Filled.Edit,
                    contentDescription = "Localized description"
                )
            }
        },
        actions = {
            IconButton(onClick = { isDatePickerDialogVisible = true }) {
                Icon(
                    imageVector = Icons.Filled.CalendarMonth,
                    contentDescription = "Localized description"
                )
            }
            IconButton(onClick = { navController.navigate("sensorInfoScreen")}) {
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "Localized description"
                )
            }
        }
    )

    if (isDatePickerDialogVisible) {
        DatePickerAlertDialog(onDismissRequest = { isDatePickerDialogVisible = false })
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Suppress("UNUSED_PARAMETER")
@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun DatePickerAlertDialog(onDismissRequest: () -> Unit) {
    val openDialog = remember { mutableStateOf(true) }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                onDismissRequest() // Call the provided dismiss request function
                openDialog.value = false // Reset the state after dismissing the dialog
            },
            text = {
                Column(
                    modifier = Modifier.padding(0.dp),
                    verticalArrangement = Arrangement.spacedBy(0.dp)
                ) {
                    val datePickerState = rememberDatePickerState(initialDisplayedMonthMillis = 1578096000000)
                    DatePicker(
                        state = datePickerState,
                        modifier = Modifier
                    )

                    Text(
                        text = "Selected date timestamp: ${datePickerState.selectedDateMillis ?: "no selection"}",
                        textAlign = TextAlign.Center,
                        color = Color.Black
                    )
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                        // Close the dialog and update the visibility state
                        onDismissRequest()
                    }
                ) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                        // Close the dialog and update the visibility state
                        onDismissRequest()
                    }
                ) {
                    Text("Dismiss")
                }
            }
        )
    }
}

@Preview
@Composable
fun PreviewDatePickerAlertDialog() {
    DatePickerAlertDialog()
}
@Preview
@Composable
fun happytobarpv() {
    val navController = rememberNavController()
    Happytopbar(navController = navController)
}
//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter"
//@Suppress("UNUSED_PARAMETER")
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun Happytopbar1(navController: NavController)
//{
//    var isDatePickerDialogVisible by remember { mutableStateOf(false) }
//    val context = LocalContext.current
//    CenterAlignedTopAppBar(
//        title = {
//            Text(
//                "Today",
//                maxLines = 1,
//                overflow = TextOverflow.Ellipsis,
//            )
//        },
//        navigationIcon = {
//            IconButton(onClick = { isDatePickerDialogVisible = true}) {
//                Icon(
//                    imageVector = Icons.Filled.CalendarMonth,
//                    contentDescription = "Localized description"
//                )
//            }
//        },
//        actions = {
//            IconButton(onClick = {
////                val intent = Intent(context, PoseActivity::class.java)
////                context.startActivity(intent)
//            }) {
//                Icon(
//                    imageVector = Icons.Filled.Edit,
//                    contentDescription = "Localized description"
//                )
//            }
//        }
//    )
//    if (isDatePickerDialogVisible) {
//        DatePickerAlertDialog(onDismissRequest = { isDatePickerDialogVisible = false })
//    }
//}
//}

