package com.ulan.munduz.manager.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.ulan.app.munduz.helpers.convertLongToTime
import com.ulan.app.munduz.ui.Product
import com.ulan.munduz.manager.R
import com.ulan.munduz.manager.listeners.OnItemClickListener
import javax.inject.Inject

class ProductsAdapter: RecyclerView.Adapter<ProductsHolder>, Filterable {

    private var context: Context?
    private val onItemClickListener: OnItemClickListener?

    private lateinit var products: ArrayList<Product>
    private lateinit var filteredProducts: ArrayList<Product>

    @Inject
    constructor(context: Context, listener: OnItemClickListener){
        this.context = context
        this.onItemClickListener = listener
    }

    fun setProducts(products: ArrayList<Product>){
        this.products = products
        this.filteredProducts = products
        this.filteredProducts.distinct()
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ProductsHolder {
        var inflater: LayoutInflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var view = inflater.inflate(R.layout.products_items, parent, false)
        return ProductsHolder(view)
    }

    override fun onBindViewHolder(holder: ProductsHolder, position: Int) {
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
                filteredProducts = p1!!.values as ArrayList<Product>
                notifyDataSetChanged()
            }
        }
    }
}