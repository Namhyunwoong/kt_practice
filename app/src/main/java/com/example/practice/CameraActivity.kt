package com.example.practice

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_camera.*
import kotlinx.android.synthetic.main.activity_login.*
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class CameraActivity : AppCompatActivity() {
    val REQUEST_IMAGE_CAPTURE = 1 // 상수값이므로 대문자로 해주는것은 상관없다.

    lateinit var currentPhotoPath: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)

        btn_caption.setOnClickListener(View.OnClickListener { v ->
            if (checkPermission())
                takePicture()
            else {
                requestPermission()
            }

        })

    }
    private fun takePicture(){
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            if (takePictureIntent.resolveActivity(this.packageManager) != null) {
                // 찍은 사진을 그림파일로 만들기
                val photoFile: File? =
                        try {
                            createFile()
                        } catch (ex: IOException) {
                            Log.d("TAG", "그림파일 만드는도중 에러생김")
                            null
                        }

                // 그림파일을 성공적으로 만들었다면 onActivityForResult로 보내기
                photoFile?.also {
                    val photoURI: Uri = FileProvider.getUriForFile(this, "com.example.practice.fileprovider", it)
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
                }
            }
        }
    }
    private fun createFile() : File {
        val timeStamp : String = SimpleDateFormat("yyyyMMdd_HHMMSS").format(Date())
        val storageDir : File? = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile("JPEG_${timeStamp}_", ".jpg", storageDir).apply { currentPhotoPath = absolutePath }
    }

    override fun onActivityResult(requestCode : Int, resultCode : Int, data : Intent?){
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode){
            1 -> {
                if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK){
                    val file = File(currentPhotoPath)
                    if (Build.VERSION.SDK_INT < 28) {
                        Glide.with(this).load(file).into(imv_photo)
                    }else{
                        Glide.with(this).load(file).into(imv_photo)
                    }

                }
            }
        }
    }

    //카메라 권한 요청
    private fun requestPermission(){
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA), REQUEST_IMAGE_CAPTURE)
    }

    // 카메라 권한 체크
    private fun checkPermission() : Boolean{
        return(ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) ==
                PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
    }

    // 카메라 권한요청 결과
    override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<out String>,
            grantResults: IntArray
    ){
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Log.d("TAG", "Permission: " + permissions[0] + "was " + grantResults[0] + "카메라 허가")
            takePicture()
        }
        else
            Log.d("TAG", "허가 실패")
    }
}