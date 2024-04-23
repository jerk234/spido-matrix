package org.matrix.android.sdk.sample.compoment

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.matrix.android.sdk.sample.AppTheme


@Composable
fun ListItem1(){
    Column {
        ListItem(
            headlineContent = { Text(text = "One line list item with 24*24 icon")},
            leadingContent = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Localized description",
                )
            }
        )
        HorizontalDivider()
    }
}



@Composable
fun ListItem3() {
    Column {
        ListItem(
            headlineContent = { Text("Three line list item") },
            overlineContent = { Text("OVERLINE") },
            supportingContent = { Text("Secondary text") },
            leadingContent = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Localized description",
                )
            },
            trailingContent = { Text("meta") }
        )
        HorizontalDivider()
    }
}

@Composable
fun ListItem4(){
    Column {
        ListItem(
            headlineContent = { Text("Three line list item") },
            supportingContent = {
                Text("Secondary text that is long and perhaps goes onto another line")
            },
            leadingContent = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Localized description",
                )
            },
            trailingContent = { Text("meta") }
        )
        HorizontalDivider()
    }
}

@Composable
fun ListItem2() {
    Column {
        ListItem(
            headlineContent = { Text(text = "Two line list item with trailing")},
            supportingContent = { Text(text = "Secondary text")},
            trailingContent = { Text(text = "meta")},
            leadingContent = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Localized description",
                )
            }

        )
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
fun MessageCrad3preview() {
    AppTheme {
        ListItem1()
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
fun ListItempreview() {
    AppTheme {
        ListItem2()
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
fun ListItem2preview() {
    AppTheme {
        ListItem3()
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
fun ListItem3preview() {
    AppTheme {
        ListItem4()
    }
}

