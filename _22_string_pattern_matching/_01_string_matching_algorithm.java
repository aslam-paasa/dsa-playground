package _22_string_pattern_matching;

public class _01_string_matching_algorithm {
/**
 * String Matching Algorithm:
 * - It is used to compare two strings and find the pattern in the text.
*/

/**
 * Question:
 * - Suppose humein ek text diya hai: Text = "ABCAABCD". 
 *   Aur ek pattern diya hai        : Pattern = "ABC"
 * - Search karo ki ye pattern mere text m hai ya nahi, aur agar present hai
 *   to uska starting index return karo aur nhi to -1.
 * 
 * Example: 
 *              0  1  2  3  4  5  6  7`
 * > Text    = [A, B, C, A, A, B, C, D] (return 4 to 6)
 * > Pattern = [A, B, C]
 *              0  1  2
*/

/**
 * 1. Brute Force Approach:
 *    - Ye approach poore data structure mai hota hai. It means optimization
 *      se humein kuch lena dena nahi hai, ek simple solution bta do jisse
 *      sirf answer aa jae.
 *    - Sabse pehle hum 2 pointer lenge i, j. 
 *      > i points to Text and j points to Pattern (i = 0, j = 0)
 *      > Ab compare karange ki:
 *        if (Text[i] == Pattern[j]) {
 *          i++;
 *          j++;
 *        } else {
 *          j = 0;
 *        }
 * 
 *  Time Complexity: O(n*m)
 *  Space Complexity: O(1)
*/

    class BruteForcePatternSearch {
        public static int compareTextAndPattern(String text, String pattern) {
            int n = text.length();
            int m = pattern.length();
            
            for(int i = 0; i <= n-m; i++) {
                int j = 0;

                // Check for match at position
                for(j = 0; j < m; j++) {
                    if(text.charAt(i+j) != pattern.charAt(j)) {
                        break;
                    }
                }

                // If full pattern matched
                if(j == m) {
                    return i; // Match found at index i
                }
            }
            return -1; // No match found
        }

