package tutorial

import io.github.tomekgadek.tutorial.Counter
import io.github.tomekgadek.tutorial.Operation
import io.github.tomekgadek.tutorial.OperationImpl
import spock.lang.Specification

/*
    Mock (atrapa):
        Sztuczny obiekt używany do sprawdzania, czy metoda została wywołana
        we właściwy sposób.
    Stub (zaślepka)
        Sztuczny obiekt, który na wywołania zawsze oddaje wcześniej
        ustaloną odpowiedź.
    Spy (szpieg)
        Prawdziwy obiekt, który normalnie działa, ale jego wywołania
        można podejrzeć i w razie potrzeby nadpisać wyniki.
 */

class CounterSpec extends Specification{


    def "shouldUseOperationOnceWithGivenText_mock"() {
        given:
        def mockOperation = Mock(Operation)
        def counter = new Counter(mockOperation)

        when:
        def result = counter.countCharacters("abc")

        then:
        1 * mockOperation.count("abc") >> 3
        result == 3
    }

    def "shouldReturnValueProvidedByStub_stub"() {
        given:
        def stubOperation = Stub(Operation)
        def counter = new Counter(stubOperation)

        stubOperation.count("abcd") >> 4

        when:
        def result = counter.countCharacters("abcd")

        then:
        result == 4
    }

    def "shouldCallRealImplementationAndVerifySpy_spy"() {
        given:
        def spyOperation = Spy(OperationImpl)
        def counter = new Counter(spyOperation)

        when:
        def result = counter.countCharacters("ab")

        then:
        1 * spyOperation.count("ab")
        result == 2
    }
}
