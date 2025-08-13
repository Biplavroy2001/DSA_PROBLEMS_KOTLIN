class Solution326{
    fun isPowerOfThree(n: Int): Boolean {
        val maxPowerOf3 = 1162261467 // 3^19 is the largest power of 3 in Int range
        return n > 0 && maxPowerOf3 % n == 0
    }
}

fun main() {
    val solution = Solution326()
    
    // Test cases
    val testCases = listOf(
        1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049, 177147, 531441, 1594323, 4782969, 14348907, 43046721, 129140163, 387420489, 1162261467, // Powers of 3
        0, 2, 4, 10, 12, 28, 30, 100, -1, -3, -9, -27 // Non-powers of 3
    )
    
    testCases.forEach { num ->
        println("$num is power of three? ${solution.isPowerOfThree(num)}")
    }
}