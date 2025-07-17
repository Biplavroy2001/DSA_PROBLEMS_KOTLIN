class Solution3202 {
    fun maximumLength(nums: IntArray, k: Int): Int {
        var res = 2
        
        // Try all possible sum remainders (0 to k-1)
        for (j in 0 until k) {
            // dp[i] = length of longest subsequence ending with remainder i
            val dp = IntArray(k)
            
            for (num in nums) {
                val mod = num % k
                val pos = (j - mod + k) % k
                dp[mod] = dp[pos] + 1
            }
            
            // Find maximum length for current remainder j
            res = maxOf(res, dp.maxOrNull() ?: 0)
        }
        
        return res
    }
}

fun main() {
    val solution = Solution3202()
    
    // Test Case 1
    val nums1 = intArrayOf(1, 2, 3, 4, 5)
    val k1 = 2
    val result1 = solution.maximumLength(nums1, k1)
    println("Input: nums = [1, 2, 3, 4, 5], k = $k1")
    println("Output: $result1")
    println("Expected: 5")
    println()
    
    // Test Case 2
    val nums2 = intArrayOf(1, 4, 2, 3, 1, 4)
    val k2 = 3
    val result2 = solution.maximumLength(nums2, k2)
    println("Input: nums = [1, 4, 2, 3, 1, 4], k = $k2")
    println("Output: $result2")
    println("Expected: 4")
    println()
    
    // Additional Test Case 3
    val nums3 = intArrayOf(1, 2, 3, 4)
    val k3 = 4
    val result3 = solution.maximumLength(nums3, k3)
    println("Input: nums = [1, 2, 3, 4], k = $k3")
    println("Output: $result3")
    println("Expected: 2")
    println()
    
    // Additional Test Case 4
    val nums4 = intArrayOf(5, 10, 15, 20, 25)
    val k4 = 5
    val result4 = solution.maximumLength(nums4, k4)
    println("Input: nums = [5, 10, 15, 20, 25], k = $k4")
    println("Output: $result4")
    println("Expected: 5")
}