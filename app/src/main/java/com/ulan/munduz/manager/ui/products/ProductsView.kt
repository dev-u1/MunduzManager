package com.ulan.munduz.manager.ui.products

import com.ulan.app.munduz.ui.Product

interface ProductsView {

    fun setToolbar(title: String)
    fun showProducts(products: ArrayList<Product>)
    fun showNoProducts(message: String)
    fun hideProgressBar()
}