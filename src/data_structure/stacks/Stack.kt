package data_structure.stacks

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList

class Stack<Item> {

    private val arr: ArrayList<Item> = ArrayList()

    fun push(item: Item) {
        arr.add(item)
    }

    fun pop(): Item {
        if (isEmpty()) {
            throw EmptyStackException()
        } else {
            return arr.removeLast()
        }
    }

    fun isEmpty(): Boolean {
        return arr.size == 0
    }

    fun peek(): Item {
        if (isEmpty()) {
            throw EmptyStackException()
        } else {
            return arr[arr.lastIndex]
        }
    }

    override fun toString(): String {
        val stringBuilder = StringBuilder()
        arr.forEach {
            stringBuilder.append(it).append(", ")
        }
        return stringBuilder.toString()
    }
}

fun main() {
    val stack = Stack<Int>()
    stack.push(5)
    stack.push(3)
    stack.push(1)

    println("peak: " + stack.peek())
    println("pop: " + stack.pop())
    println("stack: $stack")
}