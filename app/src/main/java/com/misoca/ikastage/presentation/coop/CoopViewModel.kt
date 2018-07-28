package com.misoca.ikastage.presentation.coop

import android.databinding.BaseObservable
import com.misoca.ikastage.data.model.Coop
import com.misoca.ikastage.data.model.CoopResponse
import com.misoca.ikastage.data.repository.CoopRepository
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class CoopViewModel @Inject constructor(private val repository: CoopRepository): BaseObservable() {
    val adapter: CoopAdapter? = null
    fun loadCoop() {
        repository.loadCoop()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe ({
                    Timber.d("loadCoop -> onSuccess")
                    if (it.result is List<Coop>) {
                        Timber.d("coop " + it.result.size)
                    }
                },{
                    Timber.e("loadCoop -> onError")
                    Timber.e(it)
                })
    }
}