package ru.bsuedu.imageview

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.activity.result.contract.ActivityResultContract
import androidx.appcompat.app.AppCompatActivity

class TakePhotoContract : ActivityResultContract<String, Uri?>() {
    override fun createIntent(context: Context, input: String): Intent =
        Intent(Intent.ACTION_PICK).apply {
            type = input
        }

    override fun parseResult(resultCode: Int, intent: Intent?): Uri? =
        if (resultCode == AppCompatActivity.RESULT_OK) intent?.data else null
}