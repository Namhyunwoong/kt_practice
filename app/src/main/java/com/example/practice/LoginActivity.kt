package com.example.practice

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_login.*
import java.util.*

class LoginActivity : AppCompatActivity() {
    var id : String? = null
    var pw : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val rq = Volley.newRequestQueue(this)
        val url = "http://61.80.106.120:8082/ProjectIL/Logintest"

        val srq = StringRequest(Request.Method.POST, url, Response.Listener {response ->
            if (response == "fail"){
                Log.v("ddd", "name : $response")
                Toast.makeText(this, "id, pw 확인", Toast.LENGTH_SHORT).show()
            }else{
                Log.v("bbb", response)
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                intent = Intent(this, MypageActivity::class.java)
                intent.putExtra("id", id)
                startActivity(intent)
            }
        }, Response.ErrorListener {
            Log.e("err", "err::")
        })

        srq.tag = "MAIN"

        btn_login.setOnClickListener(View.OnClickListener {
            id = edt_id.text.toString()
            pw = edt_pw.text.toString()

            if (id.isNullOrEmpty() || pw.isNullOrEmpty())
                Toast.makeText(this, "id 혹은 pw가 입력되지 않았습니다.", Toast.LENGTH_SHORT).show()
            else
                rq.add(srq)

        })
        getParams()
        // getParams를 쓰는 방법을 모르겠음

        btn_join.setOnClickListener(View.OnClickListener {
            intent = Intent(this, JoinActivity::class.java)
            startActivity(intent)
        })

    }
    fun getParams(): Map<String, String>? {
        val data = HashMap<String, String>()
        data["id"] = id!!
        data["pw"] = pw!!
        return data
    }
}