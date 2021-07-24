package arraysAndStrings

// LeetCode promlem https://leetcode.com/problems/roman-to-integer/

val valueMap = mapOf(
    'I' to 1,
    'V' to 5,
    'X' to 10,
    'L' to 50,
    'C' to 100,
    'D' to 500,
    'M' to 1000,
    "IV" to 4,
    "IX" to 9,
    "XL" to 40,
    "XC" to 90,
    "CD" to 400,
    "CM" to 900
)

fun romanToInt(s: String): Int {
    var totalCount = 0
    var index = 0

    while (index <= s.lastIndex) {
        // If special case, get value and skip 2 indicies
        totalCount += if (index + 1 <= s.lastIndex) {
            valueMap["${s[index]}${s[index + 1]}"]?.let { index++; it }
                ?: valueMap[s[index]] ?: 0
        } else {
            valueMap[s[index]] ?: 0
        }
        index++
    }
    return totalCount
}