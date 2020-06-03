package com.ulan.munduz.manager.ui.orders

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.ulan.munduz.manager.R
import com.ulan.munduz.manager.ui.adapter.OrdersAdapter
import com.ulan.munduz.manager.data.models.Order
import com.ulan.munduz.manager.ui.base.BaseActivity
import kotlinx.android.synthetic.main.orders_layout.*
import javax.inject.Inject

class OrdersActivity : BaseActivity(), OrdersView {

    @Inject
    lateinit var adapter: OrdersAdapter

    @Inject
    lateinit var mPresenter: OrdersPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.orders_layout)

        mPresenter.showToolbar()
        mPresenter.loadCategories()
    }

    override fun initToolbar(title: String) {
        setSupportActionBar(orders_toolbar)
        supportActionBar?.title = title
        orders_toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp)
        orders_toolbar.setNavigationOnClickListener {
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
        adapter.setCategories(categories)
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