/**
 * Class for doing Radix sort
 *
 * @author Akhil Batra, Alexander Hwang
 *
 */
public class RadixSort {
    /**
     * Does LSD radix sort on the passed in array with the following restrictions:
     * The array can only have ASCII Strings (sequence of 1 byte characters)
     * The sorting is stable and non-destructive
     * The Strings can be variable length (all Strings are not constrained to 1 length)
     *
     * @param asciis String[] that needs to be sorted
     *
     * @return String[] the sorted array
     */
    public static String[] sort(String[] asciis) {
        // TODO: Implement LSD Sort
        String[] sorted = new String[asciis.length];
        int i = 0;
        // find max
        int max = Integer.MIN_VALUE;
        for (String s : asciis) {
            max = max > s.length() ? max : s.length();
            sorted[i] = s;
            i++;
        }
        for (i = max-1; i >= 0; i--) {
            sortHelperLSD(sorted,i);
        }
        return sorted;
    }

    /**
     * LSD helper method that performs a destructive counting sort the array of
     * Strings based off characters at a specific index.
     * @param asciis Input array of Strings
     * @param index The position to sort the Strings on.
     */
    private static void sortHelperLSD(String[] asciis, int index) {
        // Optional LSD helper method for required LSD radix sort
        // gather all the counts for each value
        int[] counts = new int[256];
        for (String s:asciis) {
            counts[getchar(s,index)] += 1;
        }
        // when we're dealing with ints, we can just put each value
        // count number of times into the new array
        int[] starts = new int[256];
        int pos = 0;
        for (int i = 0; i < starts.length; i += 1) {
            starts[i] = pos;
            pos += counts[i];
        }

        String[] sorted = new String[asciis.length];
        for (int i = 0; i < asciis.length; i += 1) {
            String s = asciis[i];
            int place = starts[getchar(s,index)];
            sorted[place] = s;
            starts[getchar(s,index)] += 1;
        }
        for (int i = 0; i < sorted.length; i += 1) {
            asciis[i] = sorted[i];
        };
    }

    private static int getchar(String s, int index) {
        if (s.length() <= index) {
            return 32;
        }
        return s.charAt(index);
    }


    /**
     * MSD radix sort helper function that recursively calls itself to achieve the sorted array.
     * Destructive method that changes the passed in array, asciis.
     *
     * @param asciis String[] to be sorted
     * @param start int for where to start sorting in this method (includes String at start)
     * @param end int for where to end sorting in this method (does not include String at end)
     * @param index the index of the character the method is currently sorting on
     *
     **/
    private static void sortHelperMSD(String[] asciis, int start, int end, int index) {
        // Optional MSD helper method for optional MSD radix sort
        return;
    }
//    public static void main(String args[]) {
//        String[] testArr1 = {"alatn",  "hello", "succe", "donld", "hcdeh","heleh", "12321", "!*^&!"};
//        String[] sorted = sort(testArr1);
//        for (String s:sorted) {
//            System.out.println(s);
//        }
//        String s = "adsafds";
//        System.out.print(getchar(s,8));
//    }
}
