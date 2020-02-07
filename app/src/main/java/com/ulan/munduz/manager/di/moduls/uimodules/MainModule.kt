package com.ulan.munduz.manager.di.moduls.uimodules

import com.ulan.munduz.manager.MainApplication
import com.ulan.munduz.manager.di.scopes.MainScope
import com.ulan.munduz.manager.ui.main.MainActivity
import com.ulan.munduz.manager.ui.main.MainPresenter
import com.ulan.munduz.manager.ui.main.MainPresenterImpl
import com.ulan.munduz.manager.ui.main.MainView
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class MainModule{

    @MainScope
    @Binds
    abstract fun provideMainView(activity: MainActivity): MainView

    @MainScope
    @Binds
    abstract fun providePresenter(presenter: MainPresenterImpl): MainPresenter

}