package ru.bsuedu.lec05.simplenavigationfragment

import android.os.Bundle
import android.view.GestureDetector
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.bsuedu.lec05.simplenavigationfragment.databinding.FragmentGreenBinding

class GreenFragment : Fragment() {
    private var _binding: FragmentGreenBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentGreenBinding.inflate(inflater, container, false)
        binding.tvGreenText.text = arguments?.getString(ARG_MESSAGE)

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {

        fun createInstance(message: String): GreenFragment =
            GreenFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_MESSAGE, message)
                }
            }

    }

}