import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        StringExamples example = new StringExamples();
        // isUnique Test

//        System.out.println("TESTING: isUnique");
//        // Expect False
//        System.out.println("aab: " + example.isUnique("aab"));
//        // Expect True
//        System.out.println("abc: " + example.isUnique("abc"));
//        // Expect False
//        System.out.println("null: " + example.isUnique(null));
//        // Expect False
//        System.out.println("<empty string>: " + example.isUnique(""));
//        System.out.print("\n\n\n");
//
//        System.out.println("TESTING: isUniqueBitMask");
//        // Expect False
//        System.out.println("Aabc: " + example.isUniqueBitMask("Aabc"));
//        // Expect False
//        System.out.println("&$#&: " + example.isUniqueBitMask("&$#&"));
//        // Expect True
//        System.out.println("abc: " + example.isUniqueBitMask("abc"));
//        // Expect False
//        System.out.println("null: " + example.isUniqueBitMask(null));
//        // Expect False
//        System.out.println("<empty string>: " + example.isUniqueBitMask(""));
//        System.out.print("\n\n\n");

//        System.out.println("TESTING: isPermutation");
//        // Expect false
//        System.out.println("'test' - 'bob': " + example.isPermutation("test", "bob"));
//        // Expect false
//        System.out.println("'test' - 'bobs': " + example.isPermutation("test", "bobs"));
//        // Expect true
//        System.out.println("'test' - 'tste': " + example.isPermutation("test", "tste"));
//        // Expect true
//        System.out.println("'    test' - 'tste': " + example.isPermutation("    test", "tste"));
//        System.out.print("\n\n\n")

//        System.out.println("TESTING: URLify");
//        // Expect "Mr%20John%20Smith"
//        System.out.print("'Mr John Smith    ' -> ");
//        System.out.println(example.URLify("Mr John Smith    ", 13));
//
//        // Expect "Mr%20John%20Smith"
//        System.out.print("'Mr John  Smith bobber    ' -> ");
//        System.out.println(example.URLify("Mr John  Smith bobber        ", 21));
//        System.out.print("\n\n\n");


//        // Expect true
//        System.out.println("`pale`  - `ple` : " + example.isOneAway("pale", "ple"));
//        // Expect true
//        System.out.println("`pales` - `pale`: " + example.isOneAway("pales", "pale"));
//        // Expect true
//        System.out.println("`pale`  - `bale`: " + example.isOneAway("pale", "bale"));
//        // Expect false
//        System.out.println("`pale`  - `bae` : " + example.isOneAway("pale", "bae"));
//        System.out.print("\n\n\n");

//        // Expect aabcccccaaa -> a2b1c5a3
//        System.out.println("aabcccccaaa -> a2b1c5a3 : " + example.compressString("aabcccccaaa"));
//        // Expect null -> null
//        System.out.println("null -> null            : " + example.compressString(null));
//        // Expect empty -> empty
//        System.out.println("'' -> ''                : " + example.compressString(""));
//        // Expect aaa -> a3
//        System.out.println("aaa -> a3               : " + example.compressString("aaa"));
//        // Expect a -> a
//        System.out.println("a -> a                  : " + example.compressString("a"));
//        System.out.print("\n\n\n");

//        int[][] matrix5x5 = {
//                {0, 1, 1, 0 ,1},
//                {1, 1, 0, 1, 1},
//                {1, 1, 1, 1 ,0},
//                {1, 1, 1, 0 ,1},
//                {1, 1, 1, 1 ,1},
//        };
//        printMatrix(matrix5x5);
//        int[][] result5x5 = example.zeroMatrix(matrix5x5);
//        printMatrix(result5x5);
//
//
//        int[][] matrix2x2 = {
//                {1, 1},
//                {1, 0},
//        };
//        printMatrix(matrix2x2);
//        int[][] result2x2 = example.zeroMatrix(matrix2x2);
//        printMatrix(result2x2);
//
//
//        int[][] matrix1x2 = {
//                {1, 0},
//        };
//        printMatrix(matrix1x2);
//        int[][] result1x2 = example.zeroMatrix(matrix1x2);
//        printMatrix(result1x2);
//        System.out.print("\n\n\n");

//        // Expect True
//        // e.g  s1:erbottlewat is rotation of s2:waterbottle
//        System.out.println("erbottlewat -> waterbottle: " + example.isRotation("erbottlewat","waterbottle"));
//
//        char[] input = {'a', 'b', 'c', 'd'};
//        System.out.println(example.reverseString(input));

//        ArrayList<ArrayList> test = new ArrayList();
//        test.add(new ArrayList());
//        test.get(0).add(7);
//        test.add(new ArrayList());
//
//
//        System.out.println(test.get(0));
//
//
//        ArrayList<Integer> one = new ArrayList();
//        one.add(6);
//        System.out.println(one);

//        String input = "The quick brown fox jumps over the hole.";
//        List<String> ouput = example.wordWrapa("", 10);
//        System.out.println(ouput);

        String input = "/*This is a program to calculate area of a circle after getting the radius as input from the user*/  \n" +
                "#include <stdio.h>\n" +
                "int main()  \n" +
                "{  \n" +
                "   double radius,area;//variables for storing radius and area  \n" +
                "   printf(\"Enter the radius of the circle whose area is to be calculated\\n\");  \n" +
                "   scanf(\"%lf\",&radius);//entering the value for radius of the circle as float data type  \n" +
                "   area=(22.0/7.0)*pow(radius,2);//Mathematical function pow is used to calculate square of radius  \n" +
                "   printf(\"The area of the circle is %lf\",area);//displaying the results  \n" +
                "}  \n" +
                "/*A test run for the program was carried out and following output was observed  \n" +
                "If 50 is the radius of the circle whose area is to be calculated\n" +
                "The area of the circle is 7857.1429*/";


        String input2 = "// comment before multiline /*This is a program to calculate area of a circle after getting the radius as input from the user*/  // test me\n" +
                "#include <stdio.h>\n" +
                "int main()  \n" +
                "{  \n" +
                "   double radius,area;//variables for storing radius and area  \n" +
                "   printf(\"Enter the radius of the circle whose area is to be calculated\\n\");  \n" +
                "   scanf(\"%lf\",&radius);//   entering the value for radius of the circle as float data type              \n" +
                "   area=(22.0/7.0)*pow(radius,2);//Mathematical function pow is used to calculate square of radius  \n" +
                "   printf(\"The area of the circle is %lf\",area);//displaying the results  \n" +
                "}  \n" +
                "/*A test run for the program was carried out and following output was observed  \n" +
                "If 50 is the radius of the circle whose area is to be calculated\n" +
                "The area of the circle is 7857.1429*/";
        example.parseCode(input2);

    }

    public static void printMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
