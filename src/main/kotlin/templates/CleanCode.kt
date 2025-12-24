package io.github.tomekgadek.templates

import kotlin.random.Random

class CleanCode {

    fun isCodeReadable(): Boolean {
        return Random.nextInt(100) > 50
    }

    fun refactor() {
        println("refactoring...")
    }

    fun beHappy() {
        println("be happy...")
    }
}