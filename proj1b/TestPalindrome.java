import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    @Test
    public void testisPalindrome1() {
        assertTrue(palindrome.isPalindrome("taat"));
    }
    @Test
    public void testisPalindrome2() {
//        assertTrue(palindrome.isPalindrome("taat"));
//        assertFalse(palindrome.isPalindrome("cat"));
        assertFalse(palindrome.isPalindrome("caA"));
    }

    @Test
    public void testisPalindromeOffByOne() {
        assertTrue(palindrome.isPalindrome("dede", new OffByOne()));
    }
    @Test
    public void testPalindromeOffByOne3() {
        CharacterComparator cc = new OffByOne();
        assertTrue(palindrome.isPalindrome("AcdB", cc));
    }

    @Test
    public void testPalindromeOffByOne4() {
        CharacterComparator cc = new OffByOne();
        assertFalse(palindrome.isPalindrome("stttt", cc));
    }
    @Test
    public void testisPalindromeOffByN() {
        assertTrue(palindrome.isPalindrome("dfdf", new OffByN(2)));
    }

    @Test
    public void testPalindromeOffByN3() {
        CharacterComparator cc = new OffByN(5);
        assertTrue(palindrome.isPalindrome("AhcF", cc));
    }

    @Test
    public void testPalindromeOffByN4() {
        CharacterComparator cc = new OffByN(5);
        assertFalse(palindrome.isPalindrome("stttt", cc));
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
