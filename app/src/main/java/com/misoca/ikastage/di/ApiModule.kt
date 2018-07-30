package com.misoca.ikastage.di

import com.misoca.ikastage.data.api.Spla2Api
import com.misoca.ikastage.data.model.Coop
import com.misoca.ikastage.data.model.CoopResponse
import com.misoca.ikastage.data.repository.CoopRepository
import com.misoca.ikastage.presentation.IkaStageApp
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import com.squareup.moshi.ToJson
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.FromJson





@Module
class ApiModule {

    @Provides
    @Singleton
    internal fun provideMoshi(): Moshi {
        return Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
    }

    @Provides
    @Singleton
    internal fun provideOkHttpClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
        client.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        return client.build()
    }

    @Provides
    @Singleton
    internal fun provideRetrofit(moshi: Moshi, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://spla2.yuu26.com")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .client(okHttpClient)
                .build()
    }

    @Provides
    @Singleton
    fun provideCoopRepository(api: Spla2Api, app: IkaStageApp): CoopRepository = CoopRepository(api, app)

    @Provides
    @Singleton
    fun provideSpla2Api(retrofit: Retrofit): Spla2Api {
        return retrofit.create(Spla2Api::class.java)
    }

}
