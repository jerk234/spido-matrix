package org.matrix.android.sdk.sample.compoment

import android.content.res.Configuration
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.matrix.android.sdk.sample.AppTheme

@Suppress("UNUSED_PARAMETER")
@Preview
@Composable
fun ExpandableCard2() {
    AppTheme {
        var expanded by remember { mutableStateOf(false) } // Expand State
        val rotationState by animateFloatAsState(
            targetValue = if (expanded) 180f else 0f,
            label = "Rotation state of expand icon button",
        )
        @Suppress("UNUSED_VARIABLE")
        val strokeState by animateDpAsState(
            targetValue = if (expanded) 2.dp else 1.dp,
            label = "Stroke width",
        )

        Card(
            modifier = Modifier.padding(0.dp),
            shape = RoundedCornerShape(0.dp), // shape
            onClick = { expanded = !expanded }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .animateContentSize() // edit animation here
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween // control the header alignment over here.
                ) {
                    Text(
                        text = "header",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Normal,
                    )
                    IconButton(
                        modifier = Modifier.rotate(rotationState),
                        onClick = { expanded = !expanded }
                    ) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowDown,

                            contentDescription = "Drop Down Arrow"
                        )
                    }
                }
            }
            Column(){

                if (expanded) {
                    Text(
                        text = "description",

                        fontSize = 16.sp,
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp)
                            .padding(start = 16.dp)
                    )
                }
            }
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
fun ExpandableCardview() {
    AppTheme {
        ExpandableCard2()
    }
}
