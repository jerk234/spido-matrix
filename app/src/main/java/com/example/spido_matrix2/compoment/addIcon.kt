package org.matrix.android.sdk.sample.compoment

import android.content.res.Configuration
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.matrix.android.sdk.sample.AppTheme


@Composable
fun AddButton() {
    LargeFloatingActionButton(onClick = { /*TODO*/ }) {
        Icon(Icons.Filled.Add,"Localized description",
            modifier = Modifier.size(46.dp))
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
fun AddButtonPreview() {
    AppTheme {
        AddButton()
    }
}