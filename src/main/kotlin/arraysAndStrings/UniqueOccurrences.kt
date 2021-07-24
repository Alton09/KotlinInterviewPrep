package arraysAndStrings


// LeetCode problem https://leetcode.com/problems/unique-number-of-occurrences/

fun uniqueOccurrences(arr: IntArray): Boolean {
    // declare unique count map <int, int>
    val uniqueCountMap: MutableMap<Int, Int> = mutableMapOf()
    // Loop through array
    arr.forEach { currentNum ->
        // add int to map or increment it's value
        val currentValue = uniqueCountMap[currentNum] ?: 0
        uniqueCountMap[currentNum] = currentValue + 1
    }
    // Check values of map to see if all are unique
    var containsElement = false
    uniqueCountMap.values.forEach {
        println(it)
        val remainingElements = uniqueCountMap.values.toMutableList()
        remainingElements.remove(it)
        containsElement = remainingElements.contains(it)
    }
    return !containsElement
}