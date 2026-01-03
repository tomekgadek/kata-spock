package io.github.tomekgadek

import io.github.tomekgadek.lessons.toDragonSpeak
import io.github.tomekgadek.templates.CleanCode
import io.github.tomekgadek.templates.Tdd
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

    val message = "Slowo ostrzezenia: Nigdy nie pij Oddechu Smoka!"

    println(toDragonSpeak(message))
}