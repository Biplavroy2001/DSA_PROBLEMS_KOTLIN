class Solution1863

{
    fun subsetXORSum(nums: IntArray): Int {
        // Most optimized recursive approach
        return backtrack(nums, 0, 0)
    }
    
    private fun backtrack(nums: IntArray, index: Int, currentXor: Int): Int {
        // Base case: processed all elements
        if (index == nums.size) {
            return currentXor
        }
        
        // Two choices: include current element or exclude it
        val includeXor = backtrack(nums, index + 1, currentXor xor nums[index])
        val excludeXor = backtrack(nums, index + 1, currentXor)
        
        return includeXor + excludeXor
    }
}


fun main() {
    val solution = Solution1863()
    
    // Test Case 1
    val nums1 = intArrayOf(1, 3)
    val result1 = solution.subsetXORSum(nums1)
    println("Input: [1, 3]")
    println("Output: $result1")
    println("Expected: 6")
    println("Explanation:")
    println("  [] -> XOR = 0")
    println("  [1] -> XOR = 1") 
    println("  [3] -> XOR = 3")
    println("  [1,3] -> XOR = 1⊕3 = 2")
    println("  Sum = 0 + 1 + 3 + 2 = 6")
    println()
    
}