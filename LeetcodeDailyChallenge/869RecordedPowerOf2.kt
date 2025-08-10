class Solution869{
    fun reorderedPowerOf2(n: Int): Boolean {
        val targetDigits = n.getDigitCounts()
        
        // We only need to check powers of 2 up to 10^9 (which is 2^30)
        var powerOf2 = 1 // 2^0
        repeat(31) { // 0..30
            if (powerOf2.getDigitCounts().contentEquals(targetDigits)) {
                return true
            }
            powerOf2 = powerOf2 shl 1 // Multiply by 2 using bit shift
        }
        return false
    }
    
    // Extension function to count digits in an Int
    private fun Int.getDigitCounts(): IntArray {
        val counts = IntArray(10)
        var num = this
        while (num > 0) {
            counts[num % 10]++
            num /= 10
        }
        return counts
    }
}

fun main() {
    val solution = Solution869()
    
    // Test cases
    val testCases = listOf(
        1 to true,
        10 to false,
        16 to true,
        24 to false,
        46 to true,
        128 to true,
        4021 to false,
        1042 to true,
        218 to true,
        1024 to true
    )
    
    for ((n, expected) in testCases) {
        val result = solution.reorderedPowerOf2(n)
        println("Input: $n, Output: $result, Expected: $expected -> ${if (result == expected) "correct" else "Wrong"}")
    }
}