package com.misoca.ikastage.data.repository

import javax.inject.Inject
import javax.inject.Singleton
import com.misoca.ikastage.data.api.Spla2Api
import com.misoca.ikastage.data.model.CoopResponse
import com.misoca.ikastage.data.model.MatchResponse
import com.misoca.ikastage.presentation.IkaStageApp
import io.reactivex.Flowable
import io.reactivex.Single

@Singleton
class Spla2Repository @Inject constructor(private val spla2Api: Spla2Api, private val app: IkaStageApp) {

    fun loadCoop(): Flowable<CoopResponse> {
        // TODO APIとDBを振り分ける
        return spla2Api.getCoops(app.userAgent)
    }

    fun loadMatch(match: String): Flowable<MatchResponse> {
        // TODO APIとDBを振り分ける
        return spla2Api.getMatches(app.userAgent, match)
    }
    
}
