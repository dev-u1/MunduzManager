package com.ulan.munduz.manager.di.moduls.builders

import com.ulan.munduz.manager.di.moduls.uimodules.*
import com.ulan.munduz.manager.di.scopes.*
import com.ulan.munduz.manager.ui.add.AddProductActivity
import com.ulan.munduz.manager.ui.detail.DetailsActivity
import com.ulan.munduz.manager.ui.main.MainActivity
import com.ulan.munduz.manager.ui.orders.OrdersActivity
import com.ulan.munduz.manager.ui.products.ProductsActivity
import com.ulan.munduz.manager.ui.slider.AddSliderActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @MainScope
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun mainActivity(): MainActivity

    @AddScope
    @ContributesAndroidInjector(modules = [AddModule::class])
    abstract fun addProductActivity(): AddProductActivity

    @ProductsScope
    @ContributesAndroidInjector(modules = [ProductsModule::class])
    abstract fun productsActivity(): ProductsActivity

    @DetailsScope
    @ContributesAndroidInjector(modules = [DetailsModule::class])
    abstract fun detailsActivity(): DetailsActivity

    @OrdersScope
    @ContributesAndroidInjector(modules = [OrdersModule::class])
    abstract fun ordersActivity(): OrdersActivity

    @SliderScope
    @ContributesAndroidInjector(modules = [SliderModule::class])
    abstract fun sliderActivity(): AddSliderActivity

}