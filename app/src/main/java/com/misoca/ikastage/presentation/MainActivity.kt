package com.misoca.ikastage.presentation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.misoca.ikastage.R
import com.misoca.ikastage.presentation.coop.CoopFragment
import com.misoca.ikastage.util.extention.replaceFragment
import dagger.android.support.DaggerAppCompatActivity
import timber.log.Timber
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject lateinit var app: IkaStageApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        supportFragmentManager.findFragmentById(R.id.content) ?:
        CoopFragment.newInstance().let {
            replaceFragment(R.id.content, it)
        }

    }

}
