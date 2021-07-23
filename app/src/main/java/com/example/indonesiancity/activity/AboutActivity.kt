package com.example.indonesiancity.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.indonesiancity.R

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        title = "About"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val img: ImageView = findViewById(R.id.img_profile)
        img.setImageResource(R.drawable.tes)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}