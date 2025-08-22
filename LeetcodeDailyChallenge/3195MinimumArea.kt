class Solution3195{
    fun minimumArea(grid: Array<IntArray>): Int {
        val rows = grid.size
        val cols = grid[0].size
        var minRow = rows
        var maxRow = -1
        var minCol = cols
        var maxCol = -1

        for (i in 0 until rows) {
            for (j in 0 until cols) {
                if (grid[i][j] == 1) {
                    if (i < minRow) minRow = i
                    if (i > maxRow) maxRow = i
                    if (j < minCol) minCol = j
                    if (j > maxCol) maxCol = j
                }
            }
        }

        return (maxRow - minRow + 1) * (maxCol - minCol + 1)
    }
}

fun main() {
    val solution = Solution3195()

    val grid1 = arrayOf(
        intArrayOf(0, 1, 0),
        intArrayOf(1, 0, 1)
    )
    println("Minimum Area for grid1: ${solution.minimumArea(grid1)}")  // Output: 6

}
