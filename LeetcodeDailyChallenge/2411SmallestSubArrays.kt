fun main() {
    val solution = Solution2411()

    // Test Case 1 (Example 1)
    val nums1 = intArrayOf(1, 0, 2, 1, 3)
    val result1 = solution.smallestSubarrays(nums1)
    println("Test Case 1: ${result1.joinToString(", ")}")  // Expected: [3, 3, 2, 2, 1]

   
}


class Solution2411{
    fun smallestSubarrays(nums: IntArray): IntArray {
        val n = nums.size
        val lastSeen = IntArray(30) { -1 }
        val res = IntArray(n) { 1 }
        
        for (i in n - 1 downTo 0) {
            for (bit in 0 until 30) {
                if ((nums[i] and (1 shl bit)) != 0) {
                    lastSeen[bit] = i
                }
                if (lastSeen[bit] != -1) {
                    res[i] = maxOf(res[i], lastSeen[bit] - i + 1)
                }
            }
        }
        return res
    }
}