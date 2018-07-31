package com.misoca.ikastage.data.api

import com.misoca.ikastage.data.model.CoopResponse
import com.misoca.ikastage.data.model.MatchResponse
import io.reactivex.Flowable
import retrofit2.http.*

interface Spla2Api {

    @GET("/coop/schedule")
    fun getCoops(@Header("User-Agent") userAgent: String): Flowable<CoopResponse>

    @GET("/{match}/schedule")
    fun getMatches(@Header("User-Agent")  userAgent: String, @Path("match") match: String): Flowable<MatchResponse>

}
