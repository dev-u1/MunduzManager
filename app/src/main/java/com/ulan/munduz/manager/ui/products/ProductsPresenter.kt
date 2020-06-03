package com.ulan.munduz.manager.ui.products

import com.ulan.app.munduz.ui.Product

interface ProductsPresenter {

    fun setToolbarTitle()
    fun loadProducts()
    fun detachView()
}