class Solution2438{
    fun productQueries(n: Int, queries: Array<IntArray>): IntArray {
        val MOD = 1_000_000_007
        val powers = mutableListOf<Int>()
        var power = 1
        var num = n

        while (num > 0) {
            if (num and 1 == 1) {
                powers.add(power)
            }
            power = power shl 1
            num = num shr 1
        }

        // Precompute prefix products
        val prefix = LongArray(powers.size + 1).apply {
            this[0] = 1L
            for (i in powers.indices) {
                this[i + 1] = (this[i] * powers[i]) % MOD
            }
        }

        return IntArray(queries.size) { i ->
            val (left, right) = queries[i]
            if (left == 0) {
                prefix[right + 1].toInt()
            } else {
                val denominator = prefix[left]
                val numerator = prefix[right + 1]
                val inv = modInverse(denominator, MOD.toLong())
                ((numerator * inv) % MOD).toInt()
            }
        }
    }

    private fun modInverse(a: Long, mod: Long): Long {
        var x = 1L
        var y = 0L
        var n = a
        var m = mod
        while (m != 0L) {
            val quotient = n / m
            var temp = m
            m = n % m
            n = temp
            temp = y
            y = x - quotient * y
            x = temp
        }
        if (x < 0) x += mod
        return x
    }
}

fun main() {
    val solution = Solution2438()
    
    // Test Case 1
    val n1 = 15
    val queries1 = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(2, 2),
        intArrayOf(0, 3)
    )
    val result1 = solution.productQueries(n1, queries1)
    println("Test Case 1: ${result1.joinToString(", ", "[", "]")}") // Expected: [2, 4, 64]

}