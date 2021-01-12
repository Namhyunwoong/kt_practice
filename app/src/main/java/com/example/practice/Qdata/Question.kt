package com.example.practice.Qdata

import com.example.practice.R

class Question {

    val m_map = HashMap<Int, QuestionVo>()
    private var quiz: String = ""
    private var ans1: String? = null
    private var ans2: String? = null
    private var question: String? = null

    fun init() {
        m_map[0] = QuestionVo(R.drawable.pic1, "Two horses are running through a field")
        m_map[1] = QuestionVo(R.drawable.pic2, "People are eating food at kitchen and a young boy is sitting on the chair")
        m_map[2] = QuestionVo(R.drawable.pic3, "A group of children and adults are gathered around the table")
        m_map[3] = QuestionVo(R.drawable.pic4, "A sandwich and fries are shaped as a heart")
        m_map[4] = QuestionVo(R.drawable.pic5, "Groceries are displayed with fruits vegetables caned and packaged goods")
        m_map[5] = QuestionVo(R.drawable.pic6, "A cat is sleeping on an outdoor bench")
        m_map[6] = QuestionVo(R.drawable.pic7, "A big truck is parked on a camping ground")
        m_map[7] = QuestionVo(R.drawable.pic8, "The police officer is waving hand on a motorcycle")
        m_map[8] = QuestionVo(R.drawable.pic9, "Two giraffes are looking around by the tree")
        m_map[9] = QuestionVo(R.drawable.pic10, "There are brown cake and strawberries on the plate")
        m_map[10] = QuestionVo(R.drawable.pic11, "A group of giraffes are standing next to the rhinos")
        m_map[11] = QuestionVo(R.drawable.pic12, "A bunch of food is piled on top of the table")
        m_map[12] = QuestionVo(R.drawable.pic13, "A large bird is waddling on the beach")
        m_map[13] = QuestionVo(R.drawable.pic14, "A dark colored airplane sitting on a runway")
        m_map[14] = QuestionVo(R.drawable.pic15, "An artistic vase with a yellow flower and two roses is placed on table")
        m_map[15] = QuestionVo(R.drawable.pic16, "A wooden bench is placed next to a green fence in the amusement park")
        m_map[16] = QuestionVo(R.drawable.pic17, "A spotted cat is rolling around by the laptop")
        m_map[17] = QuestionVo(R.drawable.pic18, "A man playing tennis on a court with a tennis racket")
        m_map[18] = QuestionVo(R.drawable.pic19, "A woman with child and dog sit on the grass in front of a bench")
        m_map[19] = QuestionVo(R.drawable.pic20, "A man is riding a skateboard down a rural road")
        m_map[20] = QuestionVo(R.drawable.pic21, "A dog wrapped in a blanket while sleeping on a bed")
        m_map[21] = QuestionVo(R.drawable.pic22, "A yellow school bus is traveling down a road filled with traffic")
        m_map[22] = QuestionVo(R.drawable.pic23, "Two teams of girls are playing soccer")
        m_map[23] = QuestionVo(R.drawable.pic24, "Four giraffes are resting next to a tree")
        m_map[24] = QuestionVo(R.drawable.pic25, "A little boy is sitting on a wooden rocking chair")
        m_map[25] = QuestionVo(R.drawable.pic26, "A woman is riding a surfboard in a skimpy outfit")
        m_map[26] = QuestionVo(R.drawable.pic27, "A white table topped with small white plates filled with chocolate and baking ingredients")
        m_map[27] = QuestionVo(R.drawable.pic28, "A river filled with lots of boats next to tall buildings")
        m_map[28] = QuestionVo(R.drawable.pic29, "Baseball batter waiting for ball while umpire holds in glove out")
        m_map[29] = QuestionVo(R.drawable.pic30, "A train is standing at the station under tree")
    }

    fun getQuestion(_index: Int): QuestionVo = m_map.get(_index) ?: m_map.get(0)!!

    fun getQuestSize() = m_map.size

    tailrec fun makeBlank(mNum: Int): List<String?> {

        quiz = m_map[mNum]?.msg.toString()
        var caption = quiz.split(" ") as MutableList<String>
        val aaa = mutableListOf<Int>()
        for (i in 0 until caption.size) {
            aaa.add(i)
        }
        aaa.shuffle()
        val a = aaa[0]
        val b = aaa[1]

        ans1 = caption[a]
        ans2 = caption[b]

        caption[a] = "___"
        caption[b] = "___"
        question = caption.toString().replace(",", " ")
        val triple = Triple(ans1, ans2, question)
        val questionlist = triple.toList()
        return if (a < b) questionlist else makeBlank(mNum)

    }
}