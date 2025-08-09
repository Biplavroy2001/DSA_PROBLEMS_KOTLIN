class Solution {
    fun isPowerOfTwo(n: Int): Boolean {
        return n > 0 && (n and (n - 1)) == 0
    }
}

fun main() {
    val solution = Solution()
    
    // Test cases
    val testCases = listOf(
        1 to true,          // 2^0 = 1
        16 to true,         // 2^4 = 16
        3 to false,         // Not a power of two
        0 to false,         // Edge case: 0
        -8 to false,        // Negative number
        1024 to true,      // 2^10 = 1024
        1023 to false,      // 1024-1
        1073741824 to true, // 2^30
        2147483647 to false // 2^31-1 (max positive Int)
    )

    // Run tests
    for ((input, expected) in testCases) {
        val result = solution.isPowerOfTwo(input)
        println("Input: $input\tOutput: $result\tExpected: $expected\t${if (result == expected) "✓" else "✗"}")
    }
}