class Solution2561{
    fun minCost(basket1: IntArray, basket2: IntArray): Long {
        val totalCounts = mutableMapOf<Int, Int>()
        basket1.forEach { fruit -> totalCounts[fruit] = totalCounts.getOrDefault(fruit, 0) + 1 }
        basket2.forEach { fruit -> totalCounts[fruit] = totalCounts.getOrDefault(fruit, 0) + 1 }

        var minVal = Long.MAX_VALUE
        for ((fruit, count) in totalCounts) {
            if (count % 2 != 0) return -1L
            if (fruit < minVal) minVal = fruit.toLong()
        }

        val count1 = mutableMapOf<Int, Int>()
        basket1.forEach { fruit -> count1[fruit] = count1.getOrDefault(fruit, 0) + 1 }

        val fruitsToSwap = mutableListOf<Long>()
        for ((fruit, total) in totalCounts) {
            val diff = count1.getOrDefault(fruit, 0) - (total / 2)
            repeat(kotlin.math.abs(diff)) {
                fruitsToSwap.add(fruit.toLong())
            }
        }

        fruitsToSwap.sort()

        var totalCost = 0L
        val swapsToMake = fruitsToSwap.size / 2
        for (i in 0 until swapsToMake) {
            totalCost += minOf(fruitsToSwap[i], 2 * minVal)
        }

        return totalCost
    }
}


fun main() {
    val solution = Solution2561()

    // Test Case 1
    val basket1a = intArrayOf(4, 2, 2, 2)
    val basket2a = intArrayOf(1, 4, 1, 2)
    println(solution.minCost(basket1a, basket2a)) // Expected output: 1

    
}