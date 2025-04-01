package utils

import week1.ipv4_checker.Ipv4Tester

object TestCaseVariables {
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
        Ipv4Tester(name = "All octets have leading zeros", ipv4 = "002.010.009.128", result = false),
        Ipv4Tester(name = "First octet is just `0`", ipv4 = "0.1.2.3", result = false),
        Ipv4Tester(name = "Fourth octet exceeds 255", ipv4 = "192.168.1.256", result = false),
        Ipv4Tester(name = "First octet exceeds 255", ipv4 = "300.168.1.1", result = false),
        Ipv4Tester(name = "Third octet exceeds 255", ipv4 = "192.168.256.1", result = false),
        Ipv4Tester(name = "Negative number in an octet", ipv4 = "192.168.-1.1", result = false),
        Ipv4Tester(name = "Only 3 octets instead of 4", ipv4 = "192.168.1", result = false),
        Ipv4Tester(name = "More than 4 octets", ipv4 = "192.168.1.1.1", result = false),
        Ipv4Tester(name = "Empty octet between dots", ipv4 = "192.168..1", result = false),
        Ipv4Tester(name = "Third octet has a single leading zero", ipv4 = "192.168.01.1", result = false),
        Ipv4Tester(name = "Non-numeric input", ipv4 = "abc.def.ghi.jkl", result = false)
    )
}
