package com.ulan.munduz.manager.di.component

import com.ulan.munduz.manager.MainApplication
import com.ulan.munduz.manager.di.moduls.AppModule
import com.ulan.munduz.manager.di.moduls.FirebaseModule
import com.ulan.munduz.manager.di.moduls.builders.ActivityBuildersModule
import com.ulan.munduz.manager.di.moduls.builders.FragmentBuilderModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class, AppModule::class,
        FirebaseModule::class, ActivityBuildersModule::class, FragmentBuilderModule::class]
)
interface MainComponent : AndroidInjector<MainApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MainApplication): MainComponent.Builder
        fun build(): MainComponent
    }

}