package com.example.growigh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.Button

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val feedsButton = findViewById<Button>(R.id.feedsButton)
        val uploadButton = findViewById<Button>(R.id.uploadButton)

        feedsButton.setOnClickListener {
            openFeedActivity()
        }

        uploadButton.setOnClickListener {
            openUploadActivity()
        }
    }

    private fun openFeedActivity() {
        val intent = Intent(this, FeedActivity::class.java)
        startActivity(intent)
    }

    private fun openUploadActivity() {
        val intent = Intent(this, UploadActivity::class.java)
        startActivity(intent)
    }
}
