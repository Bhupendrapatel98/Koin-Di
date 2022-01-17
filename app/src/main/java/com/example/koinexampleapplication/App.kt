package com.example.koinexampleapplication

import android.app.Application
import com.example.koinexampleapplication.di.modeule.appmodule
import com.example.koinexampleapplication.di.modeule.repoModule
import com.example.koinexampleapplication.di.modeule.viewmodelmodule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App :Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@App)
            modules(appmodule, repoModule, viewmodelmodule)
        }
    }
}