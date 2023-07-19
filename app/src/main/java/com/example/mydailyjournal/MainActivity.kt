package com.example.mydailyjournal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart : Button = findViewById(R.id.btn_start)
        val inputtedText : EditText = findViewById(R.id.inputted_tex)

        btnStart.setOnClickListener{
            if(inputtedText.text.isEmpty()){
                Toast.makeText(this, "Please give a heading", Toast.LENGTH_LONG).show()
            }
            else{
                val intent = Intent(this, QuestionsActivity::class.java)    //this intent will now allow me to move from MainActivity to QuestionsActivity
                intent.putExtra(Constants.TOPIC, inputtedText.text.toString())          //sending topic from MainActivity to QuestionsActivity
                startActivity(intent)
                finish()
            }

        }
    }

}