class Solution3479



{
    private lateinit var seg: IntArray
    private var n = 0

    private fun update(p: Int) {
        seg[p] = maxOf(seg[p shl 1], seg[(p shl 1) or 1])
    }

    private fun build(p: Int, l: Int, r: Int, baskets: IntArray) {
        if (l == r) {
            seg[p] = baskets[l]
            return
        }
        val mid = (l + r) shr 1
        build(p shl 1, l, mid, baskets)
        build((p shl 1) or 1, mid + 1, r, baskets)
        update(p)
    }

    private fun assign(x: Int, v: Int, p: Int, l: Int, r: Int) {
        if (x < l || x > r) return
        if (l == r) {
            seg[p] = v
            return
        }
        val mid = (l + r) shr 1
        assign(x, v, p shl 1, l, mid)
        assign(x, v, (p shl 1) or 1, mid + 1, r)
        update(p)
    }

    private fun firstLarger(v: Int, p: Int, l: Int, r: Int): Int {
        if (seg[p] < v) return r + 1
        if (l == r) return r
        val mid = (l + r) shr 1
        val lf = firstLarger(v, p shl 1, l, mid)
        if (lf <= mid) return lf
        return firstLarger(v, (p shl 1) or 1, mid + 1, r)
    }

    fun numOfUnplacedFruits(fruits: IntArray, baskets: IntArray): Int {
        n = fruits.size
        seg = IntArray(4 * n + 1)
        build(1, 0, n - 1, baskets)
        var res = 0
        for (x in fruits) {
            val pos = firstLarger(x, 1, 0, n - 1)
            if (pos == n) {
                res++
            } else {
                assign(pos, 0, 1, 0, n - 1)
            }
        }
        return res
    }
}





fun main() {
    val solution = Solution3479()

    // Example 1
    val fruits1 = intArrayOf(4, 2, 5)
    val baskets1 = intArrayOf(3, 5, 4)
    println(solution.numOfUnplacedFruits(fruits1, baskets1)) // Expected output: 1

}