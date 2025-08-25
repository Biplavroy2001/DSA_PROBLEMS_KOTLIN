class Solution498{
    fun findDiagonalOrder(mat: Array<IntArray>): IntArray {
        if (mat.isEmpty() || mat[0].isEmpty()) return intArrayOf()
        
        val m = mat.size
        val n = mat[0].size
        val result = IntArray(m * n)
        var row = 0
        var col = 0
        
        for (i in 0 until m * n) {
            result[i] = mat[row][col]
            
            if ((row + col) % 2 == 0) { // Moving up
                if (col == n - 1) {
                    row++ // Reached right boundary, move down
                } else if (row == 0) {
                    col++ // Reached top boundary, move right
                } else {
                    row--
                    col++ // Move diagonally up-right
                }
            } else { // Moving down
                if (row == m - 1) {
                    col++ // Reached bottom boundary, move right
                } else if (col == 0) {
                    row++ // Reached left boundary, move down
                } else {
                    row++
                    col-- // Move diagonally down-left
                }
            }
        }
        
        return result
    }
}

fun main() {
    val solution = Solution498()
    
    // Test Case 1
    val mat1 = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
    )
    val result1 = solution.findDiagonalOrder(mat1)
    println("Test Case 1: ${result1.joinToString(", ")}")
    println("Expected: 1, 2, 4, 7, 5, 3, 6, 8, 9")
    println()
    
}