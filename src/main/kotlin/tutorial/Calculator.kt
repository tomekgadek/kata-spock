package io.github.tomekgadek.tutorial

import java.math.BigDecimal

class Calculator(var current: BigDecimal = BigDecimal.ZERO) {

    fun add(value: BigDecimal): Calculator {
        current = current.add(value)

        return this
    }

    fun result(): BigDecimal {
        return current
    }
}