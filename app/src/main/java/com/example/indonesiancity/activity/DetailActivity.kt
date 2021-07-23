package com.example.indonesiancity.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.indonesiancity.R

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        title = "Detail"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        getIncomingIntent()
    }

    private fun getIncomingIntent() {
        if (intent.hasExtra("image_url") && intent.hasExtra("text_name") && intent.hasExtra("text_detail")) {
            val imageUrl = intent.getIntExtra("image_url", 0)
            val textName = intent.getStringExtra("text_name")
            val textDetail = intent.getStringExtra("text_detail")

            val nameReceived: TextView = findViewById(R.id.tv_received_name)
            val detailReceived: TextView = findViewById(R.id.tv_received_detail)

            val photoReceived: ImageView = findViewById(R.id.img_received)

            Glide.with(this@DetailActivity)
                .asBitmap()
                .load(imageUrl)
                .into(photoReceived)

            nameReceived.text = textName
            detailReceived.text = textDetail

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}