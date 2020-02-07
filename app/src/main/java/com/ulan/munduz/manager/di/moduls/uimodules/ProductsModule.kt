package com.ulan.munduz.manager.di.moduls.uimodules

import com.ulan.munduz.manager.adapter.ProductsAdapter
import com.ulan.munduz.manager.listeners.OnItemClickListener
import com.ulan.munduz.manager.di.scopes.ProductsScope
import com.ulan.munduz.manager.ui.products.ProductsActivity
import com.ulan.munduz.manager.ui.products.ProductsPresenter
import com.ulan.munduz.manager.ui.products.ProductsPresenterImpl
import com.ulan.munduz.manager.ui.products.ProductsView
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class ProductsModule {

    @ProductsScope
    @Binds
    abstract fun provideProductsView(activity: ProductsActivity): ProductsView

    @ProductsScope
    @Binds
    abstract fun providePresenter(presenter: ProductsPresenterImpl): ProductsPresenter

    @ProductsScope
    @Binds
    abstract fun provideListener(activity: ProductsActivity): OnItemClickListener

    @Module
    companion object{

        @JvmStatic
        @Provides
        fun provideAdapter(activity: ProductsActivity, listener: OnItemClickListener): ProductsAdapter{
            return ProductsAdapter(activity, listener)
        }
    }


}