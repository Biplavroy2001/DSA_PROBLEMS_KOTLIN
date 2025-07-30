class Solution2419{
    fun longestSubarray(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        
        val maxVal = nums.maxOrNull() ?: 0
        var maxLen = 0
        var currentLen = 0
        
        for (num in nums) {
            currentLen = if (num == maxVal) currentLen + 1 else 0
            if (currentLen > maxLen) maxLen = currentLen
        }
        
        return maxLen
    }
}

fun main() {
    val solution = Solution2419()
    
    // Test Case 1
    val nums1 = intArrayOf(1, 2, 3, 3, 2, 2)
    println(solution.longestSubarray(nums1)) // Output: 2
    

}