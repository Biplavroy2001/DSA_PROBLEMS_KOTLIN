
fun main() {
    val solution = Solution1948()


    val paths1 = listOf(
        listOf("a"),
        listOf("c"),
        listOf("d"),
        listOf("a", "b"),
        listOf("c", "b"),
        listOf("d", "a")
    )
    println("Test Case 1:")
    println(solution.deleteDuplicateFolder(paths1))
    // Expected: [["d"], ["d","a"]]

    
}

class Solution1948{
    class Node(val name: String) {
        val children = sortedMapOf<String, Node>()
        var signature: String = ""
    }

    fun deleteDuplicateFolder(paths: List<List<String>>): List<List<String>> {
        val root = Node("")
        
        // Build the folder tree
        paths.forEach { path ->
            var curr = root
            path.forEach { folder ->
                curr.children.putIfAbsent(folder, Node(folder))
                curr = curr.children[folder]!!
            }
        }

        val countMap = mutableMapOf<String, Int>()
        dfs(root, countMap)

        val result = mutableListOf<List<String>>()
        val currentPath = mutableListOf<String>()
        
        root.children.values.forEach { child ->
            dfs2(child, currentPath, result, countMap)
        }
        
        return result
    }

    private fun dfs(node: Node, countMap: MutableMap<String, Int>) {
        if (node.children.isEmpty()) {
            node.signature = ""
            return
        }
        
        val sb = StringBuilder()
        node.children.values.forEach { child ->
            dfs(child, countMap)
            sb.append(child.name).append('(').append(child.signature).append(')')
        }
        
        node.signature = sb.toString()
        countMap[node.signature] = countMap.getOrDefault(node.signature, 0) + 1
    }

    private fun dfs2(
        node: Node,
        currentPath: MutableList<String>,
        result: MutableList<List<String>>,
        countMap: Map<String, Int>
    ) {
        if (node.children.isNotEmpty() && countMap.getOrDefault(node.signature, 0) >= 2) {
            return
        }
        
        currentPath.add(node.name)
        result.add(currentPath.toList())
        
        node.children.values.forEach { child ->
            dfs2(child, currentPath, result, countMap)
        }
        
        currentPath.removeAt(currentPath.size - 1)
    }
}