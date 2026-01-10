package io.github.tomekgadek.observer.rpn

internal class RpnStackEvaluator {

    fun evaluate(rpnTokens: List<Token>): Double {
        val stack = mutableListOf<Double>()

        for (token in rpnTokens) {
            when {
                token.isNumber -> stack.add(token.asDouble())

                token.isOperator -> {
                    val op = token.asOperator()
                    require(stack.size >= 2) {
                        "Za mało operandów dla operatora '${op.symbol}'"
                    }

                    val right = stack.removeLast()
                    val left = stack.removeLast()

                    val result = when (op) {
                        Operator.ADD -> left + right
                        Operator.SUB -> left - right
                        Operator.MUL -> left * right
                        Operator.DIV -> {
                            if (right == 0.0) {
                                throw ArithmeticException("Dzielenie przez zero")
                            }
                            left / right
                        }
                    }

                    stack.add(result)
                }
            }
        }

        require(stack.size == 1) {
            "Błędne wyrażenie: na stosie pozostało ${stack.size} elementów"
        }

        return stack.single()
    }
}
