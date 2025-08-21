class Solution1504{
    fun numSubmat(mat: Array<IntArray>): Int {
        val m = mat.size
        val n = mat[0].size
        val h = IntArray(n)
        var cnt = 0

        for (i in 0 until m) {
            // Update histogram for current row
            for (j in 0 until n) {
                h[j] = if (mat[i][j] == 1) h[j] + 1 else 0
            }

            // Count submatrices ending at current row
            for (j in 0 until n) {
                var minHeight = h[j]
                var k = j
                
                // Traverse leftwards while maintaining minimum height
                while (k >= 0 && minHeight > 0) {
                    minHeight = minOf(minHeight, h[k])
                    cnt += minHeight
                    k--
                }
            }
        }
        
        return cnt
    }
}

fun main() {
    val solution = Solution1504()
    
    val mat1 = arrayOf(
        intArrayOf(1, 0, 1),
        intArrayOf(1, 1, 0),
        intArrayOf(1, 1, 0)
    )
    println("Test case 1: ${solution.numSubmat(mat1)}") // Expected: 13
    
}