package tutorial

import io.github.tomekgadek.tutorial.Calculator
import spock.lang.Specification
import spock.lang.Unroll

class CalculatorSpec extends Specification {

    def "should initialize with zero value"() {
        given: "new calculator instance"
        def calculator = new Calculator()

        expect: "initial result is zero"
        calculator.result() == BigDecimal.ZERO
    }

    def "should initialize with positive value"() {
        given: "new calculator instance"
        def calculator = new Calculator()

        when: "add positive value"
        def result = calculator.add(BigDecimal.TWO).result()

        then: "result equals added value"
        result == BigDecimal.TWO
    }

    @Unroll
    def "should calculate #positiveValue + #negativeValue = #expectedResult"() {
        given: "new calculator instance"
        def calculator = new Calculator()

        when: "add positive and negative values"
        def result = calculator.add(positiveValue).add(negativeValue).result()

        then: "result equals expected sum"
        result == expectedResult

        where:
        positiveValue   | negativeValue           | expectedResult
        BigDecimal.TWO  | BigDecimal.ZERO         | BigDecimal.TWO
        BigDecimal.TEN  | BigDecimal.ONE.negate() | BigDecimal.valueOf(9)
        BigDecimal.ZERO | BigDecimal.TEN.negate() | BigDecimal.TEN.negate()
    }

}
