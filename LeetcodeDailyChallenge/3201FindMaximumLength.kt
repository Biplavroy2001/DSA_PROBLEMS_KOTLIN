fun main() {
    val solution = Solution3201()
    
    // Test Case 1
    val nums1 = intArrayOf(1, 2, 3, 4)
    val result1 = solution.maximumLength(nums1)
    println("Input: [1, 2, 3, 4]")
    println("Output: $result1")
    println("Expected: 4")
    println()
    
    // Test Case 2
    val nums2 = intArrayOf(1, 2, 1, 1, 2, 1, 2)
    val result2 = solution.maximumLength(nums2)
    println("Input: [1, 2, 1, 1, 2, 1, 2]")
    println("Output: $result2")
    println("Expected: 6")
    println()
    
    // Test Case 3
    val nums3 = intArrayOf(1, 3)
    val result3 = solution.maximumLength(nums3)
    println("Input: [1, 3]")
    println("Output: $result3")
    println("Expected: 2")
    println()
    
    // Additional Test Case 4
    val nums4 = intArrayOf(2, 4, 6, 8)
    val result4 = solution.maximumLength(nums4)
    println("Input: [2, 4, 6, 8] (all even)")
    println("Output: $result4")
    println("Expected: 4")
    println()
    
    // Additional Test Case 5
    val nums5 = intArrayOf(1, 3, 5, 7)
    val result5 = solution.maximumLength(nums5)
    println("Input: [1, 3, 5, 7] (all odd)")
    println("Output: $result5")
    println("Expected: 4")
}

class Solution3201 {
    fun maximumLength(nums: IntArray): Int {
        // Count even and odd numbers
        var countEven = 0
        var countOdd = 0
        
        // Single pass to count even/odd numbers
        for (num in nums) {
            if (num % 2 == 0) countEven++ else countOdd++
        }
        
        // Dynamic programming approach for alternating subsequence
        var evenDp = 0
        var oddDp = 0
        
        for (num in nums) {
            if (num % 2 == 0) {
                evenDp = maxOf(evenDp, oddDp + 1)
            } else {
                oddDp = maxOf(oddDp, evenDp + 1)
            }
        }
        
        // Return maximum of all possible valid subsequences
        return maxOf(countEven, countOdd, evenDp, oddDp)
    }
}
