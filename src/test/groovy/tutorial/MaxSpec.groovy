package tutorial

import spock.lang.Specification
import spock.lang.Unroll

class MaxSpec extends Specification {

    @Unroll
    def "computing the maximum of two numbers - max(#a, #b) = #c (pipe)"() { // data pipes
        expect: "verifies that Math.max(a, b) returns the greater value"
        Math.max(a, b) == c

        where: "provides input values for the test parameters using data pipes"
        a << [5, 3]
        b << [1, 9]
        c << [5, 9]
    }

    @Unroll
    def "computing the maximum of two numbers - max(#a, #b) = #c (table)"() { // data table
        expect: "verifies that Math.max(a, b) returns the greater value"
        Math.max(a, b) == c

        where: "provides input values for the test parameters using data table"
        a | b | c
        5 | 1 | 5
        3 | 9 | 9
    }

}
