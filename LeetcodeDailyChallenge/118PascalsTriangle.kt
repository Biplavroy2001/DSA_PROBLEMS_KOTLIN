class Solution118{
    fun generate(numRows: Int): List<List<Int>> {
        if (numRows == 0) return emptyList()
        
        val result = mutableListOf<List<Int>>()
        result.add(listOf(1))
        
        for (i in 1 until numRows) {
            val prevRow = result[i - 1]
            val newRow = mutableListOf<Int>().apply {
                add(1)
                for (j in 1 until i) {
                    add(prevRow[j - 1] + prevRow[j])
                }
                add(1)
            }
            result.add(newRow)
        }
        
        return result
    }
}

fun main() {
    val solution = Solution118()
    
    fun printPascal(triangle: List<List<Int>>) {
        triangle.forEach { row ->
            println(row.joinToString(" "))
        }
    }
    
    println("Pascal's Triangle (5 rows):")
    printPascal(solution.generate(5))
    /* Output:
    1
    1 1
    1 2 1
    1 3 3 1
    1 4 6 4 1
    */
    
    println("\nPascal's Triangle (1 row):")
    printPascal(solution.generate(1))
    // Output: 1
    
    println("\nPascal's Triangle (0 rows):")
    printPascal(solution.generate(0))
    // Output: (empty)
}