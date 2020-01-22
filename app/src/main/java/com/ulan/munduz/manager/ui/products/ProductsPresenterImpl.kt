package com.ulan.munduz.manager.ui.products

import com.ulan.app.munduz.ui.Product
import com.ulan.munduz.manager.adapter.listeners.ProductsListCallback
import com.ulan.munduz.manager.data.repository.Repository

class ProductsPresenterImpl :
    ProductsPresenter {

    private var mView: ProductsView? = null
    private var mRepository: Repository
    private var mProducts = ArrayList<Product>()

    constructor(repository: Repository){
        this.mRepository = repository
    }

    override fun attachView(view: ProductsView) {
        mView = view
    }

    override fun loadProducts() : ArrayList<Product>{
        mRepository.getProducts(object :
            ProductsListCallback{
            override fun onCallback(value: ArrayList<Product>) {
                mView?.showProducts(value)
                mProducts = value
            }
        })
        return mProducts
    }

    override fun setToolbarTitle() {
        val title = "Products"
        mView?.setToolbar(title)
    }

    override fun detachView() {
        this.mView = null
    }
}