package com.example.practice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class LogoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logo)

        val handler = Handler()
        handler.postDelayed(Runnable {
            intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)  // 3초 뒤에 LoginActivity로 이동


    }
}

