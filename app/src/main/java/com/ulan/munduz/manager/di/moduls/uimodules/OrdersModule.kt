package com.ulan.munduz.manager.di.moduls.uimodules

import android.content.Context
import com.ulan.munduz.manager.adapter.OrdersAdapter
import com.ulan.munduz.manager.data.repository.Repository
import com.ulan.munduz.manager.di.moduls.FirebaseModule
import com.ulan.munduz.manager.di.scopes.OrdersScope
import com.ulan.munduz.manager.ui.main.MainActivity
import com.ulan.munduz.manager.ui.orders.OrdersActivity
import com.ulan.munduz.manager.ui.orders.OrdersPresenter
import com.ulan.munduz.manager.ui.orders.OrdersPresenterImpl
import com.ulan.munduz.manager.ui.orders.OrdersView
import dagger.Module
import dagger.Provides

@Module
class OrdersModule {

    @OrdersScope
    @Provides
    fun provideOrdersView(activity: OrdersActivity): OrdersView {
        return activity
    }

    @OrdersScope
    @Provides
    fun provideOrdersPresenter(view: OrdersView, repository: Repository): OrdersPresenter {
        return OrdersPresenterImpl(view, repository)
    }

    @OrdersScope
    @Provides
    fun provideOrdersAdapter(activity: OrdersActivity): OrdersAdapter {
        return OrdersAdapter(activity)
    }
}