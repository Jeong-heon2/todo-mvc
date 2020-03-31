package com.step4me.todo.screens.common

import androidx.appcompat.app.AppCompatActivity
import com.step4me.todo.CustomApplication
import com.step4me.todo.common.dependencyinjection.ControllerCompositionRoot

open class BaseActivity : AppCompatActivity() {

    protected var compositionRoot: ControllerCompositionRoot? = null
        get() {
            if (field == null) {
                compositionRoot = ControllerCompositionRoot(
                    (application as CustomApplication).compositionRoot,
                    this
                )
            }
            return field
        }
        private set
}