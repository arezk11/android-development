package com.seneca.onlinestore

import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class FullImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_image)

        val imageView = findViewById<ImageView>(R.id.fullImageView)
        val uri = intent.getParcelableExtra<Uri>("imageUri")
        uri?.let {
            imageView.setImageURI(it)
        }
    }
}
