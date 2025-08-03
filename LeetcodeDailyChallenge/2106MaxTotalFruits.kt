class Solution2106{
    fun maxTotalFruits(fruits: Array<IntArray>, startPos: Int, k: Int): Int {
        if (fruits.isEmpty()) return 0
        
        val n = fruits.size
        val positions = IntArray(n)
        val prefixSum = LongArray(n + 1)
        
        // Precompute positions and prefix sums
        for (i in fruits.indices) {
            positions[i] = fruits[i][0]
            prefixSum[i + 1] = prefixSum[i] + fruits[i][1]
        }
        
        var maxFruits = 0L
        var left = 0
        
        for (right in fruits.indices) {
            var posL = positions[left].toLong()
            val posR = positions[right].toLong()
            
            // Calculate minimum steps to cover current window [posL, posR]
            var cost = (posR - posL) + minOf(kotlin.math.abs(startPos - posL), kotlin.math.abs(startPos - posR))
            
            // Shrink window from left if cost exceeds k
            while (left <= right && cost > k) {
                left++
                if (left > right) break
                posL = positions[left].toLong()
                cost = (posR - posL) + minOf(kotlin.math.abs(startPos - posL), kotlin.math.abs(startPos - posR))
            }
            
            // Update max fruits if window is valid
            if (left <= right) {
                val currentFruits = prefixSum[right + 1] - prefixSum[left]
                maxFruits = maxOf(maxFruits, currentFruits)
            }
        }
        
        return maxFruits.toInt()
    }
}

fun main() {
    val solution = Solution2106()
    
    // Test Case 1: Example from problem statement
    val fruits1 = arrayOf(
        intArrayOf(2, 8),
        intArrayOf(6, 3),
        intArrayOf(8, 6)
    )
    println("Test Case 1: ${solution.maxTotalFruits(fruits1, 5, 4)}") // Expected: 9

}