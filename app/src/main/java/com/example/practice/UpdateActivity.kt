package com.example.practice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_update.*

class UpdateActivity : AppCompatActivity() {

    var pw : String? = null
    var email : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        val rq = Volley.newRequestQueue(this)
        val url : String = "http://61.80.106.120:8082/ProjectIL/Updatetest"
        val srq = StringRequest(Request.Method.POST, url, Response.Listener { response ->
            if (response == "1"){
                Toast.makeText(this, "정보수정 성공", Toast.LENGTH_SHORT).show()
                intent = Intent(this, MypageActivity::class.java)
                startActivity(intent)
            } else if(response == "-1")
                Toast.makeText(this, "정보수정 실패", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "잘못된 접근입니다.", Toast.LENGTH_SHORT).show()
        }, Response.ErrorListener { error ->
        })
        srq.setTag("MAIN")

        btn_update.setOnClickListener(View.OnClickListener {
            pw = edt_pw.text.toString()
            email = edt_email.text.toString()

            if(pw.isNullOrEmpty() || email.isNullOrEmpty())
                Toast.makeText(this, "빈칸을 채우세요", Toast.LENGTH_SHORT).show()
            else
                rq.add(srq)
        })

    }
}