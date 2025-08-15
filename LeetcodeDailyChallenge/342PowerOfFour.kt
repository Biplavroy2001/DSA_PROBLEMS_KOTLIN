class Solution342{
    fun isPowerOfFour(n: Int): Boolean {
        return n > 0 && (n and (n - 1)) == 0 && (n and 0x55555555) != 0
    }
}

fun main() {
    val solution = Solution342()
    
    // Test cases
    val testCases = listOf(
        16 to true,
        5 to false,
        1 to true,
        0 to false,
        64 to true,
        63 to false,
        -16 to false,
        256 to true,
        1024 to true,
        1023 to false
    )

    for ((num, expected) in testCases) {
        val result = solution.isPowerOfFour(num)
        println("Input: $num, Output: $result, Expected: $expected")
        if (result == expected) {
            println(" Correct")
        } else {
            println(" Incorrect")
        }
        println()
    }
}