package utils

import week1.ipv4_checker.Ipv4Tester
import week1.sudoku_checker.SudokuTester


// This Objects will contain all the test cases for each week task
object TestCaseVariables {
    // region week1
    // region IPv4
    val ipv4TestCases = listOf(
        // ✅ Valid IPs (Should Pass)
        Ipv4Tester(name = "Standard valid IP", ipv4 = "192.168.1.1", result = true),
        Ipv4Tester(name = "Valid private network IP", ipv4 = "10.0.0.1", result = true),
        Ipv4Tester(name = "Valid private network IP", ipv4 = "172.16.254.1", result = true),
        Ipv4Tester(name = "Upper boundary case", ipv4 = "255.255.255.255", result = true),
        Ipv4Tester(name = "Minimal valid IP", ipv4 = "1.2.3.4", result = true),

        // ❌ Invalid IPs (Should Fail)
        Ipv4Tester(name = "Leading zero in first octet", ipv4 = "001.2.3.4", result = false),
        Ipv4Tester(name = "Leading zero in second octet", ipv4 = "192.068.1.1", result = false),
        Ipv4Tester(name = "Leading zero in third octet", ipv4 = "192.168.007.1", result = false),
        Ipv4Tester(name = "Leading zero in fourth octet", ipv4 = "192.168.1.099", result = false),
        Ipv4Tester(name = "All octets have leading zeros", ipv4 = "002.010.009.028", result = false),
        Ipv4Tester(name = "First octet is just `0`", ipv4 = "0.1.2.3", result = false),
        Ipv4Tester(name = "Fourth octet exceeds 255", ipv4 = "192.168.1.256", result = false),
        Ipv4Tester(name = "First octet exceeds 255", ipv4 = "300.168.1.1", result = false),
        Ipv4Tester(name = "Third octet exceeds 255", ipv4 = "192.168.256.1", result = false),
        Ipv4Tester(name = "Negative number in an octet", ipv4 = "192.168.-1.1", result = false),
        Ipv4Tester(name = "Only 3 octets instead of 4", ipv4 = "192.168.1", result = false),
        Ipv4Tester(name = "More than 4 octets", ipv4 = "192.168.1.1.1", result = false),
        Ipv4Tester(name = "Empty octet between dots", ipv4 = "192.168..1", result = false),
        Ipv4Tester(name = "Third octet has a single leading zero", ipv4 = "192.168.01.1", result = false),
        Ipv4Tester(name = "Letter input", ipv4 = "abc.def.ghi.jkl", result = false),
        Ipv4Tester(name = "Symbol input", ipv4 = "%$$.###.!.&&&", result = false),
        Ipv4Tester(name = "Ultra-Mixed Input", ipv4 = "%$#.asd.1.001", result = false)
    )

