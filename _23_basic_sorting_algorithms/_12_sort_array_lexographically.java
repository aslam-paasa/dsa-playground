package _23_basic_sorting_algorithms;

import java.util.Arrays;
import java.util.Comparator;

public class _12_sort_array_lexographically {
    public static void main(String[] args) {
        /**
         * Array of Strings - Sort lexographically
        */
        String[] arr = {"apple", "banana", "grape", "orange", "kiwi"};

        /**
         * Custom comparator for lexicographical sorting
        */
        Comparator<String> lexicoComparator = new Comparator<String>() {

            @Override
            public int compare(String x, String y) {

                // Lexicographical comparison logic
                int minLength = Math.min(x.length(), y.length());
                
                // Compare characters one by one
                for (int i = 0; i < minLength; i++) {
                    if (x.charAt(i) < y.charAt(i)) {
                        return -1;
                    } else if (x.charAt(i) > y.charAt(i)) {
                        return 1;
                    }
                }

                // If all characters are the same in the shorter word,
                // the shorter word comes first
                if (x.length() < y.length()) {
                    return -1;
                } else if (x.length() > y.length()) {
                    return 1;
                }

                // If the words are completely equal
                return 0;
            }
        };

        // Sorting the array using the custom comparator
        Arrays.sort(arr, lexicoComparator);

        // Printing the sorted array
        for (String str : arr) {
            System.out.println(str);
        }
    }
}
