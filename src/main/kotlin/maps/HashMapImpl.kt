package maps

import java.util.*
import kotlin.math.absoluteValue

/**
 * Simple implementation of a hash map per the instructions in the cracking the coding interview book Hash Tables
 * section.
 */
class HashMapImpl<K, V> {
    private val keys = arrayOfNulls<LinkedList<V>>(100)

    fun put(key: K, value: V) {
        val keyIndex = computeKeyIndex(key)
        keys[keyIndex]?.let { bucket ->
            bucket.add(value)
        } ?: run {
            val bucket = LinkedList<V>().apply { add(value) }
            keys[keyIndex] = bucket
        }
    }

    fun get(key: K): LinkedList<V>? = keys[computeKeyIndex(key)]


    private fun computeKeyIndex(key: K) = (key.hashCode() % keys.size).absoluteValue
}