        public static void main(String[] args) {
            String text = "ababcabcabababd";
            String pattern = "ababd";
    
            int result = BruteForcePatternSearch.compareTextAndPattern(text, pattern);
    
            if (result == -1) {
                System.out.println("Pattern not found in the text.");
            } else {
                System.out.println("Pattern found at index: " + result);
            }
        }
    }

/**
 * Approach-2: Rabin-Karp Algorithm:
 * - Ye algorithm sabse jyda use m aati hai kyuki ye jyda muskil v nahi hai
 *   aur efficient v hai.
 * - Ye algorithm hascode k upar work karti hai. HashCode ek formula hota hai
 *   aur uss formula k according hum kisi v pattern ka ek number generate
 *   kar lenge.
 * 
 *   > Text    = [A, B, C, A, A, B, C, D]
 *   > Pattern = [A, A, B]
 * 
 * - Sabse pehle humein text k first three ko pattern k first three se 
 *   compare krna hai. But Robin Karp m hum direct comparison nahi krnge,
 *   hum dono ka hashcode nikaalnge ("ABC" = 123) & ("AAB" = 143), then
 *   compare krnge, aur dono hashcode alag hai to hum char ko compare nhi
 *   krenge. HashCode ka TC O(1) hota hai, so humein comparison time kam
 *   kr liya, fir i++ kar k aage badhange.
 * 
 * - Now humein fir se do hashcode ko compare krna hai: ("BCA") & ("AAB")
 *   aur dono hashcode alag hai to hum char ko compare nhi krenge and i++
 *   kar k aage badhange.
 *   
 *   hashCode("ABC") = 123
 *   hashCode("BCA") = 143
 *   hashCode("BCA") = 246
 *   hashCode("CAA") = 143
 * 
 * - Ho sakta hai ki CAA ka hashcode AAC k saath match kar jae, lekin iska
 *   matlab ye nahi hai ki dono ka pattern same hai. To ab hum char by char
 *   compare karnge. Agar same nhi hai to i++ kar k aage badhange.
 * 
 *   hashCode("AAC") = 143 == hashCode("AAC") = 143, so hum char by char
 *   compare karnge. Aur agar dono same hai to index return kar denge.
*/

/**
 * What is a HashCode?
 * - HashCode ek number hota hai jo string ko characters ke base par banta hai
 * - Jaise hum kisi word ko ek unique number mein convert kar dete hain.
 * - Example:
 *   > 123 = 1 x 10^2 + 2 x 10^1 + 3 x 10^0
 *   > 123 = 100 + 20 + 3
 *   > 123 = 123
 * 
 * - 123 to 234 using Rolling HashCode:
 *   a. Start with 123
 *      > 123 = 1 x 10^2 + 2 x 10^1 + 3 x 10^0
 *      > 123 = 100 + 20 + 3
 *   b. Remove leftmost digit (1)
 *      > Remove: 1 x 10^2 = 100
 *      > Remaining: 23
 *   c. Multiply remaining by 10
 *      > 23 x 10 = 230
 *   d. Add new rightmost digit (4)
 *      > 230 + 4 = 234

 * - Yehi idea hum strings ke liye use krte hai (bas ASCII values ke saath)
 * 
 * Why do we use Rolling Hash?
 * - Jab hum ek pattern ko text ke andar dhoondh rahe hote hain (like "abc" 
 *   in "ababc"), to har baar pura pattern compare karna slow hota hai.
 * - Isliye hum har substring ka ek hash nikalte hain.
 * - Hash fast compare hota hai — O(1) time mein.
 * 
 * - Rolling hash ek trick hai jisse hum "next substring" ka hash fast nikalte
 *   hain bina sab characters ko dobara calculate kiye.
 * 
 * Basic Rolling Hash Concept:
 * - Suppose we have "123" and want to move to "234".
 *   a. Start with: 
 *      > "123": (1*10^2 + 2*10^1 + 3*10^0) = 123  
 *   b. Remove leftmost digit: 
 *      > "1*10^2 = 100" -> remaining "23"
 *   c. Multiply remaining by 10:
 *      > "23*10 = 230" 
 *   d. Add new rightmost digit (4):
 *      > "230 + 4 = 234" 
 * 
 * - Done! We found new hash in constant time: "O(1)"
 * 
 * Rolling Hash Formula (for Strings):
 * > newHash = ((oldHash - firstChar*d^(m-1)) * d + newChar) % q
 *   where:
 *   a. d = 256 (ASCII characters: unique value for each character)
 *   b. m = pattern length
 *   c. newChar = next incoming character
 *   d. firstChar = outgoing char (window se bahar)
 *   e. q = 101 (prime number to avoid hash collisions)
 * 
 * > Why q?
 *   - Hash banate time nums bahut bade ho jaate hai (kyuki hum 256 se
 *     multiply karte hai).
 *   - Agar hum % q (modulo) use nahi karein to:
 *     - Num bahut bade ho jaate hai (overflow ho sakta hai)
 *     - Calculation slow ho jaata hai
 *     - Aur comparison difficult ho jaata hai
 *   - To % q use krne se:
 *     - Num chota aur manageable rehta hai
 *     - Hash Values 0 se q-1 ke beech rehti hai (agar q = 101 ha to 
 *       0-100 tak rehti hai)
 * > Prime Number hi kyu?
 *   - Prime Number ka use krne se hash values acche se distribute hoti hai
 *   - Means:
 *     - Do alag strings ka same hash milne ke chances (collisions) kam ho 
 *       jaate hai
 *     - Hash Values evenly spread hoti hai, clustered nahi hoti
 *   - Agar q prime nhi hoti, to kuch patterns repeat hone lagta hai
 *     (same hash milta hai)
 * > 101 hi kyu?
 *   - 101 ek small prime number hai jo example ke liye perfect hai:
 *     - Chota hai : Manual calculation easy
 *     - Prime hai : collision kam
 *     - Fast hai  : code me efficiently kaam krta hai
 * - Real world me hum bade prime numbers use karte hai (like 1009 ya 10_000_003)
 * 
 * > Example:
 *   - Soch lo humare paas string "abc" hai:
 *     d = 256
 *     q = 101
 *   - Hash formula:
 *     - hash = (a*256² + b*256¹ + c*256⁰) % 101
 *     - Agar % 101 nhi lagate to number bahut bada hota - lekin % 101 lagane
 *       ke baad hash chota number ban jaata hai (0 - 100 range me)
 * 
 *   - Maan lo hum Rabin-Karp algorithm me ye values use kar rhe hai:
 *     q = 256; => Total ASCII chars
 *     d = 101; => Prime num to avoid collisions
 *   - Agar humare paas do strings hai: "abc" & "acb":
 *     a. Ek baar bina modulo ke
 *     b. Ek baar baar modulo ke saath (% 101)
 * 
 *   1. ASCII values likho:
 *      - a = 97
 *      - b = 98
 *      - c = 99
 *   2. Hash Formula:
 *      - hash = (a*d^2 + b*d^1 + c*d^0)
 *   3. Calculate hash without % 101
 *      - For "abc":
 *        hash = (97 * 256^2) + (98 * 256^1) + (99 * 256^0)
 *        hash = (97 * 65536) + (98 * 256) + 99
 *        hash = 6356992 + 25088 + 99
 *        hash = 6382179
 *      - For "acb":
 *        hash = (97 * 256^2) + (99 * 256^1) + (98 * 256^0)
 *        hash = (97 * 65536) + (99 * 256) + 98
 *        hash = 6356992 + 25344 + 98
 *        hash = 6382434
 *      - Difference b/w 6382434 - 6382179 = 255
 * 
 *      - Dono ka diff bahut bada number me ho sakta hai, jo practical
 *        comparison me overflow ye precision loss la sakta hai
 * 
 *   4. Ab % 101 lagate hai:
 *      - For "abc": hash = 6382179 % 101 = 90
 *      - For "acb": hash = 6382434 % 101 = 45
 *      - Ab dekho - dono hash values 90 aur 45 aa rhe hai, jo chhoti aur
 *        manageable hain (0-100 range me)
 * 
 *   5. Comparison:
 *      > "abc": 
 *        - Without modulo: 6382179
 *        - With modulo   : 90
 *      > "acb": 
 *        - Without modulo: 6382434
 *        - With modulo   : 45
 * 
 *   6. Real-Life Analogy:
 *      Soch lo tmhre paas huge numbers hain (like ₹6,38,24,34), tum sirf
 *      last two digits (mod 100) store karte ho, to numbers chota aur easy
 *      ho jaata hai, handle karne ke liye
 *  
 *      Bas Rabin-Karp me %101 exactly wahi krte hai - bade hash ko chote
 *      manageable number m convert kar deta hai.
 * 
 * Example:
 * - Text: "abcd"
 * - Pattern: "bc"
 * 
 * 1. First window "ab" > calculate hash
 * 2. Compare with pattern hash
 * 3. Slide window:
 *    - remove 'a'
 *    - multiply by d (256)
 *    - add 'c'
 * 4. Compare again: this is the rolling part
 * 
 * Note:
 * 1. Hash        : String ka unique number
 * 2. Rolling Hash: Fast update of hash when window slides
 * 3. Modulo(q)   : Number chota aur safe banata hai
 * 4. Rabin-Karp  : Algorithm using rolling hash for pattern searching
*/

