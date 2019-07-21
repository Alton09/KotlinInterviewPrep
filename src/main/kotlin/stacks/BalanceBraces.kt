package stacks

import java.util.*

class BalanceBraces {

    val matchingClosingBraces = mapOf (
        '(' to ')',
        '[' to ']',
        '{' to '}'
    )

    fun isBalanced(input: String): Boolean {
        val stack = Stack<Char>()
        val inputArray = input.toCharArray()

        for (char in inputArray) {
            if (isOpenBrace(char)) {
                stack.push(char)
            } else {
                if(matchingClosingBraces[stack.pop()] != char) return false
            }
        }

        return true
    }

    private fun isOpenBrace(char: Char): Boolean {
        return '(' == char ||
                '[' == char ||
                '{' == char
    }
}
