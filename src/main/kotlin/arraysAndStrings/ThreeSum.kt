package arraysAndStrings

/*
[-1,0,1,2,-1,-4]
1. Iterate through all the triplets
2. Sort each triplet
3. Check that each triplet meets conditions
    - true -> sort triplet and store triplet in a set
    - false -> continue to next triplet
4. Check input and return empty array if...
    - less than 3 nums
    - empty nums

 */

fun main() {
    println(threeSum(arrayOf(-1,0,1,2,-1,-4).toIntArray()))
}

fun threeSum(nums: IntArray): List<List<Int>> {
    if (nums.size < 3) return emptyList()
    var (i, j, k) = listOf(0,0,0)
    val result: MutableSet<List<Int>> = mutableSetOf()
    while (i <= nums.lastIndex) {
        j = 0
        while (j <= nums.lastIndex) {
            k = 0
            if (j == i) {
                j++
                continue
            }
            while (k <= nums.lastIndex) {
                if (k == i || k == j) {
                    k++
                    continue
                }
                val temp = listOf(nums[i], nums[j], nums[k])
                if (temp.sum() == 0) {
                    result.add(temp.sorted())
                }
                k++
            }
            j++
        }
        i++
    }
    return result.toList()
}