fun main() {
    val solution = Solution2322()

    // Test Case 1 (Example 1)
    val nums1 = intArrayOf(1, 5, 5, 4, 11)
    val edges1 = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 2),
        intArrayOf(1, 3),
        intArrayOf(3, 4)
    )
    
}


class Solution2322{
    private lateinit var subtreeXor: IntArray
    private lateinit var descendants: Array<MutableSet<Int>>
    private lateinit var graph: Array<MutableList<Int>>

    private fun dfs(node: Int, parent: Int, nums: IntArray) {
        subtreeXor[node] = nums[node]
        descendants[node].add(node)

        for (neighbor in graph[node]) {
            if (neighbor != parent) {
                dfs(neighbor, node, nums)
                subtreeXor[node] = subtreeXor[node] xor subtreeXor[neighbor]
                descendants[node].addAll(descendants[neighbor])
            }
        }
    }

    fun minimumScore(nums: IntArray, edges: Array<IntArray>): Int {
        val n = nums.size
        graph = Array(n) { mutableListOf<Int>() }
        for (edge in edges) {
            graph[edge[0]].add(edge[1])
            graph[edge[1]].add(edge[0])
        }

        subtreeXor = IntArray(n)
        descendants = Array(n) { mutableSetOf<Int>() }

        dfs(0, -1, nums)

        val totalXor = subtreeXor[0]
        var minScore = Int.MAX_VALUE

        for (i in 1 until n) {
            for (j in i + 1 until n) {
                val xorI = subtreeXor[i]
                val xorJ = subtreeXor[j]
                val (val1, val2, val3) = when {
                    descendants[i].contains(j) -> { // j is in i's subtree
                        Triple(xorJ, xorI xor xorJ, totalXor xor xorI)
                    }
                    descendants[j].contains(i) -> { // i is in j's subtree
                        Triple(xorI, xorJ xor xorI, totalXor xor xorJ)
                    }
                    else -> { // Independent subtrees
                        Triple(xorI, xorJ, totalXor xor xorI xor xorJ)
                    }
                }

                val maxVal = maxOf(val1, val2, val3)
                val minVal = minOf(val1, val2, val3)
                minScore = minOf(minScore, maxVal - minVal)
            }
        }

        return minScore
    }
}