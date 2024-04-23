//package org.matrix.android.sdk.sample.compoment
//
//import android.annotation.SuppressLint
//import android.os.Bundle
//import android.widget.TextView
//import androidx.appcompat.app.AppCompatActivity
//import com.example.spido_matrix2.R
//import org.matrix.android.sdk.sample.R
//
//class ResultActivity : AppCompatActivity() {
//
//    @SuppressLint("MissingInflatedId")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_result)
//
//        // 获取传递过来的计数
//        val angleCounter = intent.getIntExtra("angleCounter", 0)
//
//        // 显示计数
//        val resultTextView = findViewById<TextView>(R.id.resultTextView)
//        resultTextView.text = "最后计数：$angleCounter"
//    }
//}