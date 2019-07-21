package stacks

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class BalanceBracesTest {
    @Test
    fun `isBalanced returns true`() {
        assertTrue(BalanceBraces().isBalanced("(){}[]"))
    }

    @Test
    fun `isBalanced returns true 2`() {
        assertTrue(BalanceBraces().isBalanced("([{}])"))
    }

    @Test
    fun `isBalanced returns false`() {
        assertFalse(BalanceBraces().isBalanced("([){"))
    }
}