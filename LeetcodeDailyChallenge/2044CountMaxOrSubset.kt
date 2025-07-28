class Solution2044{
    fun countMaxOrSubsets(nums: IntArray): Int {
        val maxOR = nums.fold(0) { acc, num -> acc or num }
        return backtrack(nums, maxOR, 0, 0)
    }

    private fun backtrack(nums: IntArray, maxOR: Int, index: Int, currentOR: Int): Int {
        if (index == nums.size) {
            return if (currentOR == maxOR) 1 else 0
        }
        
        if (currentOR == maxOR) {
            return 1 shl (nums.size - index)
        }
        
        return backtrack(nums, maxOR, index + 1, currentOR or nums[index]) +
               backtrack(nums, maxOR, index + 1, currentOR)
    }
}


fun main() {
    val solution = Solution2044()

    // Test Case 1: nums = [3, 1] → Expected Output: 2
    val nums1 = intArrayOf(3, 1)
    println(solution.countMaxOrSubsets(nums1))  // Output: 2

    
}

