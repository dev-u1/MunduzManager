package com.ulan.munduz.manager.ui.products

import com.ulan.app.munduz.ui.Product
import com.ulan.munduz.manager.listeners.ProductsListCallback
import com.ulan.munduz.manager.data.repository.Repository
import javax.inject.Inject

class ProductsPresenterImpl :
    ProductsPresenter {

    private var mView: ProductsView? = null
    private var mRepository: Repository

    @Inject
    constructor(view: ProductsView, repository: Repository){
        this.mView = view
        this.mRepository = repository
    }

    override fun loadProducts() : ArrayList<Product>{
        var products = ArrayList<Product>()
        mRepository.getProducts(object :
            ProductsListCallback{
            override fun onCallback(value: ArrayList<Product>) {
                mView?.showProducts(value)
                products = value
            }
        })
        return products
    }

    override fun setToolbarTitle() {
        val title = "Список"
        mView?.setToolbar(title)
    }

    override fun detachView() {
        this.mView = null
    }
}