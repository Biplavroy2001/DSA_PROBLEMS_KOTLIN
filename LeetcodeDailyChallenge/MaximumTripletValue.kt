class Solution {
    fun maximumTripletValue(nums: IntArray): Long {
        var maxVal = 0L
        val n = nums.size
        for (i in 0 until n - 2) {
            for (j in i + 1 until n - 1) {
                for (k in j + 1 until n) {
                    val current = (nums[i] - nums[j]).toLong() * nums[k].toLong()
                    if (current > maxVal) {
                        maxVal = current
                    }
                }
            }
        }
        return maxVal
    }
}

fun main() {
    val solution = Solution()
    
    // Test cases
    val testCases = listOf(
        intArrayOf(12, 6, 1, 2, 7) to 77L,
        intArrayOf(1, 10, 3, 4, 19) to 133L,
        intArrayOf(1, 2, 3) to 0L,
        intArrayOf(10, 5, 1, 2, 3) to 30L,
        intArrayOf(100, 50, 20, 30, 40) to 2400L,
        intArrayOf(1, 1, 1) to 0L,
        intArrayOf(1000000, 1, 1000000) to 999999000000L
    )

    for ((nums, expected) in testCases) {
        val result = solution.maximumTripletValue(nums)
        println("Input: ${nums.joinToString(", ", "[", "]")}")
        println("Output: $result")
        println("Expected: $expected")
        if (result == expected) {
            println(" Correct\n")
        } else {
            println(" Incorrect\n")
        }
    }
}