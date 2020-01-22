package com.ulan.munduz.manager.ui.orders

import com.ulan.munduz.manager.adapter.listeners.OrdersListCallback
import com.ulan.munduz.manager.data.model.Order
import com.ulan.munduz.manager.data.repository.Repository

class OrdersPresenterImpl: OrdersPresenter{

    private var mView: OrdersView?
    private var mRepository: Repository

    constructor(view: OrdersView, repository: Repository) {
        this.mView = view
        this.mRepository = repository
    }

    override fun detachView() {
       this.mView = null
    }

    override fun showToolbar() {
        mView?.initToolbar("Category")
    }

    override fun loadCategories() {
        mRepository.getOrders(object : OrdersListCallback{
            override fun onCallback(value: MutableList<Order>) {
                mView?.showOrders(value)
            }
        })
    }
}