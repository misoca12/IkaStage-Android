package com.misoca.ikastage.di

import android.arch.lifecycle.ViewModel
import android.support.v7.app.AppCompatActivity
import com.misoca.ikastage.presentation.MainActivity
import com.misoca.ikastage.presentation.coop.CoopFragment
import com.misoca.ikastage.presentation.coop.CoopViewModel
import com.misoca.ikastage.presentation.match.MatchFragment
import com.misoca.ikastage.presentation.match.MatchViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module interface MainActivityModule {

    @Binds
    @IntoMap
    @ViewModelKey(CoopViewModel::class)
    abstract fun bindCoopViewModel(viewModel: CoopViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MatchViewModel::class)
    abstract fun bindMatchViewModel(viewModel: MatchViewModel): ViewModel

    @ContributesAndroidInjector fun contributeCoopFragment(): CoopFragment
    @ContributesAndroidInjector fun contributeMatchFragment(): MatchFragment

}