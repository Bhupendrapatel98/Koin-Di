package com.example.koinexampleapplication.di.modeule

import com.example.koinexampleapplication.ui.main.viewModel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewmodelmodule = module {

    viewModel {
        MainViewModel(get(),get())
    }
}