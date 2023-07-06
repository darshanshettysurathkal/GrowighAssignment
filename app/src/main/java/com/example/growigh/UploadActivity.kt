package com.example.growigh

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class UploadActivity : AppCompatActivity() {

    private val REQUEST_IMAGE_PICK = 1
    private lateinit var selectedImage: Bitmap

    private lateinit var selButton: Button
    private lateinit var uploadButton: Button
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload)

        selButton = findViewById(R.id.selectbutton)
        uploadButton = findViewById(R.id.uploadButton)
        imageView = findViewById(R.id.imageView)

        selButton.setOnClickListener {
            val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(galleryIntent, REQUEST_IMAGE_PICK)
        }

        uploadButton.setOnClickListener {
           Toast.makeText(this, "No Implementation for this", Toast.LENGTH_LONG).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_IMAGE_PICK && resultCode == RESULT_OK && data != null) {
            val imageUri = data.data
            selectedImage = MediaStore.Images.Media.getBitmap(this.contentResolver, imageUri)
            imageView.setImageBitmap(selectedImage)
        }
    }
}
