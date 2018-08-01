package com.misoca.ikastage.presentation

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.misoca.ikastage.R
import com.misoca.ikastage.databinding.MainActivityBinding
import com.misoca.ikastage.presentation.coop.CoopFragment
import com.misoca.ikastage.presentation.match.MatchFragment
import com.misoca.ikastage.presentation.match.MatchPagerFragment
import com.misoca.ikastage.util.extention.replaceFragment
import dagger.android.support.DaggerAppCompatActivity
import timber.log.Timber
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject lateinit var app: IkaStageApp

    private lateinit var binding: MainActivityBinding
    private val matchPagerFragment = MatchPagerFragment.newInstance()
    private val coopFragment = CoopFragment.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<MainActivityBinding>(this, R.layout.main_activity)
        binding.navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.match -> {
                    showMatch()
                }
                R.id.coop -> {
                    showCoop()
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
        showMatch()
    }

    private fun showMatch() {
        replaceFragment(R.id.content, matchPagerFragment)
    }

    private fun showCoop() {
        replaceFragment(R.id.content, coopFragment)
    }

}
