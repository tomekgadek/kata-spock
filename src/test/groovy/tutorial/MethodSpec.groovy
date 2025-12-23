package tutorial

import spock.lang.Specification

/*
    Output:

    > setupSpec()
    * setup()
    ..firstTest()
    * cleanup()
    * setup()
    ..secondTest()
    * cleanup()
    > cleanupSpec
*/

class MethodSpec extends Specification{

    // przed każdym testem (mocki, obiekty testowe)
    def setup() {
        println("* setup()")
    }

    // 1x, przed 1 testem (inicjalizacja współdzielona, np: DB)
    def setupSpec() {
        println("> setupSpec()")
    }

    // po każdym teście (zamknij mocki, pliki)
    def cleanup() {
        println("* cleanup()")
    }

    // 1x, po ostatnim teście (zamknij DB)
    def cleanupSpec() {
        println("> cleanupSpec")
    }

    // pierwszy test
    def firstTest() {
        println("..firstTest()")
        expect:
            assert 2 == 2
    }

    // drugi test
    def secondTest() {
        println("..secondTest()")
        expect:
            2 + 1 == 3
    }
}
