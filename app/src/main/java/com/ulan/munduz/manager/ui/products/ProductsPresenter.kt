package com.ulan.munduz.manager.ui.products

import com.ulan.app.munduz.ui.Product

interface ProductsPresenter {

    fun attachView(view: ProductsView)
    fun detachView()
    fun loadProducts() : ArrayList<Product>
    fun setToolbarTitle()
}