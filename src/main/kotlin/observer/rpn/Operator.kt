package io.github.tomekgadek.observer.rpn

internal enum class Operator(val symbol: Char, val precedence: Int) {
    ADD('+', 1),
    SUB('-', 1),
    MUL('*', 2),
    DIV('/', 2);

    companion object {
        fun fromChar(ch: Char): Operator? =
            entries.firstOrNull { it.symbol == ch }
    }
}
