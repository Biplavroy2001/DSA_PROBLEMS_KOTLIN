class Solution3477{
    fun numOfUnplacedFruits(fruits: IntArray, baskets: IntArray): Int {
        val mutableBaskets = baskets.copyOf()
        var alloted = 0
        
        for (fruit in fruits) {
            for (i in mutableBaskets.indices) {
                if (fruit <= mutableBaskets[i]) {
                    alloted++
                    mutableBaskets[i] = -1
                    break
                }
            }
        }
        
        return fruits.size - alloted
    }
}

fun main() {
    val solution = Solution3477()
    
    // Test Case 1
    val fruits1 = intArrayOf(4, 2, 5)
    val baskets1 = intArrayOf(3, 5, 4)
    println("Test Case 1: ${solution.numOfUnplacedFruits(fruits1, baskets1)}") // Expected: 1
    
}