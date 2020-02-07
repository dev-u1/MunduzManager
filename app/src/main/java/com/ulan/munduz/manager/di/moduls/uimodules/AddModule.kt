package com.ulan.munduz.manager.di.moduls.uimodules

import com.ulan.munduz.manager.di.moduls.FirebaseModule
import com.ulan.munduz.manager.di.scopes.AddScope
import com.ulan.munduz.manager.ui.add.AddPresenter
import com.ulan.munduz.manager.ui.add.AddPresenterImpl
import com.ulan.munduz.manager.ui.add.AddProductActivity
import com.ulan.munduz.manager.ui.add.AddView
import dagger.Binds
import dagger.Module

@Module
abstract class AddModule {

    @AddScope
    @Binds
    abstract fun provideAddView(activity: AddProductActivity): AddView

    @AddScope
    @Binds
    abstract fun provideAddPresenter(presenter: AddPresenterImpl): AddPresenter

}