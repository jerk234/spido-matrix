package com.example.spido_matrix2.compoment

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.SurfaceTexture
import android.hardware.camera2.CameraCaptureSession
import android.hardware.camera2.CameraDevice
import android.hardware.camera2.CameraManager
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.HandlerThread
import android.util.Log
import android.view.Surface
import android.view.TextureView
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.spido_matrix2.R
import com.example.spido_matrix2.ml.LiteModelMovenetSingleposeLightningTfliteFloat164
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.image.ImageProcessor
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.support.image.ops.ResizeOp
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import kotlin.math.acos
import kotlin.math.roundToInt
import kotlin.math.sqrt


class zxj : AppCompatActivity() {
    private lateinit var countDownTimer: CountDownTimer
    private var isCountDownRunning = false
    private val paint = Paint()
    private lateinit var imageProcessor: ImageProcessor
    private lateinit var model: LiteModelMovenetSingleposeLightningTfliteFloat164
    private lateinit var bitmap: Bitmap
    private lateinit var imageView: ImageView
    private lateinit var handler: Handler
    private lateinit var handlerThread: HandlerThread
    private lateinit var textureView: TextureView
    private lateinit var cameraManager: CameraManager
    private val bodyPartNames = arrayOf("鼻子", "左眼", "右眼", "左耳", "右耳",
        "左肩", "右肩", "左肘", "右肘", "左腕",
        "右腕", "左胯", "右胯", "左膝", "右膝",
        "左踝", "右踝"
    )
    private val points: MutableList<Pair<Float, Float>> = mutableListOf() // Store screen coordinates of points
    private var isDetected = false
    private var angleCounter = 0
    private var prevAngle = 0f
    private var error = 0
    private var isExerciseInProgress = false
    private var savedText = "" // To save the drawn text
    private val cameraPermission =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isPermissionGranted ->
            if (isPermissionGranted) {
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show()
            }
        }
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        when (PackageManager.PERMISSION_GRANTED) {
            ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) -> {
                //show camera
            }
            else -> {
                cameraPermission.launch(Manifest.permission.CAMERA)
            }
        }
        setContentView(R.layout.fragment_layout)

        // Initialize components
        imageProcessor = ImageProcessor.Builder().add(ResizeOp(192, 192, ResizeOp.ResizeMethod.BILINEAR)).build()
        model = LiteModelMovenetSingleposeLightningTfliteFloat164.newInstance(this)
        imageView = findViewById(R.id.imageView)
        textureView = findViewById(R.id.textureView)
        cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        handlerThread = HandlerThread("videoThread")
        handlerThread.start()
        handler = Handler(handlerThread.looper)
        paint.color = Color.YELLOW
        paint.textSize = 40f // Set text size for coordinates
        // Set up TextureView to display camera preview
        textureView.surfaceTextureListener = object : TextureView.SurfaceTextureListener {
            override fun onSurfaceTextureAvailable(p0: SurfaceTexture, p1: Int, p2: Int) {
                openCamera()
            }

            override fun onSurfaceTextureSizeChanged(p0: SurfaceTexture, p1: Int, p2: Int) {}

            override fun onSurfaceTextureDestroyed(p0: SurfaceTexture): Boolean { return false }

            @SuppressLint("UnsafeExperimentalUsageError")
            @Suppress("UNUSED_VARIABLE","NAME_SHADOWING")
            override fun onSurfaceTextureUpdated(p0: SurfaceTexture) {
                bitmap = textureView.bitmap!!
                var tensorImage = TensorImage(DataType.UINT8)
                tensorImage.load(bitmap)
                tensorImage = imageProcessor.process(tensorImage)

                val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 192, 192, 3), DataType.UINT8)
                inputFeature0.loadBuffer(tensorImage.buffer)

                val outputs = model.process(inputFeature0)
                val outputFeature0 = outputs.outputFeature0AsTensorBuffer.floatArray

                points.clear() // Clear previous points

                var h = bitmap.height
                var w = bitmap.width
                var x = 0

                val mutable = bitmap.copy(Bitmap.Config.ARGB_8888, true)
                val canvas = Canvas(mutable) // Create canvas here

                while (x <= 49) {
                    val confidence = outputFeature0.get(x + 2)
                    if (confidence > 0.45) {
                        val bodyPartId = (x / 3)
                        if (bodyPartId == 5 || bodyPartId == 11 || bodyPartId == 13 || bodyPartId == 15) {
                            val pointX = outputFeature0.get(x + 1) * w
                            val pointY = outputFeature0.get(x) * h
                            points.add(pointX to pointY) // Store screen coordinates

                            val bodyPartName = bodyPartNames[bodyPartId]

                            // Draw point and label only if confidence is high enough
                            canvas.drawCircle(pointX, pointY, 10f, paint)
                            canvas.drawText(bodyPartName, pointX, pointY, paint) // Draw body part name

                            // Log the coordinates
                            Log.d("BodyPart", "$bodyPartName: ($pointX, $pointY)")
                        }
                    }
                    x += 3
                }

                // Connect points if both points are detected
                if (isExerciseInProgress && points.size >= 3) {
                    val angle = calculateAngle(points[0], points[1], points[2]) // Angle between points 5, 11, and 13
                    if (prevAngle > 60 && angle < 60) {
                        error++
                    } else if (prevAngle < 60 && angle > 60) {
                        angleCounter++
                    }
                    prevAngle = angle
                    val angleText = "Crunch Angle: ${angle.roundToInt()}°"
                    savedText = angleText // Save the drawn text
                    canvas.drawText(angleText, 50f, (bitmap.height - 40f), paint)
                    connectPoints(canvas, points[0], points[1]) // Connect points 5 and 11
                    connectPoints(canvas, points[1], points[2]) // Connect points 11 and 13
                    // 检查是否需要显示错误消息
                    if (error > 0) {
                        val errorMessage = "Abdominal curls are not in place"
                        val textPaint = Paint(paint).apply {
                            color = Color.RED // 设置文本颜色为红色
                            textSize = 50f // 设置文本大小为30
                        }
                        val textWidth = textPaint.measureText(errorMessage) // 获取文本的宽度
                        val textX = (bitmap.width - textWidth) / 2 // 计算使文本居中对齐的起始横坐标
                        val textY = bitmap.height - 1580f // 设置文本的纵坐标
                        canvas.drawText(errorMessage, textX, textY, textPaint)
                    } else {
                        // 清除之前的错误消息
                        canvas.drawText("", 50f, (bitmap.height - 160f), paint)
                    }
                }

                // 绘制保存的文本
                canvas.drawText(savedText, 50f, (bitmap.height - 80f), paint)
                if (isExerciseInProgress) {
                    canvas.drawText("次数: $angleCounter", 50f, 280f, Paint(paint).apply {
                        color = Color.YELLOW // 设置文本颜色为黄色
                        textSize = 160f // 设置文本大小为40
                    })
                    canvas.drawText("Error: $error", 50f, (bitmap.height - 120f), paint)
                }
                imageView.setImageBitmap(mutable)
            }
        }


        // 添加开始/结束按钮点击事件
        val startStopButton = findViewById<Button>(R.id.startStopButton)
        startStopButton.setOnClickListener {
            if (isExerciseInProgress) {
                stopExercise()
                showExerciseSummaryDialog(angleCounter, error)
            } else {
                startExercise()
            }
        }
        val backButton = findViewById<Button>(R.id.button)
        backButton.setOnClickListener {
            finish()
        }
    }

    private fun startExercise() {
        if (isCountDownRunning) {
            return
        }
        // 设置倒计时文本可见
        findViewById<TextView>(R.id.countdownTextView).visibility = View.VISIBLE
        isCountDownRunning = true
        countDownTimer = object : CountDownTimer(5000, 1000) { // 5秒的倒计时
            override fun onTick(millisUntilFinished: Long) {
                // 更新倒计时文本
                findViewById<TextView>(R.id.countdownTextView).text = (millisUntilFinished / 1000).toString()
            }

            override fun onFinish() {
                // 初始化模型计数
                findViewById<Button>(R.id.startStopButton).text = "停止"
                textureView.surfaceTextureListener = object : TextureView.SurfaceTextureListener {
                    override fun onSurfaceTextureAvailable(p0: SurfaceTexture, p1: Int, p2: Int) {
                        openCamera()
                    }

                    override fun onSurfaceTextureSizeChanged(p0: SurfaceTexture, p1: Int, p2: Int) {}

                    override fun onSurfaceTextureDestroyed(p0: SurfaceTexture): Boolean { return false }

                    @SuppressLint("UnsafeExperimentalUsageError")
                    @Suppress("UNUSED_VARIABLE","NAME_SHADOWING")
                    override fun onSurfaceTextureUpdated(p0: SurfaceTexture) {
                        bitmap = textureView.bitmap!!
                        var tensorImage = TensorImage(DataType.UINT8)
                        tensorImage.load(bitmap)
                        tensorImage = imageProcessor.process(tensorImage)

                        val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 192, 192, 3), DataType.UINT8)
                        inputFeature0.loadBuffer(tensorImage.buffer)

                        val outputs = model.process(inputFeature0)
                        val outputFeature0 = outputs.outputFeature0AsTensorBuffer.floatArray

                        points.clear() // Clear previous points

                        var h = bitmap.height
                        var w = bitmap.width
                        var x = 0

                        val mutable = bitmap.copy(Bitmap.Config.ARGB_8888, true)
                        val canvas = Canvas(mutable) // Create canvas here

                        while (x <= 49) {
                            val confidence = outputFeature0.get(x + 2)
                            if (confidence > 0.45) {
                                val bodyPartId = (x / 3)
                                if (bodyPartId == 5 || bodyPartId == 11 || bodyPartId == 13 || bodyPartId == 15) {
                                    val pointX = outputFeature0.get(x + 1) * w
                                    val pointY = outputFeature0.get(x) * h
                                    points.add(pointX to pointY) // Store screen coordinates

                                    val bodyPartName = bodyPartNames[bodyPartId]

                                    // Draw point and label only if confidence is high enough
                                    canvas.drawCircle(pointX, pointY, 10f, paint)
                                    canvas.drawText(bodyPartName, pointX, pointY, paint) // Draw body part name

                                    // Log the coordinates
                                    Log.d("BodyPart", "$bodyPartName: ($pointX, $pointY)")
                                }
                            }
                            x += 3
                        }

                        // Connect points if both points are detected
                        if (isExerciseInProgress && points.size >= 3) {
                            val angle = calculateAngle(points[0], points[1], points[2]) // Angle between points 5, 11, and 13
                            if (prevAngle > 60 && angle < 60) {
                                error++
                            } else if (prevAngle < 60 && angle > 60) {
                                angleCounter++
                            }
                            prevAngle = angle
                            val angleText = "Crunch Angle: ${angle.roundToInt()}°"
                            savedText = angleText // Save the drawn text
                            canvas.drawText(angleText, 50f, (bitmap.height - 40f), paint)
                            connectPoints(canvas, points[0], points[1]) // Connect points 5 and 11
                            connectPoints(canvas, points[1], points[2]) // Connect points 11 and 13
                            // 检查是否需要显示错误消息
                            if (error > 0) {
                                val errorMessage = "Abdominal curls are not in place"
                                val textPaint = Paint(paint).apply {
                                    color = Color.RED // 设置文本颜色为红色
                                    textSize = 50f // 设置文本大小为30
                                }
                                val textWidth = textPaint.measureText(errorMessage) // 获取文本的宽度
                                val textX = (bitmap.width - textWidth) / 2 // 计算使文本居中对齐的起始横坐标
                                val textY = bitmap.height - 1580f // 设置文本的纵坐标
                                canvas.drawText(errorMessage, textX, textY, textPaint)
                            } else {
                                // 清除之前的错误消息
                                canvas.drawText("", 50f, (bitmap.height - 160f), paint)
                            }
                        }

                        // 绘制保存的文本
                        canvas.drawText(savedText, 50f, (bitmap.height - 80f), paint)
                        if (isExerciseInProgress) {
                            canvas.drawText("次数: $angleCounter", 50f, 280f, Paint(paint).apply {
                                color = Color.YELLOW // 设置文本颜色为黄色
                                textSize = 160f // 设置文本大小为40
                            })
                            canvas.drawText("Error: $error", 50f, (bitmap.height - 120f), paint)
                        }
                        imageView.setImageBitmap(mutable)
                    }
                }
                // 添加开始/结束按钮点击事件
                val startStopButton = findViewById<Button>(R.id.startStopButton)
                startStopButton.setOnClickListener {
                    if (isExerciseInProgress) {
                        stopExercise()
                        showExerciseSummaryDialog(angleCounter, error)
                    } else {
                        startExercise()
                    }
                }
                isExerciseInProgress = true
                angleCounter = 0
                error = 0
                model = LiteModelMovenetSingleposeLightningTfliteFloat164.newInstance(this@zxj)
                isCountDownRunning = false
                // 隐藏倒计时文本
                findViewById<TextView>(R.id.countdownTextView).visibility = View.GONE
            }


        }.start()
    }

    private fun stopExercise() {
        if (isCountDownRunning) {
            countDownTimer.cancel() // 取消倒计时
            isCountDownRunning = false
        }
        isExerciseInProgress = false
        findViewById<Button>(R.id.startStopButton).text = "Again"
        savedText = ""
        textureView.surfaceTextureListener = null
        model.close()
    }

    override fun onDestroy() {
        super.onDestroy()
        model.close()
    }
    private fun showExerciseSummaryDialog(angleCounter: Int, error: Int) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Exercise Summary")
        val message = "Total Crunches: $angleCounter\nTotal Errors: $error"
        builder.setMessage(message)
        builder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss() // 点击按钮后关闭对话框
            finish() // 返回上一层
        }
        val dialog = builder.create()
        dialog.show()
    }

    @Suppress("DEPRECATION")
    @SuppressLint("MissingPermission")
    fun openCamera() {
        cameraManager.openCamera(cameraManager.cameraIdList[0], object : CameraDevice.StateCallback() {
            override fun onOpened(p0: CameraDevice) {
                val captureRequest = p0.createCaptureRequest(CameraDevice.TEMPLATE_PREVIEW)
                val surface = Surface(textureView.surfaceTexture)
                captureRequest.addTarget(surface)
                p0.createCaptureSession(listOf(surface), object : CameraCaptureSession.StateCallback() {
                    override fun onConfigured(p0: CameraCaptureSession) {
                        p0.setRepeatingRequest(captureRequest.build(), null, null)
                    }
                    override fun onConfigureFailed(p0: CameraCaptureSession) {}
                }, handler)
            }
            override fun onDisconnected(p0: CameraDevice) {}
            override fun onError(p0: CameraDevice, p1: Int) {}
        }, handler)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun getPermissions() {
        if (checkSelfPermission(android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(arrayOf(android.Manifest.permission.CAMERA), 101)
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults[0] != PackageManager.PERMISSION_GRANTED) getPermissions()
    }

    private fun connectPoints(canvas: Canvas, p1: Pair<Float, Float>, p2: Pair<Float, Float>) {
        canvas.drawLine(p1.first, p1.second, p2.first, p2.second, paint)
    }

    private fun calculateAngle(p1: Pair<Float, Float>, p2: Pair<Float, Float>, p3: Pair<Float, Float>): Float {
        val vector1 = Pair(p1.first - p2.first, p1.second - p2.second)
        val vector2 = Pair(p3.first - p2.first, p3.second - p2.second)
        val dotProduct = vector1.first * vector2.first + vector1.second * vector2.second
        val mag1 = sqrt((vector1.first * vector1.first + vector1.second * vector1.second).toDouble())
        val mag2 = sqrt((vector2.first * vector2.first + vector2.second * vector2.second).toDouble())
        val angle = acos(dotProduct / (mag1 * mag2))
        return Math.toDegrees(angle).toFloat()
    }

}
