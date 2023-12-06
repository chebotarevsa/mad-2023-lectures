package ru.bsuedu.lec07.room

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import ru.bsuedu.lec07.room.databinding.FragmentRoomBinding
import kotlin.concurrent.thread

class RoomFragment : Fragment() {

    private var _binding: FragmentRoomBinding? = null
    private val binding get() = _binding!!

    private val viewModel: RoomViewModel by viewModels { RoomViewModel.Factory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRoomBinding.inflate(inflater, container, false)

        binding.bnSubmit.setOnClickListener {
            viewModel.insertUser(
                binding.etName.text.toString(),
                binding.etSurname.text.toString(),
            )
        }

        return binding.root
    }


    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}