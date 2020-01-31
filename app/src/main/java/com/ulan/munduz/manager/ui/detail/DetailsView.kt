package com.ulan.munduz.manager.ui.detail

import com.ulan.app.munduz.ui.Product

interface DetailsView {

    fun initToolbar(title: String)
    fun setCategories(categories: MutableList<String>)
    fun setProduct(product: Product?)
    fun getInputProduct():Product
    fun showDialog()
    fun chooseImage()
    fun checkForNull()
}