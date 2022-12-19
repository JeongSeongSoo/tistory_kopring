package com.tistory.ssjeong.pddu.runner

import com.tistory.ssjeong.pddu.api.RetrofitAPI
import com.tistory.ssjeong.pddu.config.RetrofitConfig
import com.tistory.ssjeong.pddu.response.CandleResponse
import com.tistory.ssjeong.pddu.response.TickerResponse
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Configuration
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.sql.Timestamp
import java.text.SimpleDateFormat

@Configuration
class MainRunner : ApplicationRunner {

    // 2022.12.15[프뚜]: URI로 사용 할 인터페이스를 연결
    val api = RetrofitConfig.retrofit.create(RetrofitAPI::class.java)

    // 2022.12.19[프뚜]: sellValue
    val buyingValue = 0.004

    // 2022.12.19[프뚜]: sellValue
    val sellValue = 0.996

    // 2022.12.19[프뚜]: 구매가
    var buying = 0.0

    // 2022.12.19[프뚜]: 판매가
    var sell = 0.0

    override fun run(args: ApplicationArguments?) {
        candles()
    }

    fun candles() {
        val queryString = mutableMapOf<String, String>()
        queryString["market"] = "KRW-LOOM"
        // queryString["to"] = "2022-12-16T07:55:00"
        queryString["count"] = "1"

        // 2022.12.15[프뚜]: URI 사용 (param에 필요한 데이터 바인딩)
        val call = api.getCandles("minutes", "3", queryString);

        // 2022.12.15[프뚜]: API Start
        call.enqueue(object : Callback<List<CandleResponse>> {

            override fun onResponse(call: Call<List<CandleResponse>>, response: Response<List<CandleResponse>>) {
                val body = response.body()
                for (data in body!!) {
                    // 2022.12.19[프뚜]: 현재 조회한 분봉의 시간
                    val candleDateTimeKst = data.candle_date_time_kst.replace("T", " ")

                    // 2022.12.19[프뚜]: 시가 시점 기준으로 매수
                    val benchmark = data.opening_price * buyingValue

                    // 2022.12.19[프뚜]: 종가 - 시가
                    val difference = data.trade_price.minus(data.opening_price)
                    if (difference > benchmark) {
                        // 2022.12.19[프뚜]: 매수
                        println(candleDateTimeKst + "\t" + data.opening_price.toString() + "\t" + data.trade_price.toString() + "\t" + difference.toString() + "\t" + benchmark.toString())
                        buying = data.trade_price
                        ticker()
                    } else {
                        Thread.sleep(1200)
                        candles()
                    }
                }
            }

            override fun onFailure(call: Call<List<CandleResponse>>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }

    fun ticker() {
        val queryString = mutableMapOf<String, String>()
        queryString["markets"] = "KRW-LOOM"

        // 2022.12.15[프뚜]: URI 사용 (param에 필요한 데이터 바인딩)
        val call = api.getTickers(queryString);

        // 2022.12.15[프뚜]: API Start
        call.enqueue(object : Callback<List<TickerResponse>> {

            override fun onResponse(call: Call<List<TickerResponse>>, response: Response<List<TickerResponse>>) {
                val body = response.body()
                for (data in body!!) {
                    val body = response.body()
                    val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                    val date = sdf.format(body?.get(0)!!.timestamp)

                    if (sell == 0.0) sell = buying * sellValue

                    if (sell >= body?.get(0)!!.trade_price) {
                        println(date + "\t종료 > " + buying.toString() + " / " + body?.get(0)!!.trade_price.toString() + " / " + sell.toString())
                        sell = 0.0

                        Thread.sleep(3 * 60 * 1000)

                        candles()
                    } else {
                        if (body?.get(0)!!.trade_price * sellValue > sell) {
                            println(date + "\tsell 변경 > " + body?.get(0)!!.trade_price.toString() + " / " + sell.toString())
                            sell = body?.get(0)!!.trade_price * sellValue
                        }

                        Thread.sleep(1200)
                        ticker()
                    }
                }
            }

            override fun onFailure(call: Call<List<TickerResponse>>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }

}