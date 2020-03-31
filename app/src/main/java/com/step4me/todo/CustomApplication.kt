package com.step4me.todo

import android.app.Application
import com.step4me.todo.common.dependencyinjection.CompositionRoot

class CustomApplication : Application() {

    lateinit var compositionRoot: CompositionRoot
        private set

    override fun onCreate() {
        super.onCreate()
        compositionRoot = CompositionRoot()
    }
}