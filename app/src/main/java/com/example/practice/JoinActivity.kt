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
import kotlinx.android.synthetic.main.activity_join.*
import kotlinx.android.synthetic.main.activity_join.btn_join
import kotlinx.android.synthetic.main.activity_join.edt_id
import kotlinx.android.synthetic.main.activity_login.*

class JoinActivity : AppCompatActivity() {
    var id : String? = null
    var pw : String? = null
    var email : String? = null
    var name : String? = null
    var age : String? = null
    var gender : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        val rq = Volley.newRequestQueue(this)
        val url = "http://61.80.106.120:8082/ProjectIL/test"

        val srq = StringRequest(Request.Method.POST, url, Response.Listener{response ->
            if(response == "1") {
                Toast.makeText(this, "회원가입 성공", Toast.LENGTH_SHORT).show()
                intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
            else if(response == "-1")
                Toast.makeText(this, "회원가입 실패, 중복된 아이디입니다.", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "잘못된 접근입니다.", Toast.LENGTH_SHORT).show()

        }, Response.ErrorListener { error ->

        })

        btn_join.setOnClickListener(View.OnClickListener {
            id = edt_id.text.toString()
            pw = edt_pw1.text.toString()
            email = edt_email.text.toString()
            name = edt_name.text.toString()
            age = edt_age.text.toString()
            gender = edt_gender.text.toString()

            if(id.isNullOrEmpty() || pw.isNullOrEmpty() || email.isNullOrEmpty() || name.isNullOrEmpty() || age.isNullOrEmpty() || gender.isNullOrEmpty())
                Toast.makeText(this, "빈칸을 채워주세요!", Toast.LENGTH_SHORT).show()
            else
                rq.add(srq)
        })
    }
}