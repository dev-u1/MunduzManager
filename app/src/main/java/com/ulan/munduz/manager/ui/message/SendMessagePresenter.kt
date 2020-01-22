package com.ulan.munduz.manager.ui.message

interface SendMessagePresenter {

    fun detachView()
    fun sendButtonClicked()
    fun cancelButtonClicked()
}