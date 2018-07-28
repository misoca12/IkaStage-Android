package com.misoca.ikastage.data.api

import com.misoca.ikastage.data.model.CoopResponse
import io.reactivex.Single
import retrofit2.http.*

interface Spla2Api {

    @GET("/coop/schedule")
    fun getCoops(@Header("User-Agent") userAgent: String): Single<CoopResponse>

}
