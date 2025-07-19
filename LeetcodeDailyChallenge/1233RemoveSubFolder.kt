class Solution1233 {
    fun removeSubfolders(folder: Array<String>): List<String> {
        folder.sort()
        val result = mutableListOf<String>()
        
        for (currentFolder in folder) {
            if (result.isEmpty() || !isSubfolder(currentFolder, result.last())) {
                result.add(currentFolder)
            }
        }
        
        return result
    }
    
    private fun isSubfolder(folder: String, parent: String): Boolean {
        return folder.length > parent.length && 
               folder.startsWith(parent) && 
               folder[parent.length] == '/'
    }
}

fun main() {
    val solution = Solution1233()
    
    
    val folder1 = arrayOf("/a", "/a/b", "/c/d", "/c/d/e", "/c/f")
    val result1 = solution.removeSubfolders(folder1)
    println("Example 1:")
    println("Input: ${folder1.contentToString()}")
    println("Output: $result1")
    println("Expected: [/a, /c/d, /c/f]")
    println()
    
}