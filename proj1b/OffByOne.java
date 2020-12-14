//import java.util.function.BiPredicate;

public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == 1;
    }
    /*
    public static void main(String[] args){
        OffByOne obo = new OffByOne();
        Boolean t = obo.equalChars('b', 'b');
        System.out.print(t);
        obo.equalChars('r', 'q');
    }

     */
}
