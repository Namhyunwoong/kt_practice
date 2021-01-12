package com.example.practice

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.practice.Qdata.Question
import kotlinx.android.synthetic.main.activity_game.*
import java.util.*

class GameActivity : AppCompatActivity() {

    var mCaption : String = ""
    var mAns1 : String? = null
    var mAns2 : String? = null
    var mCnt : Int = 0
    var mNum : Int = 0          // 현재 문제 번호.
    var mQuestion : String? = null
    var mQuestlist = listOf<String?>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val random = Random()
        val quest = Question()
        quest.init()

        mNum = random.nextInt(quest.getQuestSize())
        mCaption = quest.getQuestion(mNum).msg      // 전체 정답 문장
        mQuestlist = quest.makeBlank(mNum)
        mAns1 = mQuestlist[0]                        // 첫번째 답
        mAns2 = mQuestlist[1]                        // 두번째 답
        mQuestion = mQuestlist[2]                    // 빈칸으로 바뀐 문장
        quest.getQuestion(mNum).picture.let { imv_pic.setImageResource(it) }
        tv_caption.text = mQuestion

        btn_next.setOnClickListener(View.OnClickListener {
            if (mNum < 29)
                mNum++
            else if(mNum == 29)
                mNum = 0
            mCaption = quest.getQuestion(mNum).msg
            mQuestlist = quest.makeBlank(mNum)
            mAns1 = mQuestlist[0]
            mAns2 = mQuestlist[1]
            mQuestion = mQuestlist[2]
            quest.getQuestion(mNum).picture.let { imv_pic.setImageResource(it) }
            tv_caption.text = mQuestion
            edt_first.text.clear()
            edt_second.text.clear()

            mCnt = 0
        })

        btn_pre.setOnClickListener(View.OnClickListener {
            if (mNum > 0){
                mNum--
                mCaption = quest.getQuestion(mNum).msg
                mQuestlist = quest.makeBlank(mNum)
                mAns1 = mQuestlist[0]
                mAns2 = mQuestlist[1]
                mQuestion = mQuestlist[2]
                quest.getQuestion(mNum).picture.let { imv_pic.setImageResource(it) }
                tv_caption.text = mQuestion
                edt_first.text.clear()
                edt_second.text.clear()
            }else if(mNum == 0)
                Toast.makeText(this, "첫번째 문장입니다.", Toast.LENGTH_SHORT).show()
            mCnt = 0
        })

        btn_try.setOnClickListener(View.OnClickListener {
            if(mAns1 == edt_first.text.toString() && mAns2 == edt_second.text.toString())
                Toast.makeText(this, "정답!", Toast.LENGTH_SHORT).show()
            else if(mAns1 == edt_first.text.toString())
                Toast.makeText(this, "두번째 빈칸 오답", Toast.LENGTH_SHORT).show()
            else if(mAns2 == edt_second.text.toString())
                Toast.makeText(this, "첫번째 빈칸 오답", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "둘다 오답", Toast.LENGTH_SHORT).show()
            mCnt++
        })

        btn_ans.setOnClickListener(View.OnClickListener {
            if(mCnt >= 3)
                tv_caption.text = mCaption
            else
                Toast.makeText(this, "3번 이상 입력", Toast.LENGTH_SHORT).show()
        })


    }

}