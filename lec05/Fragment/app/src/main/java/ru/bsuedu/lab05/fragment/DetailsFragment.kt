package ru.bsuedu.lab05.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import ru.bsuedu.lab05.fragment.data.UserRepository
import ru.bsuedu.lab05.fragment.databinding.FragmentDetailsBinding

private const val ARG_INDEX = "index"

class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    private val args by navArgs<DetailsFragmentArgs>()
    private val index by lazy { args.index }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        val user = UserRepository.users[index]
        binding.tvDetailsName.text = user.name
        binding.tvDetailsSurname.text = user.surname
        return binding.root
    }
}