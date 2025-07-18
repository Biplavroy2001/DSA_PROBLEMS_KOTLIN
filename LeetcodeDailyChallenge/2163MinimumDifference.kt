import java.util.*

class Solution2163 {
    fun minimumDifference(nums: IntArray): Long {
        val n = nums.size
        val k = n / 3
        val leftMins = LongArray(n) // sum of k smallest from left
        val rightMaxs = LongArray(n) // sum of k largest from right
        var leftSum = 0L
        var rightSum = 0L
        var minDiff = Long.MAX_VALUE
        
        // Max-heap for left side (to maintain k smallest elements)
        val maxLeftHeap = PriorityQueue<Int> { a, b -> b - a }
        // Min-heap for right side (to maintain k largest elements)
        val minRightHeap = PriorityQueue<Int>()
        
        // Build leftMins - sum of k smallest elements from left
        for (i in 0 until k) {
            maxLeftHeap.offer(nums[i])
            leftSum += nums[i]
        }
        leftMins[k - 1] = leftSum
        
        for (i in k until n - k) {
            val x = nums[i]
            if (x < maxLeftHeap.peek()) {
                leftSum += x - maxLeftHeap.poll()
                maxLeftHeap.offer(x)
            }
            leftMins[i] = leftSum
        }
        
        // Build rightMaxs - sum of k largest elements from right
        for (i in n - 1 downTo n - k) {
            minRightHeap.offer(nums[i])
            rightSum += nums[i]
        }
        rightMaxs[n - k] = rightSum
        
        for (i in n - k - 1 downTo k - 1) {
            val x = nums[i]
            if (x > minRightHeap.peek()) {
                rightSum += x - minRightHeap.poll()
                minRightHeap.offer(x)
            }
            rightMaxs[i] = rightSum
        }
        
        // Find minimum difference
        for (i in k - 1 until n - k) {
            minDiff = minOf(minDiff, leftMins[i] - rightMaxs[i + 1])
        }
        
        return minDiff
    }
}

fun main() {
    val solution = Solution2163()
    
    
    val nums1 = intArrayOf(3, 1, 2)
    val result1 = solution.minimumDifference(nums1)
    println("Test 1:")
    println("Input: [${nums1.joinToString(", ")}]")
    println("Output: $result1")
    println("Expected: -1")
    println()
    
    
}