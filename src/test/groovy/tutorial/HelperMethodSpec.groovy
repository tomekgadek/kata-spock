package tutorial

import spock.lang.Specification
import spock.lang.Unroll

class HelperMethodSpec extends Specification {

    @Unroll
    def "is even without helper method"() {
        given:
        def digit = 12

        expect:
        digit % 2 == 0
    }

    @Unroll
    def "is even with helper method"() {
        given:
        def digit = 12

        expect:
        isEven(digit) == true
    }

    // helper method
    def isEven(digit) {
        digit % 2 == 0 // return
    }
}
