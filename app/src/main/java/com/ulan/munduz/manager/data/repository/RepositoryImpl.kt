package com.ulan.munduz.manager.data.repository

import android.content.Context
import android.util.Log
import com.google.firebase.database.*
import com.ulan.munduz.manager.R
import com.ulan.app.munduz.helpers.Constants.Companion.ORDERS_DATA
import com.ulan.app.munduz.ui.Product
import com.ulan.app.munduz.helpers.Constants.Companion.PRODUCTS_DATA
import com.ulan.app.munduz.helpers.Constants.Companion.TAG
import com.ulan.app.munduz.helpers.showErrorReadFromDatabase
import com.ulan.munduz.manager.adapter.listeners.OrdersListCallback
import com.ulan.munduz.manager.adapter.listeners.ProductsListCallback
import com.ulan.munduz.manager.data.model.Order

class RepositoryImpl : Repository {

    private val database: FirebaseDatabase
    private val ref: DatabaseReference
    private val context: Context

    constructor(context: Context) {
        this.context = context
        database = FirebaseDatabase.getInstance()
        ref = database.getReference()
    }

    override fun insertProduct(product: Product) {
        val key = ref.push().key
        if (key == null) {
            Log.d(TAG, "Couldn't get push key for products")
            return
        }
        product.id = key
        ref.child(PRODUCTS_DATA).child(key).setValue(product)
    }

    override fun updateProduct(product: Product) {
        val key = product.id
        ref.child(PRODUCTS_DATA).child(key).setValue(product)
    }

    override fun getProducts(callback: ProductsListCallback){
        val products = ArrayList<Product>()
        ref.child(PRODUCTS_DATA).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                for (item: DataSnapshot in p0.children) {
                    val product: Product? = item.getValue(Product::class.java)
                    products.add(product!!)
                }
                callback.onCallback(products)
            }

            override fun onCancelled(p0: DatabaseError) {
                showErrorReadFromDatabase(context)
            }
        })
    }

    override fun removeProduct(key: String) {
        ref.child(PRODUCTS_DATA).child(key).removeValue()
    }

    override fun getOrders(callback: OrdersListCallback) {
        val orders = mutableListOf<Order>()
        ref.child(ORDERS_DATA).addListenerForSingleValueEvent(object : ValueEventListener{

            override fun onDataChange(p0: DataSnapshot) {
                for(item: DataSnapshot in p0.children){
                    val order = item.getValue(Order::class.java)
                    orders.add(order!!)
                }
                callback.onCallback(orders)
            }

            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }

    override fun getCategories(): MutableList<String> {
        val result = context.resources.getStringArray(R.array.category)
        return result.toMutableList()
    }
}