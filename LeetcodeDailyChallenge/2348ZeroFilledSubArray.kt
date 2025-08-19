class Solution2348{
    fun zeroFilledSubarray(nums: IntArray): Long {
        var result = 0L
        var consecutiveZeros = 0
        
        for (num in nums) {
            if (num == 0) {
                consecutiveZeros++
                result += consecutiveZeros
            } else {
                consecutiveZeros = 0
            }
        }
        
        return result
    }
}

fun main() {
    val solution = Solution2348()
    
    val nums1 = intArrayOf(1, 3, 0, 0, 2, 0, 0, 4)
    val result1 = solution.zeroFilledSubarray(nums1)
    println("Input: [1, 3, 0, 0, 2, 0, 0, 4]")
    println("Output: $result1")
    println("Expected: 6")
    println()
    
}