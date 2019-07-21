package maps

import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert.assertTrue
import org.junit.Test
import java.util.*

class HashMapImplTest {


    @Test
    fun `put should insert a new String and get should retrieve that String`() {
        val key = "key"
        val expectedValue = "hello"
        val map = HashMapImpl<String, String>()

        map.put("etvq", "asdf")
        map.put("*6<", "blah")
        map.put(key, expectedValue)
        map.put("1gty", "fsue")
        val actualValue = map.get(key)?.first

        assertThat(actualValue, equalTo(expectedValue))
    }

    @Test
    fun `put should insert a new Int and get should retrieve that Int with a mixed key value map`() {
        val key = 123
        val expectedValue = "ha!"
        val map = HashMapImpl<Int, String>()

        map.put(3, "asdf")
        map.put(key, expectedValue)
        map.put(7453457, "a")
        map.put(6678, "hey oh!")
        val actualValue = map.get(key)?.first

        assertThat(actualValue, equalTo(expectedValue))
    }

    @Test
    fun `collision values should be stored within the same list`() {
        val map = HashMapImpl<String, String>()
        val expectedLinkedList = LinkedList<String>().apply {
            add("Test")
            add("fsue")
        }

        map.put("hi", "Test")
        map.put("hi", "fsue")
        map.put("*6<", "blah")
        val actualValue = map.get("hi")

        assertThat(actualValue, equalTo(expectedLinkedList))
    }

    @Test
    fun `getting a value that doesn't exist returns null`() {
        val key = "key"
        val expectedValue = "hello"
        val map = HashMapImpl<String, String>()

        map.put("etvq", "asdf")
        map.put("*6<", "blah")
        map.put(key, expectedValue)
        map.put("1gty", "fsue")
        val actualValue = map.get("Doesn't exist")

        assertThat(actualValue, `is`(nullValue()))
    }

    // TODO doesn't test get thread safety
    @Test
    fun `put and get are thread safe`() {
        val map = HashMapImpl<String, Int>()
        var wait = true
        Thread {
            for(i in 1..50) {
                Thread.sleep(10)
                map.put("A", i)
            }
            wait = false
        }.start()
        for(i in 51..100) {
            Thread.sleep(10)
            map.put("A", i)
        }
        while (wait) {
            Thread.sleep(10)
        }
        val result = map.get("A")
        var success = true
        for(i in 1..100) {
           success = result!!.contains(i)
        }
        print(result)
        assertTrue(success)
    }
}