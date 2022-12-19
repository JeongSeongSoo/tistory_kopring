package com.tistory.ssjeong.pddu.config

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitConfig {

    // 2022.12.15[프뚜]: baseUrl > path
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.upbit.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}