    // endregion
    // region Sudoku
    val SudokuTestCases = listOf(
        // region 2x2 sub-grids sudoku
        SudokuTester(
            name = "Valid solvable 4*4 puzzle",
            puzzle = listOf(
                listOf('-', '-', '3', '-'),
                listOf('4', '-', '-', '1'),
                listOf('-', '2', '-', '-'),
                listOf('-', '-', '-', '-')
            ),
            isSolvable = true
        ),
        SudokuTester(
            name = "4*4 Unsolvable puzzle - row constraint violation",
            puzzle = listOf(
                listOf('1', '1', '-', '-'),
                listOf('-', '-', '2', '3'),
                listOf('3', '-', '-', '-'),
                listOf('-', '4', '-', '-')
            ),
            isSolvable = false
        ),
        SudokuTester(
            name = "4*4 Unsolvable puzzle - column constraint violation",
            puzzle = listOf(
                listOf('1', '-', '-', '-'),
                listOf('-', '3', '2', '-'),
                listOf('1', '-', '-', '4'),
                listOf('-', '-', '3', '-')
            ),
            isSolvable = false
        ),
        SudokuTester(
            name = "4*4 Unsolvable puzzle - subgrid constraint violation",
            puzzle = listOf(
                listOf('2', '-', '-', '-'),
                listOf('-', '2', '3', '-'),
                listOf('-', '4', '-', '-'),
                listOf('-', '-', '-', '-')
            ),
            isSolvable = false
        ),
        // endregion
        // region 3x3 sub-grids sudoku
        SudokuTester(
            name = "Valid 9*9 solvable puzzle",
            puzzle = listOf(
                listOf('5', '-', '-', '6', '-', '-', '-', '-', '2'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '-'),
                listOf('1', '-', '-', '3', '-', '-', '5', '-', '-'),
                listOf('-', '5', '-', '7', '-', '-', '-', '-', '-'),
                listOf('4', '-', '-', '-', '-', '-', '-', '-', '1'),
                listOf('-', '-', '3', '-', '2', '-', '8', '-', '-'),
                listOf('-', '6', '-', '-', '-', '-', '-', '-', '-'),
                listOf('-', '-', '7', '-', '1', '-', '6', '-', '-'),
                listOf('-', '4', '-', '-', '-', '-', '-', '7', '-')
            ),
            isSolvable = true
        ),
        SudokuTester(
            name = "9*9 Unsolvable puzzle - row constraint violation",
            puzzle = listOf(
                listOf('5', '-', '5', '-', '2', '-', '9', '-', '-'),
                listOf('-', '-', '-', '8', '-', '3', '-', '2', '-'),
                listOf('-', '7', '-', '-', '-', '-', '-', '-', '1'),
                listOf('2', '-', '-', '5', '-', '7', '-', '-', '3'),
                listOf('-', '4', '-', '-', '-', '-', '7', '-', '-'),
                listOf('-', '-', '9', '-', '-', '-', '-', '5', '-'),
                listOf('-', '-', '-', '3', '8', '-', '-', '-', '2'),
                listOf('8', '-', '3', '-', '-', '1', '-', '-', '-'),
                listOf('-', '1', '-', '-', '6', '-', '-', '7', '-')
            ),
            isSolvable = false
        ),
        SudokuTester(
            name = "9*9 Unsolvable puzzle - column constraint violation",
            puzzle = listOf(
                listOf('7', '-', '-', '5', '-', '-', '3', '-', '6'),
                listOf('-', '3', '-', '-', '9', '-', '-', '-', '-'),
                listOf('-', '4', '-', '-', '-', '1', '-', '-', '-'),
                listOf('-', '4', '3', '-', '-', '-', '1', '-', '-'),
                listOf('-', '-', '5', '9', '-', '4', '-', '-', '2'),
                listOf('9', '-', '-', '-', '-', '-', '5', '3', '-'),
                listOf('-', '-', '-', '2', '-', '-', '-', '5', '-'),
                listOf('-', '-', '-', '-', '5', '-', '-', '1', '8'),
                listOf('3', '-', '8', '-', '-', '6', '-', '-', '-')
            ),
            isSolvable = false
        ),
        SudokuTester(
            name = "9*9 Unsolvable puzzle - box constraint violation",
            puzzle = listOf(
                listOf('1', '8', '-', '-', '-', '2', '-', '-', '5'),
                listOf('-', '-', '3', '7', '-', '-', '-', '-', '-'),
                listOf('-', '-', '1', '-', '-', '9', '-', '4', '-'),
                listOf('-', '3', '-', '-', '8', '-', '-', '-', '-'),
                listOf('5', '-', '7', '-', '-', '-', '3', '-', '1'),
                listOf('-', '-', '-', '-', '6', '-', '-', '9', '-'),
                listOf('-', '5', '-', '2', '-', '-', '9', '-', '-'),
                listOf('-', '-', '-', '-', '-', '6', '1', '-', '-'),
                listOf('9', '-', '-', '5', '-', '-', '-', '2', '3')
            ),
            isSolvable = false
        ),
        // endregion
        // region 4x4 sub-grids sudoku
        SudokuTester(
            name = "Valid 16*16 Sudoku",
            puzzle = listOf(
                listOf('1', '-', '-', '-', '5', '-', '-', '8', '-', '-', '-', '-', '9', '-', '-', '4'),
                listOf('-', '-', '9', '-', '-', '-', '2', '-', '7', '-', '-', '-', '-', '6', '-', '-'),
                listOf('-', '3', '-', '-', '-', '1', '-', '-', '-', '6', '5', '-', '-', '-', '8', '-'),
                listOf('-', '-', '-', '6', '-', '-', '-', '4', '-', '2', '-', '-', '-', '-', '-', '-'),

                listOf('3', '-', '-', '-', '-', '-', '-', '-', '9', '-', '-', '1', '-', '-', '-', '6'),
                listOf('-', '-', '-', '5', '-', '9', '-', '-', '-', '-', '-', '-', '8', '-', '-', '-'),
                listOf('-', '-', '6', '-', '-', '-', '4', '-', '2', '-', '-', '-', '-', '-', '7', '-'),
                listOf('-', '-', '-', '-', '-', '-', '3', '-', '-', '1', '-', '-', '-', '2', '-', '-'),

                listOf('-', '9', '-', '-', '-', '8', '-', '-', '-', '-', '7', '-', '-', '-', '-', '-'),
                listOf('-', '-', '-', '2', '-', '-', '-', '5', '-', '-', '-', '-', '-', '9', '-', '-'),
                listOf('-', '5', '-', '-', '1', '-', '-', '-', '3', '-', '-', '-', '-', '-', '4', '-'),
                listOf('-', '-', '-', '-', '-', '-', '-', '7', '-', '8', '-', '-', '-', '-', '-', '3'),

                listOf('5', '-', '-', '9', '-', '-', '-', '-', '-', '-', '-', '2', '-', '-', '-', '-'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '6', '-', '-', '-', '-'),
                listOf('-', '-', '-', '-', '-', '-', '8', '-', '-', '-', '3', '-', '-', '-', '6', '-'),
                listOf('7', '-', '-', '-', '2', '-', '-', '-', '5', '-', '-', '-', '-', '8', '-', '9')
            ),
            isSolvable = true
        ),
        SudokuTester(
            name = "16*16 Unsolvable puzzle - Row Constraint Violation",
            puzzle = listOf(
                listOf('1', '-', '-', '-', '5', '-', '-', '8', '-', '-', '-', '-', '9', '-', '1', '4'),
                listOf('-', '-', '9', '-', '-', '-', '2', '-', '7', '-', '-', '-', '-', '6', '-', '-'),
                listOf('-', '3', '-', '-', '-', '1', '-', '-', '-', '6', '5', '-', '-', '-', '8', '-'),
                listOf('-', '-', '-', '6', '-', '-', '-', '4', '-', '2', '-', '-', '-', '-', '-', '-'),

                listOf('3', '-', '-', '-', '-', '-', '-', '-', '9', '-', '-', '1', '-', '-', '-', '6'),
                listOf('-', '-', '-', '5', '-', '9', '-', '-', '-', '-', '-', '-', '8', '-', '-', '-'),
                listOf('-', '-', '6', '-', '-', '-', '4', '-', '2', '-', '-', '-', '-', '-', '7', '-'),
                listOf('-', '-', '-', '-', '-', '-', '3', '-', '-', '1', '-', '-', '-', '2', '-', '-'),

                listOf('-', '9', '-', '-', '-', '8', '-', '-', '-', '-', '7', '-', '-', '-', '-', '-'),
                listOf('-', '-', '-', '2', '-', '-', '-', '5', '-', '-', '-', '-', '-', '9', '-', '-'),
                listOf('-', '5', '-', '-', '1', '-', '-', '-', '3', '-', '-', '-', '-', '-', '4', '-'),
                listOf('-', '-', '-', '-', '-', '-', '-', '7', '-', '8', '-', '-', '-', '-', '-', '3'),

                listOf('5', '-', '-', '9', '-', '-', '-', '-', '-', '-', '-', '2', '-', '-', '-', '-'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '6', '-', '-', '-', '-'),
                listOf('-', '-', '-', '-', '-', '-', '8', '-', '-', '-', '3', '-', '-', '-', '6', '-'),
                listOf('7', '-', '-', '-', '2', '-', '-', '-', '5', '-', '-', '-', '-', '8', '-', '9')
            ),
            isSolvable = false
        ),
        SudokuTester(
            name = "16*16 Unsolvable puzzle - Column Constraint Violation",
            puzzle = listOf(
                listOf('1', '-', '-', '-', '5', '-', '-', '8', '-', '-', '-', '-', '9', '-', '-', '4'),
                listOf('-', '-', '9', '-', '-', '-', '2', '-', '7', '-', '-', '-', '-', '6', '-', '-'),
                listOf('-', '3', '-', '-', '-', '1', '-', '-', '-', '6', '5', '-', '-', '-', '8', '-'),
                listOf('-', '-', '-', '6', '-', '-', '-', '4', '-', '2', '-', '-', '-', '-', '-', '-'),

                listOf('3', '-', '-', '-', '-', '-', '-', '-', '9', '-', '-', '1', '-', '-', '-', '6'),
                listOf('-', '-', '-', '5', '-', '9', '-', '-', '-', '-', '-', '-', '8', '-', '-', '-'),
                listOf('-', '-', '6', '-', '-', '-', '4', '-', '2', '-', '-', '-', '-', '-', '7', '-'),
                listOf('-', '-', '-', '-', '-', '-', '3', '-', '-', '1', '-', '-', '-', '2', '-', '-'),

                listOf('-', '9', '-', '-', '-', '8', '-', '-', '-', '-', '7', '-', '-', '-', '-', '-'),
                listOf('-', '-', '-', '2', '-', '-', '-', '5', '-', '-', '-', '-', '-', '9', '-', '-'),
                listOf('-', '5', '-', '-', '1', '-', '-', '-', '3', '-', '-', '-', '-', '-', '4', '-'),
                listOf('1', '-', '-', '-', '-', '-', '-', '7', '-', '8', '-', '-', '-', '-', '-', '3'),

                listOf('5', '-', '-', '9', '-', '-', '-', '-', '-', '-', '-', '2', '-', '-', '-', '-'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '6', '-', '-', '-', '-'),
                listOf('-', '-', '-', '-', '-', '-', '8', '-', '-', '-', '3', '-', '-', '-', '6', '-'),
                listOf('7', '-', '-', '-', '2', '-', '-', '-', '5', '-', '-', '-', '-', '8', '-', '9')
            ),
            isSolvable = false
        ), SudokuTester(
            name = "16*16 Unsolvable puzzle - Subgrid Constraint Violation",
            puzzle = listOf(
                listOf('1', '-', '-', '-', '5', '-', '-', '8', '-', '-', '-', '-', '9', '-', '-', '4'),
                listOf('-', '-', '9', '-', '-', '-', '2', '-', '7', '-', '-', '-', '-', '6', '-', '-'),
                listOf('-', '3', '-', '-', '-', '1', '-', '-', '-', '6', '5', '-', '-', '-', '8', '-'),
                listOf('-', '-', '-', '6', '-', '-', '-', '4', '-', '2', '-', '-', '-', '-', '-', '-'),

                listOf('3', '-', '-', '-', '-', '-', '-', '-', '9', '-', '-', '1', '-', '-', '-', '6'),
                listOf('-', '-', '-', '5', '-', '9', '-', '-', '-', '-', '-', '-', '8', '-', '-', '-'),
                listOf('-', '-', '6', '-', '-', '-', '4', '-', '2', '-', '-', '-', '-', '-', '7', '-'),
                listOf('-', '-', '-', '-', '-', '-', '3', '-', '-', '1', '-', '-', '-', '2', '-', '-'),

                listOf('-', '9', '-', '-', '-', '8', '-', '-', '-', '-', '7', '-', '-', '-', '-', '-'),
                listOf('-', '-', '-', '2', '-', '-', '-', '5', '-', '-', '-', '-', '-', '9', '-', '-'),
                listOf('-', '5', '-', '-', '1', '-', '-', '-', '3', '-', '-', '-', '-', '-', '4', '-'),
                listOf('-', '-', '-', '-', '-', '-', '-', '7', '-', '8', '-', '-', '-', '-', '-', '3'),

                listOf('5', '-', '-', '9', '-', '-', '-', '-', '-', '-', '-', '2', '-', '-', '-', '-'),
                listOf('-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '6', '-', '-', '-', '-'),
                listOf('-', '-', '-', '-', '-', '-', '8', '-', '-', '-', '3', '-', '-', '-', '6', '-'),
                listOf('7', '-', '-', '-', '2', '-', '9', '-', '5', '-', '-', '-', '-', '8', '-', '9')
            ),
            isSolvable = false
        )
// endregion
    )
    // endregion
// endregion
}
