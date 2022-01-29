package com.example.projectcountries.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Retrofit {

    private val mLogInterceptor = HttpLoggingInterceptor()

    private val mOkHTTPClient = OkHttpClient.Builder()
        .connectTimeout(NetConstants.SESSION_TIMEOUT, TimeUnit.MILLISECONDS)
        .readTimeout(NetConstants.SESSION_TIMEOUT, TimeUnit.MILLISECONDS)
        .addInterceptor(mLogInterceptor)
        .build()

    private val mRetrofitBuilder = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(NetConstants.SERVER_API_BASE_URL_V2)
        .client(mOkHTTPClient)
        .build()

    val mRetrofitService: RetrofitService = mRetrofitBuilder.create(RetrofitService::class.java)

    init {
        mLogInterceptor.level = HttpLoggingInterceptor.Level.BODY
    }

}