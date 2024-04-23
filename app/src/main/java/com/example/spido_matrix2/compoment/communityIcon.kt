package org.matrix.android.sdk.sample.compoment


import android.content.res.Configuration
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.spido_matrix2.R
import org.matrix.android.sdk.sample.AppTheme


@Composable
fun MessageCard2() {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
    ) {
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Image(
                modifier = Modifier
                    .size(42.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colorScheme.secondary, CircleShape),
                painter = painterResource(id = R.drawable.pexels),
                contentDescription = "Artist image",
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(8.dp))

            // We keep track if the message is expanded or not in this
            // variable
            var isExpanded by remember { mutableStateOf(false) }
            // surfaceColor will be updated gradually from one color to the other
            val surfaceColor by animateColorAsState(
                if (isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
            )

            // We toggle the isExpanded variable when we click on this Column
            Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
                Text(
                    text = "黄梓烁",
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.titleSmall
                )

                Spacer(modifier = Modifier.height(4.dp))

                Surface(
                    shape = MaterialTheme.shapes.medium,
                    shadowElevation = 1.dp,
                    // surfaceColor color will be changing gradually from primary to surface
                    color = surfaceColor,
                    // animateContentSize will change the Surface size gradually
                    modifier = Modifier
                        .animateContentSize()
                        .padding(1.dp)
                ) {
                    Text(
                        text = "在人民面前，我们永远是小学生。在人民面前，我们永远是小学生。在人民面前，我们永远是小学生。在人民面前，我们永远是小学生。",
                        modifier = Modifier.padding(all = 4.dp),
                        // If the message is expanded, we display all its content
                        // otherwise we only display the first line
                        maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                        style = MaterialTheme.typography.bodyMedium
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
fun MessageCard2view() {
    AppTheme {
        MessageCard2()
    }
}












@Composable
fun MessageCard1() {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Image(
                modifier = Modifier
                    .size(42.dp)
                    .clip(CircleShape),
                painter = painterResource(id = R.drawable.pexels),
                contentDescription = "Artist image",
                contentScale = ContentScale.Crop
            )

            // Add a horizontal space between the image and the column
            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(text = "黄梓烁")
                // Add a vertical space between the author and message texts
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "咱就是说人呐要天天开心，每天要过得充实，东西要吃得好，睡觉要睡的饱.")
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
fun MessageCard1Preview() {
    AppTheme {
        MessageCard1()
    }
}

@Composable
fun MessageCardtest() {
    // Add padding around our message
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            modifier = Modifier
                .size(42.dp)
                .clip(CircleShape),
            painter = painterResource(id = R.drawable.pexels),
            contentDescription = "Artist image",
            contentScale = ContentScale.Crop
        )

        // Add a horizontal space between the image and the column
        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(text = "黄梓烁")
            // Add a vertical space between the author and message texts
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "咱就是说人呐要天天开心，每天要过得充实，东西要吃得好，睡觉要睡的饱.")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardMessagepreviewNocard() {
    MessageCardtest()
}


@Composable
fun MessageCard3() {
    Column() {
        androidx.compose.material3.ListItem(
            headlineContent = { Text(text = "黄梓烁") },
            supportingContent = { Text(text = "'核心绝不意味着无限权力，也绝不意味着可以任性决策。要正确处理核心与集体领导的关系，更好坚持民主集中制，绝不会搞个人专制、个人崇拜，绝不会搞王明残酷的党内斗争那一套，也不会搞“文革”那一套'") },
            trailingContent = { Text(text = "4月8日") },
            leadingContent = {
                Image(
                    modifier = Modifier
                        .size(42.dp)
                        .clip(CircleShape)
                        .border(1.5.dp, MaterialTheme.colorScheme.secondary, CircleShape),
                    painter = painterResource(id = R.drawable.pexels),
                    contentDescription = "Artist image",
                    contentScale = ContentScale.Crop,
                )
            },
//            tonalElevation = 1.dp


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
fun MessageCard3preview() {
    AppTheme {
        MessageCard3()
    }
}
