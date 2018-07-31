package com.misoca.ikastage.presentation.match

import android.arch.lifecycle.*
import com.misoca.ikastage.data.model.MatchResponse
import com.misoca.ikastage.data.repository.Spla2Repository
import com.misoca.ikastage.util.extention.toLiveData
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class MatchViewModel @Inject constructor(private val repository: Spla2Repository): ViewModel(), LifecycleObserver {

    val match = MutableLiveData<String>()
    val matchResponse: LiveData<MatchResponse> = Transformations.switchMap(match, {
        repository.loadMatch(it)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(Flowable.empty())
                .toLiveData() // FlowableをLiveDataに変換する
    })

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        Timber.d("CoopViewModel onCreate")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        Timber.d("CoopViewModel onStart")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        Timber.d("CoopViewModel onResume")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        Timber.d("CoopViewModel onPause")
    }

}