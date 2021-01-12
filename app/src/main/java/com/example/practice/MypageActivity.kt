package com.example.practice

import android.Manifest.permission.CAMERA
import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.*
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Base64
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_mypage.*
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class MypageActivity : AppCompatActivity() {

    var id : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage)

        if(intent.hasExtra("id")) {              // "id"라는 key에 저장된 값이 있다면 id에 불러온 값을 저장한다.
            id = intent.getStringExtra("id")
            tv_welcome.text = "${id}님 환영합니다!"
        }

        btn_game.setOnClickListener(View.OnClickListener {
            intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        })
        btn_read.setOnClickListener(View.OnClickListener {
            intent = Intent(this, FairytaleActivity::class.java)
            startActivity(intent)
        })
        btn_update.setOnClickListener(View.OnClickListener {
            intent = Intent(this, UpdateActivity::class.java)
            startActivity(intent)
        })
        btn_photo.setOnClickListener(View.OnClickListener {
            intent = Intent(this, CameraActivity::class.java)
            startActivity(intent)
        })
  }


}