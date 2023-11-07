package ru.bsuedu.lec05.navigationfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.bsuedu.lec05.navigationfragment.databinding.FragmentGreenBinding

class GreenFragment : Fragment() {
    private var _binding:FragmentGreenBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentGreenBinding.inflate(inflater, container, false)
        val message = GreenFragmentArgs.fromBundle(requireArguments()).message
        binding.tvGreenText.text = message

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}