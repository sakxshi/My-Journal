package com.example.mydailyjournal.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.WindowManager
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.example.mydailyjournal.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        val splashVideo: VideoView = findViewById(R.id.splashVideo)
        val videoUri = Uri.parse("android.resource://${packageName}/${R.raw.animation}")

        splashVideo.setVideoURI(videoUri)

        splashVideo.setOnCompletionListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        splashVideo.start()
    }
}
