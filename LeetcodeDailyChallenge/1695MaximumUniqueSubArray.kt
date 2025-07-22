

fun main() {
    val solution = Solution1695()
    
    val nums1 = intArrayOf(4, 2, 4, 5, 6)
    println(solution.maximumUniqueSubarray(nums1))  // Expected output: 17
    

}

class Solution1695{
    fun maximumUniqueSubarray(nums: IntArray): Int {
        val seen = BooleanArray(10001)
        var left = 0
        var currentSum = 0
        var maxSum = 0
        
        for (right in nums.indices) {
            while (seen[nums[right]]) {
                currentSum -= nums[left]
                seen[nums[left]] = false
                left++
            }
            currentSum += nums[right]
            seen[nums[right]] = true
            if (currentSum > maxSum) {
                maxSum = currentSum
            }
        }
        
        return maxSum
    }
}