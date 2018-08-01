package com.misoca.ikastage.presentation.coop

import android.arch.lifecycle.*
import com.misoca.ikastage.data.model.CoopResponse
import com.misoca.ikastage.data.repository.Spla2Repository
import com.misoca.ikastage.util.extention.toLiveData
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class CoopViewModel @Inject constructor(private val repository: Spla2Repository): ViewModel() {

    val coopResponse: LiveData<CoopResponse>

    init {
        // リポジトリからCoop情報を取得
        coopResponse = repository.loadCoop()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(Flowable.empty())
                .toLiveData() // FlowableをLiveDataに変換する
    }

}