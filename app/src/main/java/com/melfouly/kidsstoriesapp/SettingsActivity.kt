package com.melfouly.kidsstoriesapp

import android.os.Bundle
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        title = "Settings"

        val radio: RadioGroup = findViewById(R.id.radio)
        val pref = getSharedPreferences("settings", MODE_PRIVATE)
        val savedSize = pref.getInt("size", 24)

        when (savedSize) {
            20 -> radio.check(R.id.small_btn)
            24 -> radio.check(R.id.medium_btn)
            32 -> radio.check(R.id.large_btn)
        }

        radio.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.small_btn -> saveTextSize(20)
                R.id.medium_btn -> saveTextSize(24)
                R.id.large_btn -> saveTextSize(32)
            }
        }

    }

    fun saveTextSize(size: Int) {
        val editor = getSharedPreferences("settings", MODE_PRIVATE).edit()
        editor.putInt("size", size)
        editor.apply()
        Toast.makeText(this, "Size Changed Successfully", Toast.LENGTH_SHORT).show()
    }
}