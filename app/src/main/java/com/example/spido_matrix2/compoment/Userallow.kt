package org.matrix.android.sdk.sample.compoment

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ErrorOutline
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import org.matrix.android.sdk.sample.AppTheme


@Composable
fun Userallow(navController: NavController) {
    Surface(
        modifier = Modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()) // 添加垂直滚动修饰符
                .padding(all = 30.dp)
        ) {
            Icon(
                modifier = Modifier.size(38.dp),
                imageVector = Icons.Default.ErrorOutline,
                contentDescription = null,
            )
            Spacer(modifier = Modifier.height(14.dp))
            Text(
                text = "User Agreement",
                fontSize = 28.sp,
                fontWeight = FontWeight.Normal,
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "  Welcome to SPIDO and this is our first app. Some notifications will be updated these days",
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.weight(1f)) // 占位符，推动底部的Row到底部
                Text(
                    text = "  \n" +
                            "By using Spido, you indicate your trust in the way we handle your information. We are well aware of the significant importance of this responsibility and have been committed to protecting your information and giving you control. This privacy policy aims to assist you in understanding what information we collect, why we collect this information, and how you manage your own information.\n" +
                            "\n" +
                            "The information we have collected:\n" +
                            "We only collect information necessary to achieve product functionality based on the principles of legality, legitimacy, and necessity. We collect information to provide better services to all users - we will infer the basic content needed (such as which language you speak) and the current program crash information on your device based on the collected information.\n" +
                            "\n" +
                            "How do we collect this information:\n" +
                            "We adopt a voluntary method to collect this information, and when you need this information, you need to provide it voluntarily. You can provide this information through Spido, email.\n" +
                            "\n" +
                            "How do we store and protect information:\n" +
                            "Your information will be sent to Spido's API server without any intermediary. This application does not have any intermediary servers and cannot collect your information content. We comply with GDPR regulations. Therefore, when you are under 16 years old and using this software, you need to seek permission from your guardian.\n" +
                            "\n" +
                            "The content you provided us with:\n" +
                            "All your information will be saved on your personal device, and this software will not upload any information. If remote diagnostic information is required, you can proactively provide the error. log file via email for troubleshooting.\n" +
                            "\n" +
                            "change:\n" +
                            "We may revise the content of this policy in a timely manner. If such changes will result in a substantial impairment of your rights under this policy, we will notify you by prominently displaying a notice on the page or sending you an email before the changes take effect.\n" +
                            "\n" +
                            "In this case, if you continue to use our services, you agree to be bound by the revised policy.",
                    fontSize = 16.sp,
                )
                Spacer(modifier = Modifier.height(44.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    TextButton(onClick = {  }) {
                        Text(text = "Disagree")
                    }
                    Button(onClick = { navController.navigate("Overview") }) {
                        Text(text = "Agree")
                    }
                }
            }
        }
    }
}



@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "Default Preview Light"
)
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Default Preview Dark"
)
@Composable
fun UserallowPreview() {
    val navController = rememberNavController()
    AppTheme {
        Userallow(navController = navController)
    }
}


