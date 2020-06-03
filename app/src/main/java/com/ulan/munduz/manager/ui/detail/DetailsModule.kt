package com.ulan.munduz.manager.ui.detail

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