package ru.bsuedu.implicitintent

import android.Manifest.permission.READ_CONTACTS
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.ContactsContract.CommonDataKinds.Phone
import androidx.activity.result.contract.ActivityResultContracts
import ru.bsuedu.implicitintent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            Intent(Intent.ACTION_SEND)
                .apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, "Simple text")
                    putExtra(Intent.EXTRA_SUBJECT, "sachebotarev@gmail.com")
                }.also { intent ->
                    startActivity(intent)
                }
        }

        binding.bnContact.setOnClickListener {
            singlePermission.launch(READ_CONTACTS)
        }


    }


    val singlePermission = registerForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
        when {
            granted -> {
                getContact.launch(null)
            }
            !shouldShowRequestPermissionRationale(READ_CONTACTS) -> {
                // доступ к камере запрещен, пользователь поставил галочку Don't ask again.
            }
            else -> {
                // доступ к камере запрещен, пользователь отклонил запрос
            }
        }
    }

    val getContact =
        registerForActivityResult(ActivityResultContracts.PickContact()) { contactUri ->
            contactUri?.let {
                contentResolver.query(
                   contactUri,
                    listOf(Phone.DISPLAY_NAME).toTypedArray(),
                    null,
                    null,
                    null
                )
            }?.use {
                it.moveToFirst()
                val  string = it.getString(0)
            }
        }
}