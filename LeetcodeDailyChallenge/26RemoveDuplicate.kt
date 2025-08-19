class Solution26 {
    fun removeDuplicates(nums: IntArray): Int {
        // Edge case: empty array (though constraints guarantee at least 1 element)
        if (nums.isEmpty()) return 0
        
        // Two-pointer approach
        // left pointer: position to place next unique element
        // right pointer: scans through array
        var left = 1 // Start from index 1 since first element is always unique
        
        for (right in 1 until nums.size) {
            // If current element is different from previous element
            if (nums[right] != nums[right - 1]) {
                nums[left] = nums[right]
                left++
            }
        }
        
        return left // left now represents the count of unique elements
    }
}

fun main() {
    val solution = Solution26()
    
    // Test Case 1
    val nums1 = intArrayOf(1, 1, 2)
    val result1 = solution.removeDuplicates(nums1)
    println("Input: [1, 1, 2]")
    println("Output: k = $result1, nums = ${nums1.take(result1)}")
    println("Expected: k = 2, nums = [1, 2]")
    println()
    
}