package com.step4me.todo.screens.common.views

interface ObservableViewMvc<ListenerType> :
    ViewMvc {

    fun registerListener(listener: ListenerType)

    fun unregisterListener(listener: ListenerType)
}