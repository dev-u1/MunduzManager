package com.ulan.munduz.manager.data.repository

import com.ulan.app.munduz.ui.Product
import com.ulan.munduz.manager.adapter.listeners.OrdersListCallback
import com.ulan.munduz.manager.adapter.listeners.ProductsListCallback

interface Repository{

    fun insertProduct(product: Product)
    fun updateProduct(product: Product)
    fun getProducts(callback: ProductsListCallback)
    fun removeProduct(key: String)

    fun getOrders(callback: OrdersListCallback)
    fun getCategories() : MutableList<String>
}