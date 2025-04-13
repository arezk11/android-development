package com.seneca.onlinestore

import android.Manifest
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ProductViewModel
    private lateinit var adapter: ProductAdapter
    private var imageUri: Uri? = null


    private val takePictureLauncher = registerForActivityResult(ActivityResultContracts.TakePicture()) { success ->
        if (success && imageUri != null) {
            val imgPreview = findViewById<ImageView>(R.id.imgPreview)
            val btnViewFull = findViewById<Button>(R.id.btnViewFullImage)
            imgPreview.setImageURI(imageUri)
            imgPreview.visibility = ImageView.VISIBLE
            btnViewFull.visibility = Button.VISIBLE
        }
    }


    private val cameraPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            openCamera()
        } else {
            Toast.makeText(this, "Camera permission is required", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val titleInput = findViewById<EditText>(R.id.editTitle)
        val descInput = findViewById<EditText>(R.id.editDescription)
        val btnSave = findViewById<Button>(R.id.btnSave)
        val btnDelete = findViewById<Button>(R.id.btnDeleteFirst)
        val btnUpdateLast = findViewById<Button>(R.id.btnUpdateLast)
        val btnCapture = findViewById<Button>(R.id.btnCapture)
        val btnViewFull = findViewById<Button>(R.id.btnViewFullImage)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        adapter = ProductAdapter(emptyList())
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this)[ProductViewModel::class.java]
        viewModel.allProducts.observe(this) {
            adapter.updateList(it)
        }

        btnSave.setOnClickListener {
            val title = titleInput.text.toString().trim()
            val desc = descInput.text.toString().trim()
            if (title.isNotEmpty() && desc.isNotEmpty()) {
                viewModel.insertProduct(Product(title = title, description = desc))
                titleInput.text.clear()
                descInput.text.clear()
            }
        }

        btnDelete.setOnClickListener {
            viewModel.deleteFirstProduct()
        }

        btnUpdateLast.setOnClickListener {
            val newTitle = titleInput.text.toString().trim()
            val newDesc = descInput.text.toString().trim()
            if (newTitle.isNotEmpty() && newDesc.isNotEmpty()) {
                viewModel.updateLastProduct(newTitle, newDesc)
                titleInput.text.clear()
                descInput.text.clear()
            }
        }

        btnCapture.setOnClickListener {
            val permission = Manifest.permission.CAMERA
            if (ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED) {
                openCamera()
            } else {
                cameraPermissionLauncher.launch(permission)
            }
        }

        btnViewFull.setOnClickListener {
            val intent = Intent(this, FullImageActivity::class.java)
            intent.putExtra("imageUri", imageUri)
            startActivity(intent)
        }
    }

    private fun openCamera() {
        val values = ContentValues().apply {
            put(MediaStore.Images.Media.TITLE, "New Picture")
            put(MediaStore.Images.Media.DESCRIPTION, "From Camera")
        }
        imageUri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
        imageUri?.let { uri ->
            takePictureLauncher.launch(uri)
        }
    }
}
