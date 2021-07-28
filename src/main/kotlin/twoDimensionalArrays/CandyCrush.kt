package twoDimensionalArrays

import java.lang.StringBuilder
import kotlin.random.Random

/*
    Write a function that takes inputs h (height),  w (width), and an array of colors. It outputs a grid of colors that meets the following criteria:

    1. Use the inputs: height and width of the grid. Only use colors from colors array.
    2. Non-deterministic: every time the method is executed with the same input, a different output must be produced.
    3. No 3 consecutive colors: no row or column may contain 3 consecutive colors.
    4. At least 1 starting move: swap two neighboring grid spaces to create 3 consecutive colors (row or column)

    Example: - This is a valid starting grid

    R  |  G  |  R  |  Y
    R  |  R  |  Y  |  Y
    B  |  B  |  Y  |  P

    There are two starting moves:
    Swapping R and G will cause 3 Rs to be in consequtive order.
    Swapping P and Y will also cause 3 Ys to be in order.
 */
fun printBoard(h: Int, w: Int, colors: Array<Char>) {
    val board = Array(w) { Array(h) { 'R' } }

    // Build board
    var rowIndex = 0
    var columnIndex = 0
    while(rowIndex < h) {
        while (columnIndex < w) {
            board[columnIndex][rowIndex] = getRandomChar(colors)
            columnIndex ++
        }
        columnIndex = 0
        rowIndex ++
    }

    // TODO Finish remaining requirements

    // Print Board
    rowIndex = 0
    columnIndex = 0
    val boardStringBuilder = StringBuilder()
    var separator = ""
    while(rowIndex < h) {
        while (columnIndex < w) {
            separator = if(columnIndex == w - 1) "" else "| "
            boardStringBuilder.append("${board[columnIndex][rowIndex]} $separator")
            columnIndex ++
        }
        boardStringBuilder.append("\n")
        columnIndex = 0
        rowIndex ++
    }

    println(boardStringBuilder.toString())
}

fun getRandomChar(colors: Array<Char>) = colors[Random.nextInt(colors.size - 1)]