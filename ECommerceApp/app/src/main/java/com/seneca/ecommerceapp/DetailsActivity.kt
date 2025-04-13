package com.seneca.ecommerceapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val imageView: ImageView = findViewById(R.id.detailImage)
        val titleView: TextView = findViewById(R.id.detailTitle)
        val descView: TextView = findViewById(R.id.detailDescription)

        val image = intent.getIntExtra("image", 0)
        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")

        imageView.setImageResource(image)
        titleView.text = title
        descView.text = description
    }
}
