package ru.bsuedu.lec05.navigationfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import ru.bsuedu.lec05.navigationfragment.databinding.FragmentMainBinding

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
            val action = MainFragmentDirections.actionMainFragmentToRedFragment(text)
            findNavController().navigate(action)
        }
        binding.bnGoToGreen.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToGreenFragment(text)
            findNavController().navigate(action)
        }
        return binding.root
    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}