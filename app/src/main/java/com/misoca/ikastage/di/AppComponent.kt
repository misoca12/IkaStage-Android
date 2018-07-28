package com.misoca.ikastage.di


import com.misoca.ikastage.presentation.IkaStageApp
import dagger.BindsInstance

import javax.inject.Singleton

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ApiModule::class,
    MainActivityBuilder::class
])
interface AppComponent : AndroidInjector<IkaStageApp> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: IkaStageApp): Builder
        fun build(): AppComponent
    }
    override fun inject(app: IkaStageApp)
}
