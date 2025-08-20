class Solution1277{
    fun countSquares(matrix: Array<IntArray>): Int {
        val m = matrix.size
        val n = matrix[0].size
        val dp = Array(m) { IntArray(n) }
        var total = 0
        
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j]
                } else if (matrix[i][j] == 1) {
                    dp[i][j] = minOf(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
                } else {
                    dp[i][j] = 0
                }
                total += dp[i][j]
            }
        }
        
        return total
    }
}


fun main() {
    val solution = Solution1277()
    
    val matrix1 = arrayOf(
        intArrayOf(0, 1, 1, 1),
        intArrayOf(1, 1, 1, 1),
        intArrayOf(0, 1, 1, 1)
    )
}