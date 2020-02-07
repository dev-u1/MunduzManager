package com.ulan.munduz.manager.data.repository

import com.ulan.app.munduz.ui.Product
import com.ulan.munduz.manager.listeners.OrdersListCallback
import com.ulan.munduz.manager.listeners.ProductsListCallback
import com.ulan.munduz.manager.data.models.SliderImage

interface Repository{

    fun insertProduct(product: Product)
    fun updateProduct(product: Product)
    fun getProducts(callback: ProductsListCallback)
    fun removeProduct(key: String)

    fun getOrders(callback: OrdersListCallback)
    fun getCategories() : MutableList<String>

    fun insertSliderImage(name: String, sliderImage: SliderImage)
    fun getSliderImage(queryName: String) : SliderImage
}