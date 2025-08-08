class Solution808{
    private lateinit var cache: Array<DoubleArray> // Memoization storage

    fun soupServings(n: Int): Double {
        // For large n, probability approaches 1 (within 10^-5 tolerance)
        if (n > 5000) return 1.0

        val units = (n + 24) / 25 // Convert mL → 25 mL units (ceiling division)
        cache = Array(units + 1) { DoubleArray(units + 1) { -1.0 } }

        return calcProb(units, units)
    }

    private fun calcProb(soupA: Int, soupB: Int): Double {
        // Both empty → half probability
        if (soupA <= 0 && soupB <= 0) return 0.5
        // A empty first → full probability
        if (soupA <= 0) return 1.0
        // B empty first → zero probability
        if (soupB <= 0) return 0.0

        // Return cached result if available
        if (cache[soupA][soupB] != -1.0) return cache[soupA][soupB]

        // Calculate probability for all 4 operations
        val prob = 0.25 * (
            calcProb(soupA - 4, soupB) +
            calcProb(soupA - 3, soupB - 1) +
            calcProb(soupA - 2, soupB - 2) +
            calcProb(soupA - 1, soupB - 3)
        )

        // Store result in cache
        cache[soupA][soupB] = prob
        return prob
    }
}




fun main() {
    val solution = Solution808()

    // Test cases
    val testCases = listOf(
        0, 50, 100, 200, 500, 
        1000, 2000, 3000, 4000, 5000, 
        6000, 10000
    )

    println("n\tProbability")
    println("---------------------")
    for (n in testCases) {
        val prob = solution.soupServings(n)
        println("$n\t${"%.6f".format(prob)}")
    }

    
}