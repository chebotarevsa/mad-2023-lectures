package ru.bsuedu.lec05.simplenavigationfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.bsuedu.lec05.simplenavigationfragment.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val text get() = binding.etInput.text.toString()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)

        binding.bnGoToRed.setOnClickListener {
            (activity as Navigator).goToRed(binding.etInput.text.toString())

        }
        binding.bnGoToGreen.setOnClickListener {
            (activity as Navigator).goToGreen(binding.etInput.text.toString())
        }
        return binding.root
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}