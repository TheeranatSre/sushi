package com.example.sushi.base.ui

import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

interface IProvideView<B : ViewBinding, VM : ViewModel> {

    var binding: B
    var viewModel: VM

    fun provideViewModel(): Lazy<VM>

    fun provideViewBindings(): B
}