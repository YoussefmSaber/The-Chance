/**
 * @author: Youssef Mohammed
 *
 * This is a simple sudoku checker which checks if the sudoku puzzle is valid or not
 */

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

    // region iterating over all the sudoku items
    sudokuRowLoop@ for (row in 0..<puzzleSize) {
        sudokuColumnLoop@ for (column in 0..<puzzleSize) {

            val cell = puzzle[row][column] // getting the current char

            if (cell == '-') continue@sudokuColumnLoop // if this filed is empty skip it

            val subgridIndex =
                (row / subgridSize) * subgridSize + (column / subgridSize) // getting the which sub-grid are we in right now

            // if the current character is found in any of the following then this is not a valid puzzle (row, column, sub-grid)
            if (cell in boxNumbers[subgridIndex] || cell in rowNumbers[row] || cell in columnNumbers[column]) return false

            // add the current character to the current (sub-grid, row, column)
            boxNumbers[subgridIndex].add(cell)
            rowNumbers[row].add(cell)
            columnNumbers[column].add(cell)
        }
    }
    // endregion
    return true
}