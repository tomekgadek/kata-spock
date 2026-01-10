package io.github.tomekgadek.observer.rpn


internal class RpnConverter {

    fun toRpn(infixTokens: List<Token>): List<Token> {
        val output = mutableListOf<Token>()
        val operators = mutableListOf<Token>()

        for (token in infixTokens) {
            when {
                token.isNumber -> output.add(token)

                token.isOperator -> {
                    val op = token.asOperator()
                    while (
                        operators.isNotEmpty() &&
                        operators.last().isOperator &&
                        operators.last().asOperator().precedence >= op.precedence
                    ) {
                        output.add(operators.removeLast())
                    }
                    operators.add(token)
                }

                else -> throw IllegalArgumentException("Niepoprawny token: ${token.value}")
            }
        }

        while (operators.isNotEmpty()) {
            val opTok = operators.removeLast()
            output.add(opTok)
        }

        require(output.isNotEmpty()) {
            "Błąd konwersji do ONP: wynik pusty"
        }

        return output
    }
}
