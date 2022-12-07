package com.tistory.ssjeong.pddu.runner

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Configuration

@Configuration
class InitRunner : ApplicationRunner {

    override fun run(args: ApplicationArguments?) {

    }

    fun plus(x: Int = 4,
             y: Int = 3,): Int {
        return x + y;
    }

    fun plus2(x: Int = 4, y: Int = 3): Int = x + y
}