package _08_basic_string;

public class _00_string_algorithm {
    /**
     * String in Java:
     * - Group of characters is called a string.
     * - In Java, Strings are in the form of class, so it has its in-built
     *   functions.
     * 
     * Character Array Example:
     * - Suppose humne ek array banaya aur uss array mai hum chars ko store
     *   kar rhe hai:
     *   ['P', 'R', 'A', 'T', 'E', 'E', 'K']
     * - Lekin avi ye ek string nahi hai, sirf ek char array hai. 
     * 
     * How String is different?
     * - String ko banane k liye sbse pehle humein ek terminator bnana padega
     *   jo batata hai ki string kaha khatam ho rha hai.
     * 
     * - Aisa isliye krte hai kyuki java mai array ki length fix hoti hai
     *   (kaha se kaha tak hoti hai taaki hum loop k through saare index ko 
     *   access kar sakte hai), but string is different. 
     * 
     * Real World Example:
     * - Suppose humne n-size ka array banaya ho aur ho sakta hai: 
     *   - kisi k name m 7 chars ho, 
     *   - kisi k name m 5 chars ho.
     *  
     * - To sabke name ki length alag alag hogi. 
     * - Jab hum user se name insert karwaenge to ye to puchnge nhi ki aapke
     *   name m kitne chars hai. 
     *   
     * Solution - String Terminator:
     * - To kya tarika haga? 
     * - Hum koi aisa symbol laga de end mai jisse humein pta chal jae ki 
     *   name kaha par khatm ho rha hai ya fir humari string kaha khtm hui 
     *   hai i.e. \0, called null character (terminator).
     * - Example:
     *   ['P', 'R', 'A', 'T', 'E', 'E', 'K', '\0']
     * 
     * - But when we use String, we don't need to add terminator. It is 
     *   automatically handled by Java. We only have to use double quotes.
     * - Example:
     *   "PRATEEK"
    */

    /**
     *  
     * - Character vs String in Java:
     *   - Single quotes ('a')   -> Single character
     *   - Double quotes ("abc") -> String object
     * 
     * - Manual vs Automatic Terminator:
     *   1. Manual (Char Array): Must explicitly add '\0' at end
     *      char[] arr = {'P', 'r', 'a', 't', 'e', 'e', 'k', '\0'};
     * 
     *   2. Automatic (String): Java automatically handles termination
     *      String str = "Prateek";
     * 
     * - Example Comparison:
     *   Manual: ['P', 'r', 'a', 't', 'e', 'e', 'k', '\0'] => Explicit '\0'
     *   Auto  :  "Prateek"                                => Implicit termination
     * 
     * Note: In modern Java, using String is preferred as it handles
     *       termination automatically and provides built-in methods
    */

/**
 * Java mein String banane ke 2 tarike
 * 1. Using String Literal
 * 2. Using 'new' keyword
*/

/**
 * 1. String Literal (Recommended)
 *    > String str = "Hello";
 *
 *    What happens:
 *    a. String Constant Pool (SCP) - a special memory area inside heap 
 *       memory - is checked.
 *    b. Agar "Hello" pool mein already hai:
 *       > Java wahi existing string reuse kar lega.
 *       Agar nahi hai to:
 *       > Naya string pool mein store karega.
 *
 *    Address comparison (example):
 *      String s1 = "Hello"; => pool mein naya string (agar pehli baar)
 *      String s2 = "Hello"; => same pool value reuse hogi
 *      => s1 == s2          => true (same reference in SCP)
 *
 *    Content comparison (example):
 *      if (s1.equals(s2)) { ... } => true — values same hain
 *
 *    Why prefer karein:
 *      - Memory efficient (same value reuse hota hai)
 *      - Fast and recommended for normal use
 * 
 * 2. 'new' Keyword
 *    > String str = new String("Hello");
 *
 *    What happens:
 *      1. 'new' hamesha heap memory mein naya object banata hai.
 *      2. Ye SCP ko ignore karta hai (even agar SCP mein same value ho).
 *      3. Garbage Collector is heap object ko manage karta hai.
 *
 *    Address comparison (example):
 *      String s3 = new String("Hello");
 *      String s4 = new String("Hello");
 *      if (s3 == s4) { ... } => false — different objects (different references)
 *
 *    Content comparison (example):
 *      if (s3.equals(s4)) { ... } => true — content same hai
 *
 * Note: Jab v humein string comparison karna hai we will use 'equals()'
 *       method instead of '==' operator, because '==' operator checks for
 *       for address but we want to check for content.
 */


