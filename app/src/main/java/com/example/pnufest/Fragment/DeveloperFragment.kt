package com.example.pnufest.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.pnufest.R
import com.example.pnufest.databinding.FragmentDeveloperBinding

class DeveloperFragment : Fragment() {
    private lateinit var binding: FragmentDeveloperBinding
    //private val viewModel: DeveloperViewModel by viewModel()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_developer, container, false)
       // binding.vm = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

}