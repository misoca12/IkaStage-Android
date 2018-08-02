package com.misoca.ikastage.presentation

import android.content.Context
import android.support.multidex.MultiDex
import com.misoca.ikastage.BuildConfig
import com.misoca.ikastage.di.DaggerAppComponent

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber

open class IkaStageApp : DaggerApplication() {

    var userAgent: String = "IkaStage-Android/1.0 (https://github.com/misoca12/IkaStage-Android)"

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder()
                .application(this)
                .build()
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    override fun onCreate() {
        super.onCreate()
        setupTimber()
    }

    private fun setupTimber() {
        Timber.plant(Timber.DebugTree())
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}
