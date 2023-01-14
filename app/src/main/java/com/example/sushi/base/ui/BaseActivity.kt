package com.example.sushi.base.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<B : ViewBinding, VM : ViewModel> : AppCompatActivity(),
    IProvideView<B, VM> {

    override lateinit var binding: B

    override lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = provideViewBindings()
        setContentView(binding.root)
        viewModel = provideViewModel().value
        onCreateActivity()
    }

    abstract fun onCreateActivity()
}