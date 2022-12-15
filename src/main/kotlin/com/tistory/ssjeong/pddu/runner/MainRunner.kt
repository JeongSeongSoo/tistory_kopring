package com.tistory.ssjeong.pddu.runner

import com.tistory.ssjeong.pddu.api.RetrofitAPI
import com.tistory.ssjeong.pddu.config.RetrofitConfig
import com.tistory.ssjeong.pddu.response.UserResponse
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Configuration
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Configuration
class MainRunner : ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        // 2022.12.15[프뚜]: URI로 사용 할 인터페이스를 연결
        val api = RetrofitConfig.retrofit.create(RetrofitAPI::class.java)

        // 2022.12.15[프뚜]: URI 사용 (param에 필요한 데이터 바인딩)
        val call = api.getPosts("1")

        // 2022.12.15[프뚜]: API Start
        call.enqueue(object : Callback<UserResponse> {

            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                print(response.body()) // UserResponse(userId=1, id=1, title=sunt aut facere repellat provident occaecati excepturi optio reprehenderit, body=quia et suscipit suscipit recusandae consequuntur expedita et cum reprehenderit molestiae ut ut quas totam nostrum rerum est autem sunt rem eveniet architecto)
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }

}