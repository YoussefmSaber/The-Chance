package week1.sudoku_checker

import utils.TestCaseVariables
import utils.test

fun main() {
    sudokuTestCases()
}

fun sudokuTestCases() {
    TestCaseVariables.SudokuTestCases.forEach { sudokuPuzzle ->
        test(
            name = sudokuPuzzle.name,
            result = sudokuChecker(sudokuPuzzle.puzzle),
            correctResult = sudokuPuzzle.isSolvable
        )
    }
}