package com.tistory.ssjeong.pddu.api


import com.tistory.ssjeong.pddu.response.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitAPI {

    /* 2022.12.15[프뚜]
        - @GET 또는 @POST로 HttpMethod를 지정
        - @GET("URI") path 뒤 URI를 선언, {path}는 param에서 설명
        - @Path("path") String path로 받아온 path를 URI에 매핑
     */
    @GET("posts/{post}")
    fun getPosts(@Path("post") post: String): Call<UserResponse>

}