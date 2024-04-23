package org.matrix.android.sdk.sample.compoment

import android.content.res.Configuration
import android.os.Build
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.matrix.android.sdk.sample.AppTheme

import java.time.DayOfWeek
import java.time.Instant
import java.time.ZoneId
import java.util.Calendar
import java.util.TimeZone


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePicker1(){
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            val datePickerState = rememberDatePickerState(initialDisplayedMonthMillis = 1578096000000)
            DatePicker(
                state = datePickerState,
                modifier = Modifier
                    .padding(16.dp)
            )

            Text(
                "Selected date timestamp: ${datePickerState.selectedDateMillis ?: "no selection"}",
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.size(20.dp))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePicker2(){
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            val datePickerState = rememberDatePickerState(initialDisplayMode = DisplayMode.Input)
            DatePicker(
                state = datePickerState, modifier = Modifier.padding(16.dp)
            )

            Text(
                text = "Entered date timestamp: ${datePickerState.selectedDateMillis ?:"no inout"}",
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.size(20.dp))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerSE(){
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
    ) {
        val datePickerState = rememberDatePickerState(
            selectableDates = object : SelectableDates {
                // Blocks Sunday and Saturday from being selected.
                override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        val dayOfWeek = Instant.ofEpochMilli(utcTimeMillis).atZone(ZoneId.of("UTC"))
                            .toLocalDate().dayOfWeek
                        dayOfWeek != DayOfWeek.SUNDAY && dayOfWeek != DayOfWeek.SATURDAY
                    } else {
                        val calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
                        calendar.timeInMillis = utcTimeMillis
                        calendar[Calendar.DAY_OF_WEEK] != Calendar.SUNDAY &&
                                calendar[Calendar.DAY_OF_WEEK] != Calendar.SATURDAY
                    }
                }

                // Allow selecting dates from year 2023 forward.
                override fun isSelectableYear(year: Int): Boolean {
                    return year > 2022
                }
            }
        )

        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            DatePicker(state = datePickerState)
            Text(
                "Selected date timestamp: ${datePickerState.selectedDateMillis ?: "no selection"}",
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.size(20.dp))
        }
    }

}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Default Preview Dark"
)

// see your app with light theme
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "Default Preview Dark"
)
@Composable
fun DatePicker1preview() {
    AppTheme {
        DatePicker1()
    }
}


@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Default Preview Dark"
)

// see your app with light theme
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "Default Preview Dark"
)
@Composable
fun DatePicker2preview() {
    AppTheme {
        DatePicker2()
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Default Preview Dark"
)

// see your app with light theme
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "Default Preview Dark"
)
@Composable
fun TimePickerpreview() {
    AppTheme {
        DatePickerSE()
    }
}