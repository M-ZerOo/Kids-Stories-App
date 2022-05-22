package com.melfouly.kidsstoriesapp

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class StoryActivity : AppCompatActivity() {

    lateinit var media: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story)

        title = intent.getStringExtra("title")
        val story = intent.getStringExtra("story")
        val sound = intent.getIntExtra("sound", -1)
        val picture = intent.getIntExtra("picture", -2)

        media = MediaPlayer.create(this, sound)
        media.start()

        val storyTV: TextView = findViewById(R.id.story_tv)
        val storyIV: ImageView = findViewById(R.id.story_iv)
        val pref = getSharedPreferences("settings", MODE_PRIVATE)
        val size = pref.getInt("size", 24)

        storyIV.setImageResource(picture)
        storyTV.text = story
        storyTV.textSize = size.toFloat()

    }

    override fun onPause() {
        super.onPause()
        media.release()
    }
}