package com.ulan.munduz.manager.di.moduls.builders

import com.ulan.munduz.manager.di.moduls.uimodules.MessageModule
import com.ulan.munduz.manager.di.scopes.MainScope
import com.ulan.munduz.manager.ui.message.SendMessageFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @MainScope
    @ContributesAndroidInjector(modules = [MessageModule::class])
    abstract fun messageFragment(): SendMessageFragment

}