package com.example.practice

import android.content.pm.ActivityInfo
import android.media.MediaPlayer
import android.os.Bundle
import android.speech.tts.TextToSpeech
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class TaleActivity : AppCompatActivity() {

    var id : String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        setContentView(R.layout.activity_tale)


    }
}