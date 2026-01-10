package io.github.tomekgadek

import com.formdev.flatlaf.FlatLightLaf
import io.github.tomekgadek.lessons.*
import io.github.tomekgadek.observer.Controller
import io.github.tomekgadek.observer.Model
import io.github.tomekgadek.observer.View
import io.github.tomekgadek.observer.rpn.RpnEvaluator
import io.github.tomekgadek.templates.CleanCode
import io.github.tomekgadek.templates.Tdd
import javax.swing.SwingUtilities
import javax.swing.UIManager
import kotlin.random.Random

fun main() {

    println("1) Clean Code Template ;)")

    val cleanCode = CleanCode()

    if(cleanCode.isCodeReadable()) {
        cleanCode.beHappy();
    } else {
        cleanCode.refactor();
    }

    println("2) Tdd Template ;)")

    // given
    val tdd = Tdd();

    // when
    val method = tdd.rgr();

    // then
    method.contains("red");
    method.contains("green");
    method.contains("refactor");

    println("3) Sentence Template ;)")

    while(Random.nextInt(100) != 0) {
        println("practice \nmakes \nperfect");
        println("* * *")
    }

    println("My all Kotlin lessons...")
    runLessons()
}

fun runLessons() {

    // 1)
    val message = "Slowo ostrzezenia: Nigdy nie pij Oddechu Smoka!"
    println(toDragonSpeak(message))

    println("---")

    // 2)
    countCharacters()
    sumDigits()

    println("---")

    // 3)
    rangeExamples()
    println("Triangle area = ${triangleArea(2.0, 4.0)}")

    helloMyFriend()

    println("Add operation 1, addOperationExpression(1, 2) = ${addOperationExpression(1, 2)}")
    println("Add operation 2, addOperationTraditional(1, 2) = ${addOperationTraditional(1, 2)}")

    point(1)
    point(1, 2)
    point(1, 2, 3)

    println("Max_1 = ${maxFromArrayIteration(arrayOf(1, 2, 3, 4, 5, -1, -2, -3))}")
    println("Max_2 = ${maxFromArrayUsageLibrary(arrayOf(1, 2, 3, 4, 5, -1, -2, -3))}")
    println("Max_3 = ${maxFromArrayUsageLambda(arrayOf(1, 2, 3, 4, 5, -1, -2, -3))}")

    println("---")

    // 4)

    println("1 to ${if(isPrime(1)) "jest" else "nie jest"} liczba pierwsza")
    println("2 to ${if(isPrime(2)) "jest" else "nie jest"} liczba pierwsza")
    println("3 to ${if(isPrime(3)) "jest" else "nie jest"} liczba pierwsza")
    println("10 to ${if(isPrime(10)) "jest" else "nie jest"} liczba pierwsza")
    println("19 to ${if(isPrime(19)) "jest" else "nie jest"} liczba pierwsza")
    println("97 to ${if(isPrime(97)) "jest" else "nie jest"} liczba pierwsza")
    println("99 to ${if(isPrime(99)) "jest" else "nie jest"} liczba pierwsza")

    println("---")

    // 5)
    listTests()
    println("---")

    mapTests()
    println("---")

    // 6)
    carTests()
    println("---")

    // Observer, Swing + AWT

    // Config Look&Feel
    UIManager.setLookAndFeel(FlatLightLaf())
    UIManager.put("Button.arc", 16)
    UIManager.put("TextComponent.arc", 12)
    UIManager.put("Component.focusWidth", 1)

    /**
        TODO: Brak pelnej implementacji ONP:
            + zaimplementowac obsluge nawiasow '(' i ')'
            + zaimplementowac obsluge operacji potegowania i pierwiastkowania
            + zaimplementowac obsluge bledow od strony uzytkownika
     */
    SwingUtilities.invokeLater(Runnable {
        val model = Model(RpnEvaluator())
        val view = View()
        Controller(model, view)
    })
}
