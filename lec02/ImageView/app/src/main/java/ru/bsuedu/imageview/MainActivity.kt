package ru.bsuedu.imageview

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity


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
        val bitmap = getCapturedImage(it!!)
        imageView.setImageBitmap(bitmap)
    }

    private val getImageContent = registerForActivityResult(ActivityResultContracts.GetContent()) {
        val imageView = findViewById<ImageView>(R.id.image)
        val image = getCapturedImage(it!!)
        imageView.setImageBitmap(image)
    }

    private fun getCapturedImage(selectedPhotoUri: Uri): Bitmap {
        return when {
            Build.VERSION.SDK_INT < 28 -> MediaStore.Images.Media.getBitmap(
                this.contentResolver,
                selectedPhotoUri
            )

            else -> {
                val source = ImageDecoder.createSource(this.contentResolver, selectedPhotoUri)
                ImageDecoder.decodeBitmap(source)
            }
        }

    }
}