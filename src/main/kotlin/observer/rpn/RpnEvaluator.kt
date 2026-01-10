package io.github.tomekgadek.observer.rpn

class RpnEvaluator : ExpressionEvaluator {

    private val tokenizer = InfixTokenizer()
    private val converter = RpnConverter()
    private val core = RpnStackEvaluator()

    override fun evaluate(expression: String): Double {
        val infixTokens = tokenizer.tokenize(expression)
        val rpnTokens = converter.toRpn(infixTokens)
        return core.evaluate(rpnTokens)
    }
}
