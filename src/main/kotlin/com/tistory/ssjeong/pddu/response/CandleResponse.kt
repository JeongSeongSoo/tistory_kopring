package com.tistory.ssjeong.pddu.response

import retrofit2.http.GET
import java.math.BigDecimal

data class CandleResponse(

    val market: String,
    val candle_date_time_utc: String,
    val candle_date_time_kst: String,
    val opening_price: Double,
    val high_price: Double,
    val low_price: Double,
    val trade_price: Double,
    var timestamp: Long,
    val candle_acc_trade_price: Double,
    val candle_acc_trade_volume: Double,
    val unit: Int

)
//{

//    val opening_price = _opening_price
//        get() {
//            return field
//        }

//}