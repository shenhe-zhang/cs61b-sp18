public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque lld = new LinkedListDeque();
        for(int i=0; i<=word.length()-1; i++) {
            lld.addLast(word.charAt(i));
        }
        return lld;
    }
    public boolean isPalindrome(String word){
        Deque lld = wordToDeque(word);
        return isdequePalindrome(lld);
    }
    private boolean isdequePalindrome(Deque lld){
        if (lld.size() <= 1){
            return true;
        }
        if (lld.removeFirst() == lld.removeLast()){
            return isdequePalindrome(lld);
        }else {
            return false;
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque lld = wordToDeque(word);
        return isdequePalindrome(lld, cc);
    }
    private boolean isdequePalindrome(Deque lld, CharacterComparator cc){
        if (lld.size() <= 1){
            return true;
        }
        if (cc.equalChars((Character) lld.removeFirst(),(Character) lld.removeLast())){
            return isdequePalindrome(lld);
        }else {
            return false;
        }
    }
}
