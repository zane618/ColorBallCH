package com.zane.colorballch.kt

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import com.zane.colorballch.MainActivity
import com.zane.colorballch.R
import com.zane.colorballch.kt.adapter.RedAdapter
import com.zane.colorballch.kt.bean.ColorBall

class KtMainActivity : AppCompatActivity() {

    private lateinit var redAdapter: RedAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_kt)
        findViewById<View>(R.id.button).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        initData()

    }

    private fun initData() {
        val ballList = arrayListOf<ColorBall>()
        for (i in 0..32) {
            ballList.add(ColorBall(i + 1))
        }
        val redAdapter = RedAdapter(ballList)
        val rvRed: RecyclerView = findViewById(R.id.rv_red)
        val layoutManager = FlexboxLayoutManager(this)
        layoutManager.flexDirection = FlexDirection.ROW
        layoutManager.justifyContent = JustifyContent.CENTER

        rvRed.layoutManager = layoutManager
        rvRed.adapter = redAdapter

    }


}