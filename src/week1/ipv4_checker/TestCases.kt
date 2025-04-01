package week1.ipv4_checker

import utils.TestCaseVariables
import utils.test


fun main () {
    ipv4TestCases()
}

fun ipv4TestCases() {
    TestCaseVariables.ipv4TestCases.forEach { testCase ->
        test(
            testCase.name,
            ipv4Checker( testCase.ipv4),
            testCase.result
        )
    }
}