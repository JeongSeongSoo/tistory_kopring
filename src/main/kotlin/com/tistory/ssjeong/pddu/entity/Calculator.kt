package com.tistory.ssjeong.pddu.entity

data class Calculator(val param: Int) {

    operator fun plus(calculator: Calculator): Calculator {
        return Calculator(param + calculator.param)
    }

    operator fun inc(): Calculator {
        return Calculator(param + 10)
    }

    operator fun dec(): Calculator {
        return Calculator(param - 10)
    }

}