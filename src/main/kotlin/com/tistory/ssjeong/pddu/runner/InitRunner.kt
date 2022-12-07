package com.tistory.ssjeong.pddu.runner

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Configuration

@Configuration
class InitRunner : ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        // 2022.12.07[프뚜]: null 허용 변수 선언하기
        val member: String? = "프뚜"

        // 2022.12.07[프뚜]: null 체크하기
        if (member !== null) {
            member.length
        }

        // 2022.12.07[프뚜]: null일 땐 null로 return
        member?.length

        // 2022.12.07[프뚜]: null일 땐 default value return
        member?.length ?: 10

        // 2022.12.07[프뚜]: NPE 발생할 수 있지만, 체크 없이 사용가능
        member!!.length
    }

}