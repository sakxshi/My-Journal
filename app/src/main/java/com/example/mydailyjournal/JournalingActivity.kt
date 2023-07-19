package com.example.mydailyjournal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.mydailyjournal.Result

class JournalingActivity : AppCompatActivity() {

    private var oTopic : String? = null
    private var mGratitude : String? = null

    private var btnSubmitJournal: Button? = null

    //private var mGratitude : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_journaling)

        oTopic = intent.getStringExtra(Constants.TOPIC)
        mGratitude = intent.getStringExtra(Constants.GRATITUDE)

        val inputtedText : EditText = findViewById(R.id.inputted_text_journal)

        val journalingTopic : TextView = findViewById(R.id.question_journal)
        journalingTopic.text = "Write a note on your topic \n \" $oTopic \""

       //mGratitude = intent.getStringExtra(Constants.GRATITUDE)

        btnSubmitJournal = findViewById(R.id.btn_submit_journal)

        btnSubmitJournal?.setOnClickListener{

            Toast.makeText(this, "Bravo! you made it to the end.", Toast.LENGTH_LONG).show()

            val intent = Intent(this, Result::class.java)    //this intent will now allow me to move from MainActivity to QuestionsActivity
            intent.putExtra(Constants.JOURNAL, inputtedText.text.toString())
            intent.putExtra(Constants.GRATITUDE, mGratitude)
            intent.putExtra(Constants.TOPIC, oTopic)
            startActivity(intent)
            finish()
        }


    }
}