package com.ulan.munduz.manager.adapter.listeners

import com.ulan.munduz.manager.data.model.Order

interface OrdersListCallback {
    fun onCallback(value: MutableList<Order>)
}