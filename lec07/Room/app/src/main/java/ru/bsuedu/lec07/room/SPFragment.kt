package ru.bsuedu.lec07.room

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.bsuedu.lec07.room.databinding.FragmentSpBinding


class SPFragment : Fragment() {

    private var _binding: FragmentSpBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SPViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSpBinding.inflate(inflater, container, false)

        binding.bnSubmit.setOnClickListener {
            val name = binding.etName.text.toString();
            val surname = binding.etName.text.toString();
//            val sharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE)
//            with( sharedPreferences.edit()) {
//                putString(getString(R.string.name), name)
//                putString(getString(R.string.surname),surname)
//                apply()
//            }

//            val readName = sharedPreferences.getString(getString(R.string.name), "" )
//            val readSurname = sharedPreferences.getString(getString(R.string.surname), "" )
////            println("$readName - $readSurname")
//
           viewModel.insertUser(name,surname)
        }

        return binding.root
    }


    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}