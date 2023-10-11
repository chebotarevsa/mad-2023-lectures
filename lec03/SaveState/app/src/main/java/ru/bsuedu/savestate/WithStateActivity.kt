package ru.bsuedu.savestate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import ru.bsuedu.savestate.databinding.ActivityWithStateBinding

class WithStateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWithStateBinding
    private var current: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWithStateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.i(WithoutStateActivity.TAG, "onCreate -- $savedInstanceState")

        if (savedInstanceState != null) {

//            current = savedInstanceState.getString(Keys.VALUE)?.toInt() ?: 0
//            binding.textView.setTextColor(savedInstanceState.getInt(Keys.COLOR))
//            binding.textView.setTextSize(
//                TypedValue.COMPLEX_UNIT_PX,
//                savedInstanceState.getFloat(Keys.SIZE)
//            )

//            Serializable
//            val state = savedInstanceState.getSerializable(Keys.SERIAL) as StateSerializable
//            current = state.value.toInt()
//            binding.textView.setTextColor(state.color)
//            binding.textView.setTextSize(
//                TypedValue.COMPLEX_UNIT_PX,
//                state.size
//            )

//            Parcelable
            val state = savedInstanceState.getParcelable<StateParcelable>(Keys.PARCE)
            state?.let {
                current = it.value.toInt()
                binding.textView.setTextColor(it.color)
                binding.textView.setTextSize(
                    TypedValue.COMPLEX_UNIT_PX,
                    it.size
                )
            }

        }

        binding.textView.text = current.toString()

        binding.button.setOnClickListener {
            binding.textView.text = (++current).toString()
            binding.textView.setTextColor(Utils.createRandomColor())
            binding.textView.textSize = Utils.createRandomFontSize()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
//        Simple
//        outState.putString(Keys.VALUE, binding.textView.text.toString())
//        outState.putFloat(Keys.SIZE, binding.textView.textSize)
//        outState.putInt(Keys.COLOR, binding.textView.currentTextColor)

//        Serializable
//        outState.putSerializable(Keys.SERIAL, StateSerializable(
//            binding.textView.text.toString(),
//            binding.textView.textSize,
//            binding.textView.currentTextColor))

//        Parcelable
        outState.putParcelable(
            Keys.PARCE, StateParcelable(
                binding.textView.text.toString(),
                binding.textView.textSize,
                binding.textView.currentTextColor
            )
        )

        super.onSaveInstanceState(outState)
    }

    override fun onStart() {
        super.onStart()
        Log.i(WithoutStateActivity.TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(WithoutStateActivity.TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(WithoutStateActivity.TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(WithoutStateActivity.TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(WithoutStateActivity.TAG, "onDestroy")
    }

    companion object {
        val TAG = MainActivity::class.simpleName
    }
}