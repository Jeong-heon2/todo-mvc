package com.step4me.todo.screens.common.toolbar

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.step4me.todo.R
import com.step4me.todo.screens.common.views.BaseViewMvc

class ToolbarViewMvc(
    inflater: LayoutInflater,
    parent: ViewGroup?
) : BaseViewMvc() {

    private val titleTextView: TextView

    init {
        setRootView(inflater.inflate(R.layout.layout_toolbar, parent, false))
        titleTextView = findViewById(R.id.tvToolbarTitle)
    }

    fun setTitle(title: String?) {
        titleTextView.text = title
    }
}