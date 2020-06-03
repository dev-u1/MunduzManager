package com.ulan.munduz.manager.ui.orders

import com.ulan.munduz.manager.ui.adapter.OrdersAdapter
import com.ulan.munduz.manager.data.repository.Repository
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