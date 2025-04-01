package week1.sudoku_checker

import kotlin.math.sqrt

fun main() {
    print(
        sudokuChecker(
            listOf(
                listOf('-', '-', '3', '-'),
                listOf('4', '-', '-', '1'),
                listOf('-', '2', '-', '-'),
                listOf('-', '-', '-', '-')
            )
        )
    )
}

/**
 * This function is made to check if the entered sudoku puzzle
 * is a valid sudoku puzzle or not
 *
 * @param puzzle A multi-dimension list which contains the sudoku puzzle
 * @return Boolean which indicates if the puzzle is solvable or not
 */
fun sudokuChecker(puzzle: List<List<Char>>): Boolean {
    // getting the puzzle size to create the size of the arrays
    val puzzleSize = puzzle.size

    /**
     * The array is created in the size of the puzzle to handle any sudoku puzzle size
     */
    val boxNumbers = Array(puzzleSize) { mutableSetOf<Char>() }
    val rowNumbers = Array(puzzleSize) { mutableSetOf<Char>() }
    val columnNumbers = Array(puzzleSize) { mutableSetOf<Char>() }

    val subgridSize = sqrt(puzzleSize.toDouble()).toInt() // Ensure integer division
    for (row in 0..<puzzleSize) {
        for (column in 0..<puzzleSize) {

            val char = puzzle[row][column] // getting the current char

            if (char == '-') continue // if this filed is empty skip it

            val subgridIndex =
                (row / subgridSize) * subgridSize + (column / subgridSize) // getting the which sub-grid are we in right now

            // if the current character is found in any of the following then this is not a valid puzzle (row, column, sub-grid)
            if (char in boxNumbers[subgridIndex] || char in rowNumbers[row] || char in columnNumbers[column]) return false

            // add the current character to the current (sub-grid, row, column)
            boxNumbers[subgridIndex].add(char)
            rowNumbers[row].add(char)
            columnNumbers[column].add(char)
        }
    }

    return true
}