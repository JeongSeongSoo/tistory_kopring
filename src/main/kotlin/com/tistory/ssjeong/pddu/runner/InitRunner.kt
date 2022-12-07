package com.tistory.ssjeong.pddu.runner

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Configuration

@Configuration
class InitRunner : ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        // loop()
        condition()
    }

    fun loop() {
        // 2022.12.07[프뚜]: step에 따라 값을 증감
        for (i in 1..3 step 1) {
            print(i) // 1 2 3
        }

        for (i in 3 downTo 1 step 1) {
            print(i) // 3 2 1
        }

        // 2022.12.07[프뚜]: 배열의 값을 하나씩 꺼낼 때 사용
        val names: Array<String> = arrayOf("프뚜", "먹뚜")
        for (name in names) {
            print(name) // 프뚜 먹뚜
        }

        // 2022.12.07[프뚜]: 배열의 Index를 꺼낼 때 사용
        for (index in names.indices) {
            print(index) // 0 1
        }

        // 2022.12.07[프뚜]: Index, Value 모두 꺼낼 때 사용
        for ((index, value) in names.withIndex()) {
            println("Index: ${index}, Value: ${value}")
            // Index: 0, Value: 프뚜
            // Index: 1, Value: 먹뚜
        }

        var count: Int = 5

        // 2022.12.07[프뚜]: 조건이 맞을 때까지 반복
        while (count > 0) {
            print(count--) // 5 4 3 2 1
        }

        // 2022.12.07[프뚜]: 조건이 맞지 않아도 최초 한 번은 실행
        do {
            print(count) // 0
        } while (count == 100)
    }

    fun condition() {
        var count: Int = 0
        if (count > 0) count = 1
        else count = 0

        if (count > 0) {
            count = 1
        } else {
            count = 0
        }

        // 2022.12.07[프뚜]: 3항 연산자
        val result: Int = if (100 > 0) 100 else 0 // 100


        // 2022.12.07[프뚜]: 3항 연산자 > 다중 코드 실행 { }
        var compare = if (100 > 0) {
            print("크다")
            100
        } else {
            print("작다")
            0
        }

        // 2022.12.07[프뚜]: 컴파일 오류 발생(return 하는것과 다름 > 반환하는 것)
        /*
            compare = if (100 > 0) {
                print("크다")
                return 100
            } else {
                print("작다")
                return 0
            }
        */

        val number: Int = 1
        when (number) {
            1 -> {
                print("number value > 1")
            }

            2 -> {
                print("number value > 2")
            }

            else -> {
                print("number value > ${number}")
            }
        }

        when (number) {
            1, 2 -> {
                print("number value > 1 OR 2")
            }

            else -> {
                print("number value > ${number}")
            }
        }

        when (number) {
            in 1 .. 10 -> {
                print("number value > 1 ~ 10")
            }

            in 11 .. 20 -> {
                print("number value > 11 ~ 20")
            }

            else -> {
                print("number value > ${number}")
            }
        }
    }
}