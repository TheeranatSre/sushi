package com.example.sushi.login.ui.main

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sushi.databinding.LoginScreenBinding
import com.example.sushi.poker.PokerActivity

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private var _binding: LoginScreenBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LoginScreenBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        binding.buttonStartAppRoLogin.setOnClickListener {
            val intentToPokerActivity = Intent(context, PokerActivity::class.java)
            startActivity(intentToPokerActivity)
        }

        binding.buttonLogin.setOnClickListener {

        }

        return binding.root
    }



}