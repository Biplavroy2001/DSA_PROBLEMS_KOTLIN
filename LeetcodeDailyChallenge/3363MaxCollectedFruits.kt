class Solution {
    fun maxCollectedFruits(fruits: Array<IntArray>): Int {
        val n = fruits.size
        var totalFruits = 0

        // Collect diagonal fruits (from top-left to bottom-right)
        for (i in 0 until n) {
            totalFruits += fruits[i][i]
        }

        totalFruits += calculateMaxFruits(fruits)

        // Transpose the matrix to reuse the same function for the other path
        for (i in 0 until n) {
            for (j in 0 until i) {
                val temp = fruits[i][j]
                fruits[i][j] = fruits[j][i]
                fruits[j][i] = temp
            }
        }

        totalFruits += calculateMaxFruits(fruits)

        return totalFruits
    }

    private fun calculateMaxFruits(fruits: Array<IntArray>): Int {
        val n = fruits.size
        var prevRowMax = IntArray(n) { Int.MIN_VALUE }
        prevRowMax[n - 1] = fruits[0][n - 1]

        for (row in 1 until n - 1) {
            val currRowMax = IntArray(n) { Int.MIN_VALUE }
            val startCol = maxOf(n - 1 - row, row + 1)

            for (col in startCol until n) {
                var bestPrev = prevRowMax[col]
                if (col - 1 >= 0) bestPrev = maxOf(bestPrev, prevRowMax[col - 1])
                if (col + 1 < n) bestPrev = maxOf(bestPrev, prevRowMax[col + 1])
                currRowMax[col] = bestPrev + fruits[row][col]
            }

            prevRowMax = currRowMax
        }

        return prevRowMax[n - 1]
    }
}





fun main() {
    val solution = Solution()

    // Example 1
    val fruits1 = arrayOf(
        intArrayOf(1, 2, 3, 4),
        intArrayOf(5, 6, 8, 7),
        intArrayOf(9, 10, 11, 12),
        intArrayOf(13, 14, 15, 16)
    )
    println(solution.maxCollectedFruits(fruits1)) // Expected output: 100


}