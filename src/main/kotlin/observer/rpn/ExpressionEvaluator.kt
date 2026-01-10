package io.github.tomekgadek.observer.rpn

interface ExpressionEvaluator {
    fun evaluate(expression: String): Double
}
