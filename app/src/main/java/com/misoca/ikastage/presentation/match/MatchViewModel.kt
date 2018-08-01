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

class MatchViewModel @Inject constructor(private val repository: Spla2Repository): ViewModel() {

    val match = MutableLiveData<String>()
    // matchの変更を検出してMatchAPIをコールする
    val matchResponse: LiveData<MatchResponse> = Transformations.switchMap(match, {
        // リポジトリからMatch情報を取得
        repository.loadMatch(it)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(Flowable.empty())
                .toLiveData() // FlowableをLiveDataに変換する
    })

}