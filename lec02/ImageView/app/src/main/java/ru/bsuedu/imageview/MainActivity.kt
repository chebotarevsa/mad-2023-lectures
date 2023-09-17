package ru.bsuedu.imageview

import android.R.attr.bitmap
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException


const val GALLERY_REQUEST = 1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            getImageContent.launch("image/*")
        }
    }

    private val getContent = registerForActivityResult(TakePhotoContract()) {
        val imageView = findViewById<ImageView>(R.id.image)
        val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, it)
        imageView.setImageBitmap(bitmap)
    }

    private val getImageContent = registerForActivityResult(ActivityResultContracts.GetContent()){
        val imageView = findViewById<ImageView>(R.id.image)
        val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, it)
        imageView.setImageBitmap(bitmap)
    }

}