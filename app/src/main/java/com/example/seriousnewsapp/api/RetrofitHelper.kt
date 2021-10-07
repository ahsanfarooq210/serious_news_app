package com.example.seriousnewsapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper
{
    private const val BASE_URL="https://newsapi.org"

    fun getInstant():Retrofit
    {
        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }
}