    class RabinKarpPatternSearch {
        public static int rabinKarpSearch(String text, String pattern) {

            /**
             * 1. d = 256 > Num of chars in the input alphabet (ASCII)
             * 2. q = 101 > A prime num to reduce hash collisions
            */
            int d = 256;
            int q = 101;
    
            int n = text.length();
            int m = pattern.length();
    
            /**
             * 3. p = 0 > Hash value for pattern
             * 4. t = 0 > Hash value for current text window
             * 5. h = 1 
            */
            int p = 0;
            int t = 0;
            int h = 1;
    
            /**
             * Step-1: Calculate h = (d^(m-1)) % q 
             */
            for (int i = 0; i < m - 1; i++) {
                h = (h * d) % q;
            }
    
            /**
             * Step-2: Initial hash value for pattern & first window of text
             * > We compute the hash value for the pattern and the first window
             *   of text using the rolling hash formula
             * > We use the modulo operation to keep the hash value in the
             *   range of 0 to q-1
             */
            for (int i = 0; i < m; i++) {
                p = (d * p + pattern.charAt(i)) % q;
                t = (d * t + text.charAt(i)) % q;
            }
    
            /**
             * Step-3: Slide the pattern over text one character at a time
             * > In every iteration, we will compare the hashcodes of the
             *   pattern and the current window of text
             * > If they match, we need to verify each character to confirm
             *   the pattern match
             * > If any character doesn't match, we break out of the loop
             * > If all characters match, we return the starting index of
             *   the pattern in the text
             */
            for (int i = 0; i <= n - m; i++) {
                if (p == t) {
                    int j;
                    for (j = 0; j < m; j++) {
                        if (text.charAt(i + j) != pattern.charAt(j)) {
                            break;
                        }
                    }
                    if (j == m) {
                        return i; // Pattern found at index i
                    }
                }
    
                /**
                 * Step-4: Compute hash for next window (rolling hash)
                 * > If i (current index) is less than (n - m) (last possible
                 *   index of the text to match the pattern), we compute the
                 *   hash for the next window
                 * > We remove the leftmost character from the current hash 
                 *   and add the new rightmost character to the new hash
                 * > We use the modulo operation to keep the hash value in the
                 *   range of 0 to q-1
                 * > If t (hash of current window) becomes negative, we make 
                 *   it positive by adding q.
                 */
                if (i < n - m) {
                    t = (d * (t - text.charAt(i) * h) + text.charAt(i + m)) % q;
    
                    /**
                     * If t becomes negative, make it positive
                     */
                    if (t < 0) {
                        t = (t + q);
                    }
                }
            }
    
            return -1; // Pattern not found
        }
    
