package com.step4me.todo.common.dependencyinjection

import android.app.Activity
import android.view.LayoutInflater
import com.step4me.todo.screens.common.ViewMvcFactory
import com.step4me.todo.screens.common.screensnavigator.ScreensNavigator

class ControllerCompositionRoot(compositionRoot: CompositionRoot, activity: Activity) {

    private val layoutInflater = LayoutInflater.from(activity)

    val viewMvcFactory = ViewMvcFactory(layoutInflater)

    val screensNavigator = ScreensNavigator(activity)
}