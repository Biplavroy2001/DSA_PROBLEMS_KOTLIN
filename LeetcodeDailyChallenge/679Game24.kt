import kotlin.math.abs

class Solution679{
    private val EPS = 1e-6

    fun judgePoint24(cards: IntArray): Boolean {
        val nums = cards.map { it.toDouble() }.toMutableList()
        return dfs(nums)
    }

    private fun dfs(nums: MutableList<Double>): Boolean {
        if (nums.size == 1) {
            return abs(nums[0] - 24.0) < EPS
        }
        for (i in nums.indices) {
            for (j in nums.indices) {
                if (i == j) continue
                val next = mutableListOf<Double>()
                for (k in nums.indices) {
                    if (k != i && k != j) next.add(nums[k])
                }
                for (valNew in compute(nums[i], nums[j])) {
                    next.add(valNew)
                    if (dfs(next)) return true
                    next.removeAt(next.size - 1)
                }
            }
        }
        return false
    }

    private fun compute(a: Double, b: Double): List<Double> {
        val res = mutableListOf<Double>()
        res.add(a + b)
        res.add(a - b)
        res.add(b - a)
        res.add(a * b)
        if (abs(b) > EPS) res.add(a / b)
        if (abs(a) > EPS) res.add(b / a)
        return res
    }
}



fun main() {
    val solution = Solution679()

    val testCases = arrayOf(
        intArrayOf(4, 1, 8, 7),  // Expected: true
        intArrayOf(1, 2, 1, 2),  // Expected: false
        intArrayOf(3, 3, 8, 8),  // Example additional test
        intArrayOf(1, 5, 5, 5)   // Example additional test
    )

    for ((index, cards) in testCases.withIndex()) {
        val result = solution.judgePoint24(cards)
        println("Test case ${index + 1}: cards = ${cards.joinToString(", ")} -> $result")
    }
}
