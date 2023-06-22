package com.example.mydailyjournal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Result : AppCompatActivity() {

    private var pTopic : String? = null
    private var nGratitude : String? = null
    private var mJournal : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val btnFinish : Button = findViewById(R.id.btn_finish)

        mJournal = intent.getStringExtra(Constants.JOURNAL)
        nGratitude = intent.getStringExtra(Constants.GRATITUDE)
        pTopic = intent.getStringExtra(Constants.TOPIC)


        val tvTopic : TextView = findViewById(R.id.topic)
        val tvGratitude : TextView = findViewById(R.id.gratitude)
        val tvJournal : TextView = findViewById(R.id.journal)

        tvTopic.text = pTopic
        tvGratitude.text = " Gratitude opens our hearts and minds to the beauty that surrounds us—the love of our family and friends, the simple joys of everyday life. Have a look at things you are grateful for : \n $nGratitude "
        tvJournal.text = "Here's how you were feeling today : \n $mJournal"

        btnFinish.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))

        }

    }
}