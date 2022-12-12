package com.tistory.ssjeong.pddu.runner

import com.tistory.ssjeong.pddu.entity.UserEntity
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Configuration

@Configuration
class InitRunner : ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        // newInstance()

        // letFunc()

        // runFunc()

        // withFunc()

        // alsoFunc()

        applyFunc()
    }

    private fun newInstance() {
        // 2022.12.[프뚜]:
        val user = UserEntity("프뚜", 20)
        println(user)

        user.incrementAge()
        user.setName("먹뚜")
        println(user)
    }

    private fun letFunc() {
        // 2022.12.12[프뚜]: it, lambda
        var user = UserEntity("프뚜", 20).let {
            println("[LOG]: ${it}")

            it.incrementAge()
            it.setName("먹뚜")
            println("[LOG]: ${it}")
        }

        println("[LOG]: ${user.javaClass}")
    }

    private fun runFunc() {
        // 2022.12.12[프뚜]: this, lambda
        var user = UserEntity("프뚜", 20).run {
            println("[LOG]: $this")

            incrementAge()
            setName("먹뚜")

            println("[LOG]: $this")
        }

        println("[LOG]: ${user.javaClass}")
    }

    private fun withFunc() {
        // 2022.12.12[프뚜]: this, lambda
        val users: List<UserEntity> = listOf(
            UserEntity("프뚜", 20), UserEntity("먹뚜", 21)
        )

        val totalAge = with(users) {
            var age: Int = 0
            for (user in this) {
                age += user.getAge()
            }

            age
        }

        println("[LOG]: ${totalAge}")
    }

    private fun alsoFunc() {
        // 2022.12.12[프뚜]: it, context
        val user = UserEntity("프뚜", 20)
            .also {
                println("[LOG]: $it")
            }
            .also {
                it.incrementAge()
            }
            .also {
                it.setName("먹뚜")
            }
            .also {
                println("[LOG]: $it")
            }

        println("[LOG]: ${user.javaClass}")
    }

    private fun applyFunc() {
        // 2022.12.12[프뚜]: this, context
        val user = UserEntity("프뚜", 20)
            .apply {
                println("[LOG]: $this")

                incrementAge()
                setName("먹뚜")
            }
            .apply {
                println("[LOG]: $this")
            }

        println("[LOG]: ${user.javaClass}")
    }

}