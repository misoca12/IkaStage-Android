package com.misoca.ikastage.di

import com.misoca.ikastage.presentation.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class MainActivityBuilder {
    @ContributesAndroidInjector(modules = [
        MainActivityModule::class
    ])
    internal abstract fun contributeMainActivity(): MainActivity
}