        public static void main(String[] args) {
            String text = "ababcabcabababd";
            String pattern = "ababd";
    
            int result = RabinKarpPatternSearch.rabinKarpSearch(text, pattern);
    
            if (result == -1) {
                System.out.println("Pattern not found in the text.");
            } else {
                System.out.println("Pattern found at index: " + result);
            }
        }
    }


/**
 * Approach-3: KMP Algorithm
*/
    class KMPPatternSearch {
        // Function to build LPS (Longest Prefix Suffix) array
        public static int[] computeLPSArray(String pattern) {
            int m = pattern.length();
            int[] lps = new int[m];
            int j = 0; // length of the previous longest prefix suffix
            int i = 1;

            while (i < m) {
                if (pattern.charAt(i) == pattern.charAt(j)) {
                    j++;
                    lps[i] = j;
                    i++;
                } else {
                    if (j != 0) {
                        j = lps[j - 1]; // Backtrack
                    } else {
                        lps[i] = 0;
                        i++;
                    }
                }
            }
            return lps;
        }

        // KMP search function
        public static int KMPSearch(String text, String pattern) {
            int n = text.length();
            int m = pattern.length();

            int[] lps = computeLPSArray(pattern);

            int i = 0; // index for text
            int j = 0; // index for pattern

            while (i < n) {
                if (pattern.charAt(j) == text.charAt(i)) {
                    i++;
                    j++;
                }

                if (j == m) {
                    return i - j; // Pattern found at index i - j
                } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                    if (j != 0) {
                        j = lps[j - 1]; // Use LPS to skip
                    } else {
                        i++;
                    }
                }
            }

            return -1; // Pattern not found
        }

        public static void main(String[] args) {
            String text = "ababcabcabababd";
            String pattern = "ababd";

            int result = KMPSearch(text, pattern);

            if (result == -1) {
                System.out.println("Pattern not found in the text.");
            } else {
                System.out.println("Pattern found at index: " + result);
            }
        }
    }
}
