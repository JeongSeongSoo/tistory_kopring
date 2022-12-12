package com.tistory.ssjeong.pddu.runner

import com.tistory.ssjeong.pddu.entity.Calculator
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Configuration

@Configuration
class InitRunner : ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        plus()

        // unaryOperations()
    }

    private fun plus() {
        val x: Calculator = Calculator(10)
        val y: Calculator = Calculator(20)

        println("[LOG]: ${x + y}")
    }

    private fun unaryOperations() {
        // 2022.12.12[프뚜]:
        var calculator: Calculator = Calculator(10)
        println("[LOG]: $calculator")
        println("[LOG]: ${++calculator}")
        println("[LOG]: ${--calculator}")
    }

}