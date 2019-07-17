package arraysAndStrings

fun searchArrayContainsSequence(searchArray: Array<Int>, seqArray: Array<Int>): Boolean {
    if(searchArray.size >= seqArray.size) {
        for((index, value) in searchArray.withIndex()) {
            if(value == seqArray[0]) {
                for(j in 1 until seqArray.size - 1) {
                    if(searchArray[index + j] == seqArray[j]) {
                        return false
                    }
                }
            }
        }
    } else {
        return false
    }
    return true
}