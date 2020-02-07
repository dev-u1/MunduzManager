package com.ulan.munduz.manager.di.moduls.uimodules

import com.ulan.munduz.manager.di.moduls.FirebaseModule
import com.ulan.munduz.manager.di.scopes.SliderScope
import com.ulan.munduz.manager.ui.slider.AddSliderActivity
import com.ulan.munduz.manager.ui.slider.AddSliderPresenter
import com.ulan.munduz.manager.ui.slider.AddSliderPresenterImpl
import com.ulan.munduz.manager.ui.slider.AddSliderView
import dagger.Binds
import dagger.Module

@Module
abstract class SliderModule {

    @SliderScope
    @Binds
    abstract fun provideSliderView(activity: AddSliderActivity): AddSliderView

    @SliderScope
    @Binds
    abstract fun provideSliderPresenter(presenter: AddSliderPresenterImpl): AddSliderPresenter
}