package org.matrix.android.sdk.sample.compoment

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.core.content.PermissionChecker
import android.Manifest
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import org.matrix.android.sdk.sample.AppTheme

@Preview
@Composable
fun accd(){
    AppTheme {
        Surface(color = Color.Transparent){
            AddButton1(icon = Icons.Filled.Add) {
                
            }

        }

    }
}

@Composable
fun AddButton1(icon: ImageVector, onClick: () -> Unit) {
    val context = LocalContext.current

    // 创建一个启动器，用于请求权限
    val requestPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            // 权限已授予，执行点击操作
            onClick()
        }
    }

    LargeFloatingActionButton(
        onClick = {
            // 检查权限
            val permission = Manifest.permission.ACTIVITY_RECOGNITION
            val isPermissionGranted = ContextCompat.checkSelfPermission(
                context,
                permission
            ) == PermissionChecker.PERMISSION_GRANTED

            if (!isPermissionGranted) {
                // 请求权限
                requestPermissionLauncher.launch(permission)
            } else {
                // 权限已授予，执行点击操作
                onClick()
            }
        }
    ) {
        Icon(
            icon,
            contentDescription = "Localized description",
            modifier = Modifier.size(46.dp)
        )
    }
}