    class StringTesting {
        public static void main(String[] args) {
            String s1 = "Prateek";
            String s2 = "Prateek";

            String s3 = new String("Prateek");
            String s4 = new String("Prateek");


            /**
             * Address Comparison:
            */
            if(s1 == s2) {
                System.out.println("s1 and s2 are the same object");
            } else {
                System.out.println("s1 and s2 are different objects");
            }

            if(s3 == s4) {
                System.out.println("s3 and s4 are the same object");
            } else {
                System.out.println("s3 and s4 are different objects");
            }

            /**
             * Content Comparison: Check char-by-char content (recommended)
            */
            if(s1.equals(s2)) {
                System.out.println("s1 and s2 are the same content");
            } else {
                System.out.println("s1 and s2 are different content");
            }

            if(s3.equals(s4)) {
                System.out.println("s3 and s4 are the same content");
            } else {
                System.out.println("s3 and s4 are different content");
            }
        }
    }


/**
 * Immutable String Class in Java: (Changes address)
 * - Immutable means wo string ko change nahi karta, wo apni address ko
 *   change kar deta hai jaha new content hai.
 *   str : 100x -> 200x (change address, not content)
 * - 100x: hello        (old address)
 *   200x: hello world  (new address)
 * 
 * Proving String Immutability using hashCode():
 * 1. What is hashCode?
 *    > A unique integer value generated for each object
 *    > Same content = Same hashCode
 *    > Different content = Different hashCode
 * 
 * 2. Our Test:
 *    a. Create a String "Java" and get its hashCode
 *    b. Try to "modify" it to "Java Programming"
 *    c. Get hashCode of modified String
 * 
 *   String s1 = "Java";
 *   System.out.println(s1.hashCode());   => e.g. 2301506
 *
 *   s1 = s1 + " Programming";            => creates a new object
 *   System.out.println(s1.hashCode());   => e.g. 1395333309
 *
 *   Notice: hashCode change ho gaya => new String object bana hai
 * 
 * 3. What this proves:
 *    a. If String was mutable, modifying it would keep same hashCode
 *    b. Different hashCode shows a new String object was created
 *    c. Original String remained unchanged (immutable)
*/
    class ImmutableString {
        public static void main(String[] args) {
            String s1 = "Java";
            System.out.println(s1.hashCode()); // HashCode of original String

            s1 = s1 + " Programming";          // Creates new String object
            System.out.println(s1.hashCode()); // Different hashCode proves new object creation
        }
    }

/**
 * Mutable String Class in Java: (Changes content)
 * - Mutable means wo string ko change kar deta hai, wo apni content ko
 *   change kar deta hai jaha new content hai.
 * - To modifiy the content of the string, we have two classes:
 *   a. StringBuffer (thread safe)
 *      > Means if multiple threads try to update a string at the same time,
 *        only one thread can update it at once.
 *      > If we are using concept of multithreading, then we should use
 *        StringBuffer to make our code thread safe and data will not
 *        get corrupted. And because of this, we might see some slow down
 *        in the performance.
 *   b. StringBuilder (not thread safe)
 *      > When we are not using concept of multithreading, and need fast
 *        execution, then we should use StringBuilder.
*/

    class MutableString {
        public static void main(String[] args) {

            StringBuffer sb = new StringBuffer("Hello");
            System.out.println(sb.hashCode());

            sb.append(" World");
            System.out.println(sb.hashCode());


            StringBuilder sb2 = new StringBuilder("Hello");
            System.out.println(sb2.hashCode());

            sb2.append(" World");
            System.out.println(sb2.hashCode());
        }
    }

}
