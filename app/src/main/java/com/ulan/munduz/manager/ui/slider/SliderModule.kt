package com.ulan.munduz.manager.ui.slider

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