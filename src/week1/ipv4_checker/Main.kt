package week1.ipv4_checker

fun main() {

}

fun ipv4Checker(ipv4: String): Boolean {
    val octets = ipv4.split(".") // splitting the IPv4 to octets (the octet is the name of the 3 digits in the IP -> 100.1.0.2)
    if (octets.size != 4) { // checks if the number of the octets not equals 4 which means this is invalid IPv4
        return false
    }
    val startWithZeroRegex = Regex("^0\\d{1,2}$") // This is a regular expression which checks if the octets the IP has starts with a 0 or not
    return octets.none { // Here we returns true if the octets of the IP does not match the regex which means that this is a valid IP
        it.matches(startWithZeroRegex) // Returns false if the octet starts with a Zero or double Zero
    }
}