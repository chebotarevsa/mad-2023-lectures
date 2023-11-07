package ru.bsuedu.lab05.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ru.bsuedu.lab05.fragment.adapter.UserAdapter
import ru.bsuedu.lab05.fragment.data.UserRepository
import ru.bsuedu.lab05.fragment.databinding.FragmentListBinding
import ru.bsuedu.lab05.fragment.databinding.ItemViewBinding

class ListFragment : Fragment() {
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)

        adapter = UserAdapter() { index ->
            val action = ListFragmentDirections.actionListFragmentToDetailsFragment(index)
            findNavController().navigate(action)
        }

        adapter.users = UserRepository.users

        binding.list.adapter = adapter
        binding.list.layoutManager = LinearLayoutManager(context)

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}