package org.matrix.android.sdk.sample.compoment

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material.icons.outlined.ArrowDropDownCircle
import androidx.compose.material.icons.outlined.PlayCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.spido_matrix2.R
import org.matrix.android.sdk.sample.AppTheme


@Preview(showBackground = true)
@Composable
fun HappyCard() {
    ElevatedCard(modifier = Modifier.padding(all = 8.dp),
        onClick = { /* Do something */ },

        ) {
        Box() {
            Column() {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(18.dp)
                ) {

                        Image(
                            modifier = Modifier
                                .size(42.dp)
                                .clip(CircleShape),
                            painter = painterResource(id = R.drawable.pexels),
                            contentDescription = "Artist image",
                            contentScale = ContentScale.Crop
                        )


                    Spacer(modifier = Modifier.size(10.dp))

                    Column(
                        modifier = Modifier
                            .weight(1f) //自动占据剩余空间
                            .align(Alignment.CenterVertically)
                    ) {
                        Text(
                            modifier = Modifier,
                            fontSize = 12.sp,
                            text = "Jerk Abr")

                        Spacer(modifier = Modifier.size(3.dp))

                        Text(
                            fontSize = 12.sp,
                            text = "10 min ago",
                            fontWeight = FontWeight.Light
                        )
                    }

                    Box (
                        modifier = Modifier
                            .clip(RoundedCornerShape(15.dp))
                            .align(Alignment.CenterVertically)
                    ){
                        Icon(
                            imageVector = Icons.Default.StarBorder,
                            contentDescription = null,
                            tint = Color(0xFF83877D)
                        )
                    }

                }

                //在这里放帖子内容
                Box(
                    modifier = Modifier.padding(12.dp, 0.dp, 12.dp, 0.dp)
                ) {
                    Column() {
                        Text(
                            text = "关关难，关关过！",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 20.sp
                        )

                        Spacer(modifier = Modifier.size(8.dp))

                        Text(
                            text = "咱就是说人呐要天天开心，每天要过得充实，东西要吃得好，睡觉要睡的饱",
                            fontWeight = FontWeight.Medium,
                            fontSize = 15.sp
                        )

                        Spacer(modifier = Modifier.size(30.dp))

                    }

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
fun HappyCardpreview() {
    AppTheme {
        HappyCard()
    }
}
