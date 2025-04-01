package week1.ipv4_checker

fun main() {

}

fun ipv4Checker(ipv4: String): Boolean {
    val octets = ipv4.split(".") // splitting the IPv4 to octets (the octet is the name of the 3 digits in the IP -> 100.1.0.2)
    if (octets.size != 4) { // checks if the number of the octets not equals 4 which means this is invalid IPv4
        return false
    }
    val startWithZeroRegex = Regex("^0\\d{1,2}$") // This is a regular expression which checks if the octets the IP has starts with a 0 or not
    val containsNonDigitRegex = Regex(".*[^0-9].*") // This regular expression checks if the octet contains a letter

    return octets.all { octet ->
        // Check if the octet contains any non-digit characters or starts with a leading zero
        !octet.matches(containsNonDigitRegex) &&
                !octet.matches(startWithZeroRegex) && // ensure no octet starts with leading zero
                octet.toIntOrNull()?.let { num ->
                    num in 0..255 // ensures the number is between 0 and 255
                } == true
    }
}