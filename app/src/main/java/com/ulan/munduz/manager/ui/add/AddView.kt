package com.ulan.munduz.manager.ui.add

import com.ulan.app.munduz.ui.Product

interface AddView {

    fun initToolbar(title: String)
    fun getInputProduct(): Product
    fun clearFields()
    fun chooseImage()
    fun checkForNull()
    fun setCategories(categories: MutableList<String>)


}