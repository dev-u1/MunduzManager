package com.ulan.munduz.manager.ui.orders

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ulan.munduz.manager.R
import com.ulan.munduz.manager.adapter.OrdersAdapter
import com.ulan.munduz.manager.data.model.Order
import com.ulan.munduz.manager.data.repository.Repository
import com.ulan.munduz.manager.data.repository.RepositoryImpl
import kotlinx.android.synthetic.main.orders_layout.*

class OrdersActivity : AppCompatActivity(), OrdersView {

    private lateinit var adapter: OrdersAdapter
    private lateinit var mPresenter: OrdersPresenter
    private lateinit var mRepository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.orders_layout)
        
        mRepository = RepositoryImpl(this)
        mPresenter = OrdersPresenterImpl(this, mRepository)
        mPresenter.showToolbar()
        mPresenter.loadCategories()
      
    }

    override fun initToolbar(title: String) {
        setSupportActionBar(category_toolbar)
        supportActionBar?.title = title
        category_toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp)
        category_toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    override fun showProgress() {
       progress_bar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress_bar.visibility = View.GONE
    }

    override fun showOrders(categories: MutableList<Order>) {
        val layoutManager = LinearLayoutManager(this)
        category_recycler_view.layoutManager = layoutManager
        adapter = OrdersAdapter(this, categories)
        category_recycler_view.adapter = adapter
    }

    override fun onPause() {
        super.onPause()
        adapter.notifyDataSetChanged()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }
}