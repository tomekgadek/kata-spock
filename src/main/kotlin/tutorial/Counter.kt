package io.github.tomekgadek.tutorial

interface Operation {
    fun count(text: String?): Int
}

open class OperationImpl : Operation {

    override fun count(text: String?): Int {
        return (text ?: "").count()
    }
}

open class Counter(private val operation: Operation) {
    fun countCharacters(text: String?): Int {
        return operation.count(text)
    }
}
