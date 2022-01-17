package com.example.koinexampleapplication.di.modeule

import com.example.koinexampleapplication.data.repository.MainRepository
import org.koin.dsl.module

val repoModule = module {
    single {
        MainRepository(get())
    }
}