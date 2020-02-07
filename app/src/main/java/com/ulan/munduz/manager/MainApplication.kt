package com.ulan.munduz.manager

import com.ulan.munduz.manager.di.component.DaggerMainComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class MainApplication: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerMainComponent.builder().application(this).build()
    }

}