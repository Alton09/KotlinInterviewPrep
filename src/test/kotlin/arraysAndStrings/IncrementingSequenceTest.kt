package arraysAndStrings

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class IncrementingSequenceTest {

    @Test
    fun `searchArrayContainsSequence should return false when the search array is less than the size of the sequence`() {
        val searchArray = arrayOf(1)
        val seqArray = arrayOf(8,6)

        val containsSequence = searchArrayContainsSequence(searchArray, seqArray)

        assertThat(containsSequence, equalTo(false))
    }

    @Test
    fun `searchArrayContainsSequence should return true with a search array of 8,6 and a sequence of 8,6`() {
        val searchArray = arrayOf(8, 6)
        val seqArray = arrayOf(8,6)

        val containsSequence = searchArrayContainsSequence(searchArray, seqArray)

        assertThat(containsSequence, equalTo(true))
    }

    @Test
    fun `searchArrayContainsSequence should return true with a search array of 1,2,8,6,5 and a sequence of 8,6`() {
        val searchArray = arrayOf(1,2,8,6,5)
        val seqArray = arrayOf(8,6)

        val containsSequence = searchArrayContainsSequence(searchArray, seqArray)

        assertThat(containsSequence, equalTo(true))
    }

    @Test
    fun `searchArrayContainsSequence should return false with a search array of 1,2,8,6,5 and a sequence of 8,6,2`() {
        val searchArray = arrayOf(1,2,8,6,5)
        val seqArray = arrayOf(8,6,2)

        val containsSequence = searchArrayContainsSequence(searchArray, seqArray)

        assertThat(containsSequence, equalTo(false))
    }
}