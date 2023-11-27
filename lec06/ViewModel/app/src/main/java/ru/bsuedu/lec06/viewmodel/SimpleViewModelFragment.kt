package ru.bsuedu.lec06.viewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import ru.bsuedu.lec06.viewmodel.databinding.FragmentSimpleViewModelBinding

class SimpleViewModelFragment() : Fragment() {
    //private lateinit var viewModel: SimpleViewModel
    private var _binding: FragmentSimpleViewModelBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SimpleViewModel by viewModels() {  SimpleViewModel.Factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        ///viewModel = ViewModelProvider(this , SimpleViewModel.Factory).get(SimpleViewModel::class.java)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSimpleViewModelBinding.inflate(layoutInflater, container, false)

        binding.update.setOnClickListener {
            viewModel.update()
        }

        viewModel.setObserverWeatherStation {
            binding.text.text = it.toString()
        }

        return binding.root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}