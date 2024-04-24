package com.example.spido_matrix2.sensor
//这个东西目前没预览，大概是有一些类冲突了。
import android.Manifest
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UpdateSensorInfo(
    context: Context,
    errorMessage: String,
    onResetSteps: () -> Unit // 添加一个重置步数的回调函数
) {
    SensorInfoScreen(
        context = context,
        errorMessage = errorMessage,
        onResetSteps = onResetSteps
    )
}

@Composable
fun SensorInfoScreen(
    context: Context,
    errorMessage: String,
    onResetSteps: () -> Unit // 添加一个重置步数的回调函数
) {
    var motionPermissionGranted by remember { mutableStateOf(false) }
    var currentAccelSteps by remember { mutableStateOf(0) }
    var currentStepDetectorSteps by remember { mutableStateOf(0) }

    val requestPermissionLauncher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.RequestPermission()) { isGranted ->
            motionPermissionGranted = isGranted
        }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Steps (ACCELEROMETER): $currentAccelSteps",
            fontSize = 20.sp,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        Text(
            text = "Steps (STEP_DETECTOR): $currentStepDetectorSteps",
            fontSize = 20.sp,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        Text(
            text = errorMessage,
            fontSize = 16.sp,
            color = Color.Red,
            fontStyle = FontStyle.Italic,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        Button(
            onClick = {
                if (motionPermissionGranted) {
                    onResetSteps()
                    // 重置加速计步数
                    currentAccelSteps = 0
                    currentStepDetectorSteps = 0
                } else {
                    requestPermissionLauncher.launch(Manifest.permission.ACTIVITY_RECOGNITION)
                }
            },
            modifier = Modifier.padding(top = 24.dp)
        ) {
            Text(text = if (motionPermissionGranted) "Reset Steps" else "Grant Motion Permission")
        }
    }

    // 设置定时器，每隔一段时间获取步数信息
    // 这里假设使用 TYPE_ACCELEROMETER 传感器获取步数信息
    val sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    val accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
    val sensorListener = object : SensorEventListener {
        override fun onSensorChanged(event: SensorEvent) {
            // 这里假设步数信息在 event.values[0] 中
            val steps = event.values[0].toInt()
            currentAccelSteps = steps
        }

        override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
            // 不需要实现此方法
        }
    }

    // 注册传感器监听器
    if (motionPermissionGranted) {
        sensorManager.registerListener(sensorListener, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL)
    }

    // 在组件销毁时取消传感器监听器
    DisposableEffect(Unit) {
        onDispose {
            sensorManager.unregisterListener(sensorListener)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SensorInfoScreenPreview() {
    val context = LocalContext.current
    SensorInfoScreen(
        context = context,
        errorMessage = "Example Error Message",
        onResetSteps = {}
    )
}
