package ru.bsuedu.lab04.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import ru.bsuedu.lab04.spinner.databinding.ActivityCustomSpinnerBinding

class CustomSpinnerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCustomSpinnerBinding
    private lateinit var adapter: ArrayAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomSpinnerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.spinner.prompt = "Hello"

        adapter =
            ArrayAdapter(
                this,
                R.layout.spinner_item,
                R.id.text1,
                listOf("Red", "Green", "Blue"),
            )

        binding.spinner.adapter = adapter

        binding.spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(this@CustomSpinnerActivity, "Selected $position", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@CustomSpinnerActivity, "Nothing Selected", Toast.LENGTH_SHORT).show()

            }

        }


    }
}