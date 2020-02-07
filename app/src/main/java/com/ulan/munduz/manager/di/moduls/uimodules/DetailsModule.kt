package com.ulan.munduz.manager.di.moduls.uimodules

import com.ulan.munduz.manager.di.moduls.FirebaseModule
import com.ulan.munduz.manager.di.scopes.DetailsScope
import com.ulan.munduz.manager.ui.detail.DetailsActivity
import com.ulan.munduz.manager.ui.detail.DetailsPresenter
import com.ulan.munduz.manager.ui.detail.DetailsPresenterImpl
import com.ulan.munduz.manager.ui.detail.DetailsView
import dagger.Binds
import dagger.Module

@Module
abstract class DetailsModule {

    @DetailsScope
    @Binds
    abstract fun provideDetailsView(activity: DetailsActivity): DetailsView

    @DetailsScope
    @Binds
    abstract fun provideDetailsPresenter(presenter: DetailsPresenterImpl): DetailsPresenter
}