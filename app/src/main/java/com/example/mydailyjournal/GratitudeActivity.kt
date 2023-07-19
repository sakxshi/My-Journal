package com.example.mydailyjournal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class GratitudeActivity : AppCompatActivity() {

    private var nTopic : String? = null      //receiving topic from QuestionsActivity

    private var btnSubmitGratitude: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gratitude)

        val inputtedText : EditText = findViewById(R.id.inputted_text_gratitude)

        nTopic = intent.getStringExtra(Constants.TOPIC)

        btnSubmitGratitude = findViewById(R.id.btn_submit_gratitude)

        btnSubmitGratitude?.setOnClickListener{

            val intent = Intent(this, JournalingActivity::class.java)    //this intent will now allow me to move from MainActivity to JournalingActivity
            intent.putExtra(Constants.TOPIC, nTopic)
            intent.putExtra(Constants.GRATITUDE, inputtedText.text.toString())
            startActivity(intent)
            finish()
        }


    }
}