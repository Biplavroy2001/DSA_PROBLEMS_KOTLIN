fun main() {
    val solution = Solution3487()
    
    println(solution.maxSum(intArrayOf(1, 2, 3, 4, 5))) // Output: 15
    println(solution.maxSum(intArrayOf(1, 1, 0, 1, 1))) // Output: 1
    println(solution.maxSum(intArrayOf(1, 2, -1, -2, 1, 0, -1))) // Output: 3
    println(solution.maxSum(intArrayOf(-1, -2, -3))) // Output: -1
}


class Solution3487{
    fun maxSum(nums: IntArray): Int {
        // Check if all elements are negative
        val allNegative = nums.all { it < 0 }
        val maxValue = nums.maxOrNull() ?: 0
        if (allNegative) return maxValue

        // Use a set to remove duplicates and sum all positive numbers
        return nums.toSet().filter { it > 0 }.sum()
    }
}