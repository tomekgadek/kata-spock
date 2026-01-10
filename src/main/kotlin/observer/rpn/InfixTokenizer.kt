package io.github.tomekgadek.observer.rpn


internal class InfixTokenizer {

    fun tokenize(rawExpression: String): List<Token> {
        val expr = rawExpression.replace(" ", "")
        require(expr.isNotEmpty()) { "Wyrażenie nie może być puste" }

        val result = mutableListOf<Token>()
        val number = StringBuilder()

        fun flushNumber() {
            if (number.isNotEmpty()) {
                val text = number.toString()
                text.toDoubleOrNull()
                    ?: throw IllegalArgumentException("Niepoprawna liczba: '$text'")
                result.add(Token(TokenType.NUMBER, text))
                number.setLength(0)
            }
        }

        var i = 0
        while (i < expr.length) {
            val ch = expr[i]

            when {
                // cyfra lub kropka: kontynuujemy liczbę
                ch.isDigit() || ch == '.' -> {
                    number.append(ch)
                    i++
                }

                ch == '-' -> {
                    val isUnary = (i == 0) || isOperatorChar(expr[i - 1])

                    if (isUnary) {
                        // zaczynamy liczbe ujemną
                        number.append(ch)
                        i++
                    } else {
                        flushNumber()
                        result.add(Token(TokenType.OPERATOR, "-"))
                        i++
                    }
                }

                isOperatorChar(ch) -> {
                    flushNumber()
                    result.add(Token(TokenType.OPERATOR, ch.toString()))
                    i++
                }

                else -> throw IllegalArgumentException("Nieobsługiwany znak: '$ch'")
            }
        }

        flushNumber()

        require(result.isNotEmpty()) {
            "Brak poprawnych tokenów w wyrażeniu"
        }
        require(result.first().isNumber && result.last().isNumber) {
            "Wyrażenie musi zaczynać i kończyć się liczbą"
        }

        return result
    }

    private fun isOperatorChar(ch: Char): Boolean =
        ch == '+' || ch == '-' || ch == '*' || ch == '/'
}

