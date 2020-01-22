package com.ulan.munduz.manager.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ulan.app.munduz.helpers.convertLongToTime
import com.ulan.munduz.manager.R
import com.ulan.munduz.manager.data.model.Order

class OrdersAdapter : RecyclerView.Adapter<OrdersAdapter.CategoryViewHolder> {

    private var context: Context
    private var orders: MutableList<Order>

    constructor(context: Context, categories: MutableList<Order>) : super() {
        this.context = context
        this.orders = categories
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.orders_item, parent, false)
        return CategoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return orders.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val order = orders.get(position)
        holder.body.text = order.body
        holder.phoneNumber.text = order.phoneNumber.toString()
        holder.time.text = order.time.convertLongToTime(order.time)
    }

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val body = itemView.findViewById<TextView>(R.id.order_body)
        val phoneNumber = itemView.findViewById<TextView>(R.id.order_phone_number)
        val time = itemView.findViewById<TextView>(R.id.order_time)

    }
}