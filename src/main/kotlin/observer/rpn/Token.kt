package io.github.tomekgadek.observer.rpn

internal data class Token(val type: TokenType, val value: String) {
    val isNumber get() = type == TokenType.NUMBER
    val isOperator get() = type == TokenType.OPERATOR

    fun asDouble(): Double {
        require(isNumber) { "Token nie jest liczbą: $value" }
        return value.toDouble()
    }

    fun asOperator(): Operator {
        require(isOperator) { "Token nie jest operatorem: $value" }
        return Operator.fromChar(value[0])
            ?: throw IllegalArgumentException("Nieznany operator: $value")
    }
}