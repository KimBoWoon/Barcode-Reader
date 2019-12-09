package com.bowoon.android.barcode_reader.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

fun provideResultApi() : BarcodeApi = Retrofit.Builder().apply {
    baseUrl("https://eq0lwb7e8e.execute-api.ap-northeast-2.amazonaws.com/")
    client(OkHttpClient.Builder().addInterceptor(loggingInterceptor).build())
    addConverterFactory(GsonConverterFactory.create())
    addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
}.build().create(BarcodeApi::class.java)

val loggingInterceptor = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}