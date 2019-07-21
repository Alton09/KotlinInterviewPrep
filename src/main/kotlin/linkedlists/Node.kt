package linkedlists

class Node<T>(private val data: T) {
    var next: Node<T>? = null

    fun add(d: T) {
        val end = Node(d)
        next?.let {
            it.add(d)
        } ?: run {
            next = end
        }
    }

    companion object {
        /**
         * problem 2.5 from the cracking the coding interview book
         */
        fun add(nodeA: Node<Int>, nodeB: Node<Int>): Node<Int> {
            val sum = (nodeA.getNumAsString().toInt() + nodeB.getNumAsString().toInt()).toString().toCharArray()
            val result = Node(sum.last().toString().toInt())
            for(i in sum.size - 2 downTo 0) {
                result.add(sum[i].toString().toInt())
            }
            return result
        }
    }

    private fun getNumAsString(): String {
        next?.let {
            return it.getNumAsString() + data
        } ?: return data.toString()
    }
}