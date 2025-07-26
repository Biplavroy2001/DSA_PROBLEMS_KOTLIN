fun main() {
    val solution = Solution3480()
    
    println(solution.maxSubarrays(4, arrayOf(
        intArrayOf(2, 3),
        intArrayOf(1, 4)
    ))) // Output: 9
    
   
}

class Solution3480{
    fun maxSubarrays(n: Int, conflictingPairs: Array<IntArray>): Long {
        val right = Array(n + 1) { mutableListOf<Int>() }
        for (pair in conflictingPairs) {
            val (a, b) = pair
            right[maxOf(a, b)].add(minOf(a, b))
        }

        var ans = 0L
        val left = longArrayOf(0L, 0L) // left[0] is top1, left[1] is top2
        val bonus = LongArray(n + 1)

        for (r in 1..n) {
            for (lVal in right[r]) {
                // Manually update top two values
                when {
                    lVal > left[0] -> {
                        left[1] = left[0]
                        left[0] = lVal.toLong()
                    }
                    lVal > left[1] -> {
                        left[1] = lVal.toLong()
                    }
                }
            }

            ans += r - left[0]
            
            if (left[0] > 0) {
                bonus[left[0].toInt()] += left[0] - left[1]
            }
        }
        
        val maxBonus = bonus.maxOrNull() ?: 0L

        return ans + maxBonus
    }
}