package com.example.projectcountries.network

import com.example.projectcountries.model.CountryModelV2
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

    @GET(NetConstants.GET_ALL_COUNTRIES_V2_URL)
    fun getPostsV2(): Call<List<CountryModelV2>>

    @GET(NetConstants.GET_ALL_COUNTRIES_V3_URL)
    fun getPostsV3(): Call<List<CountryModelV2>>

}