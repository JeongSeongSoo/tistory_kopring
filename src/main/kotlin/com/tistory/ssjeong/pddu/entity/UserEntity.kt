package com.tistory.ssjeong.pddu.entity

class UserEntity(
    private var name: String,
    private var age: Int
) {

    fun setName(param: String) {
        this.name = param
    }

    fun incrementAge() {
        this.age++
    }

    fun getAge() : Int {
        return this.age;
    }

    override fun toString(): String {
        return "이름은 ${name}이고, 나이는 ${age}입니다."
    }

}