package com.example.sushi.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.sushi.R
import com.example.sushi.databinding.LoginFragmentBinding
import com.example.sushi.ui.Activity.MainActivity

class LoginFragment : Fragment() {

    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: LoginFragmentBinding

    private var isLogin: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentBinding = LoginFragmentBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        if (isLogin) {
            binding.buttonStartApp.visibility = View.VISIBLE
            binding.buttonStartApp.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
            }
        } else {
            binding.buttonLogin.visibility = View.VISIBLE
            binding.buttonLogin.setOnClickListener {
                MainActivity.mainActivity.signInGoogle()
//                viewModel.login()
            }
        }

        viewModel.isLogin.observe(viewLifecycleOwner, {
            binding.buttonLogin.visibility = View.GONE
            binding.buttonStartApp.visibility = View.VISIBLE
            binding.buttonStartApp.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
            }
        })

        return binding.root
    }

}