package ru.bsuedu.lec05.navigationfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import ru.bsuedu.lec05.navigationfragment.databinding.FragmentRedBinding

class RedFragment : Fragment() {
    private var _binding:FragmentRedBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<RedFragmentArgs>()
    private val message by lazy { args.messsage }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRedBinding.inflate(inflater,container,false)
        binding.tvRedText.text = message
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}