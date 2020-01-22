package com.ulan.munduz.manager.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ulan.app.munduz.helpers.convertLongToTime
import com.ulan.app.munduz.ui.Product
import com.ulan.munduz.manager.R
import com.ulan.munduz.manager.adapter.listeners.OnItemClickListener

class ProductAdapter: RecyclerView.Adapter<ProductHolder>, Filterable {

    private var products: ArrayList<Product>
    private var filteredProducts: ArrayList<Product>
    private var context: Context?
    private val onItemClickListener: OnItemClickListener?

    constructor(context: Context, items: ArrayList<Product>, listener: OnItemClickListener){
        this.context = context
        this.products = items
        this.filteredProducts = items
        this.onItemClickListener = listener
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ProductHolder {
        var inflater: LayoutInflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var view = inflater.inflate(R.layout.products_items, parent, false)
        return ProductHolder(view)
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        var product: Product? = filteredProducts.get(position)
        holder.bind(product, onItemClickListener)
        holder.item_name.text = product!!.name
        holder.item_category.text = product!!.category
        holder.item_cost.text = product.date.convertLongToTime(product!!.date)
    }

    override fun getItemCount(): Int {
        return filteredProducts.size
    }

    override fun getFilter(): Filter {
        return object: Filter(){
            override fun performFiltering(p0: CharSequence?): FilterResults {
                val pattern = p0.toString()

                if(pattern.isEmpty()){
                    filteredProducts = products
                }else{
                    val filteredList = ArrayList<Product>()
                    for(product: Product in products){
                        if(product.name.toLowerCase().contains(pattern)){
                            filteredList.add(product)
                        }
                    }
                    filteredProducts = filteredList
                }

                val results: FilterResults = FilterResults()
                results.values = filteredProducts
                return results

            }

            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                notifyDataSetChanged()
            }
        }
    }
}