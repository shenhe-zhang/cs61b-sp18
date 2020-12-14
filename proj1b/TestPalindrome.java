import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    @Test
    public void testisPalindrome() {
//        assertTrue(palindrome.isPalindrome("taat"));
//        assertFalse(palindrome.isPalindrome("cat"));
        assertFalse(palindrome.isPalindrome("aA"));
    } 

    @Test
    public void testisPalindromeOffByOne() {
        assertTrue(palindrome.isPalindrome("dede", new OffByOne()));
    }

    @Test
    public void testisPalindromeOffByN() {
        assertTrue(palindrome.isPalindrome("dfdf", new OffByN(2)));
    }

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } /*Uncomment this class once you've created your Palindrome class. */
}
