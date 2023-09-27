package ru.bsuedu.navigation

import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf

class DateTimeContract : ActivityResultContract<String, String>() {
    override fun createIntent(context: Context, input: String): Intent {
        return Intent().apply {
            setClass(context,RequestDateTimeActivity::class.java)
            replaceExtras(bundleOf(EXTRAS_DATE_TIME to input))
        }

    }

    override fun parseResult(resultCode: Int, intent: Intent?): String {
        return if (resultCode == AppCompatActivity.RESULT_OK)
            intent?.getStringExtra(EXTRAS_DATE_TIME) ?: ""
        else ""

    }
}