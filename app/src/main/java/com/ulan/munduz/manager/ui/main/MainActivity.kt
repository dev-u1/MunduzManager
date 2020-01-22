package com.ulan.munduz.manager.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.ulan.munduz.manager.R
import com.ulan.munduz.manager.ui.add.AddProductActivity
import com.ulan.munduz.manager.ui.message.SendMessageFragment
import com.ulan.munduz.manager.ui.orders.OrdersActivity
import com.ulan.munduz.manager.ui.products.ProductsActivity
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity: AppCompatActivity(), ManagerView {

    private lateinit var mPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        mPresenter = MainPresenterImpl(this)

        call_message_fragment.setOnClickListener {
            mPresenter.callSendMessageFragment()
        }

        call_manage_product.setOnClickListener{
            mPresenter.callProductActivity()
        }

        call_add_product.setOnClickListener{
            mPresenter.callAddActivity()
        }

        call_orders_products.setOnClickListener{
            mPresenter.callOrderActivity()
        }
    }

    override fun initToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.manage_toolbar)
        setSupportActionBar(toolbar)
        toolbar.title = "Менеджер"
        toolbar?.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp)
        toolbar?.setNavigationOnClickListener {
            finish()
        }
    }

    override fun showAddActivity() {
        val intent = Intent(this, AddProductActivity::class.java)
        startActivity(intent)
    }

    override fun showManageActivity() {
        val intent = Intent(this, ProductsActivity::class.java)
        startActivity(intent)
    }

    override fun showSendMessageFragment() {
        val ft = supportFragmentManager.beginTransaction()
        val messageFragment = SendMessageFragment()
        messageFragment.show(ft, "dialog")
    }

    override fun showOrderActivity() {
        val intent = Intent(this, OrdersActivity::class.java)
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }
}