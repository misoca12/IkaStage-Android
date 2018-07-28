package com.misoca.ikastage.di

import android.support.v7.app.AppCompatActivity
import com.misoca.ikastage.presentation.MainActivity
import com.misoca.ikastage.presentation.coop.CoopFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module interface MainActivityModule {
    @Binds fun providesAppCompatActivity(mainActivity: MainActivity): AppCompatActivity
    @ContributesAndroidInjector fun contributeCoopFragment(): CoopFragment
}