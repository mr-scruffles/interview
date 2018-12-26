import java.util.*;

public class StringExamples {

    // Implement an algorithm to determine if a string has all unique characters.
    // What if you cannot use additional data structures?
    public Boolean isUnique(String input) {
        // 0. Count characters. (If no other data structures can be used it can be done with bit mask).
        // 1. Track counts in hash map.
        // 2. If count exceeds 1 then return false.

        if (input == null || input.isEmpty()) return false;
        char[] chars = input.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for(Character c: chars) {
            Integer value = map.get(c);
            if (value == null) {
                map.put(c, 1);
            } else {
                return false;
            }
        }
        return true;
    }

    public Boolean isUniqueBitMask(String input) {
        // 1. Track chars using bit mask.
        // 2. Characters will map to their ASCI/Unicode value.

        if (input == null || input.isEmpty()) return false;
        char[] chars = input.toCharArray();
        long checker = 0;
        for(Character c: chars) {
//            System.out.println(c + " - " + Character.getNumericValue(c) + " - " + (c - 'a') + " - " + ((int)c) );
            if ((checker & (1 << ((int)c))) > 0){
                return false;
            } else {
                checker |= (1 << ((int)c));
            }
        }
        return true;
    }

    // Given two strings, write a method to decide if one is a permutation of the other.
    // "god     " is different from "dog"
    public Boolean isPermutation(String s1, String s2) {
        // Solutions:
        // 1. Sort strings and compare

        // 1. Use data structure to track counts on characters.

        if (s1.length() != s2.length()) return false;
        char[] letters = s1.toCharArray();
        int[] tracker = new int[128];
        for(Character c: letters) {
            tracker[(int)c]++;
        }

        letters = s2.toCharArray();
        for(Character c: letters) {
            tracker[(int)c]--;
            if(tracker[(int)c] < 0) return false;
        }
        return true;
    }

    // Write a method to replace all spaces in a string with %20. Assume that the string
    // has sufficient space at the end to hold the additional characters, and that you
    // are given the true length of the string.
    // EXAMPLE:
    // Input: "Mr John Smith    " 13
    // Ouput: "Mr%20John%20Smith"
    public char[] URLify(String s1, int length) {
        // 1. Parse original string from tail at string length.
        // 2. Start inserting in character array at end.
        // 3. When space is encountered insert %20 and increment counters.

        char[] chars = s1.toCharArray();
        int start = length - 1;
        int insertStart = s1.length() - 1;

        while(start > 0){
            if(chars[start] == ' '){
                chars[insertStart] = '0';
                chars[insertStart-1] = '2';
                chars[insertStart-2] = '%';
                insertStart -= 3;
            } else {
                chars[insertStart] = chars[start];
                insertStart--;
            }
            start--;
        }
        return chars;
    }

    // Given a string, write a function to check if its a permutation of a palindrome. A palindrome
    // is a word or phrase that is the same forwards and backwards. A permutation is a rearrangment of letters.
    // The palindrome does not need to be limited to just dictionary words.

    // EXAMPLE:
    // Input: Tact Coa
    // Output: True (permutations: "taco cat", "actco cta", etc.)
    public Boolean isPalindromePermutation() {
        return false;
    }

    // Given two strings write a function to check if they are one edit or zero edits away.
    //
    // EXAMPLE
    // pale, ple    -> true
    // pales, pale  -> true
    // pale, bale   -> true
    // pale, bae    -> false
    public Boolean isOneAway(String first, String second) {

        // 0. Check string length to determine insert or deletion.
        // 1. If same length then its a replace.
        // 2. Insert/Edit
        //    a. Check which one is longer string. Loop by shorter
        int index1 = 0;
        int index2 = 0;
        Boolean mismatch = false;

        if (Math.abs(first.length() - second.length()) > 1) return false;
        String s1 = first.length() < second.length() ? first: second; // smaller
        String s2 = first.length() < second.length() ? second: first; // bigger

        while(index1 < s1.length() && index2 < s2.length()) {
            if(s1.charAt(index1) != s2.charAt(index2)) {
                if (mismatch) {
                    return false;
                }
                mismatch = true;

                if (s1.length() == s2.length()) {
                    index1++;
                }
            } else {
                index1++;
            }
            index2++;
        }
        return true;
    }

    // Create a method to perform basic string compression using the counts of the repeated characters.
    // For example, the string aabcccccaa would become a2b1c5a3. If the compressed string would not
    // become smaller than the original string, your method should return the original string. You
    // can assume the string has only uppercase and lower case letters. (a-z)
    public String compressString(String s1){
        // 0. Track first character.
        // 1. Spin through string tracking counts for tracked character.
        // 2. Build string once new character is encountered.

        if (s1 == null) return null;
        if (s1.isEmpty()) return s1;
        int index = 0;
        int count = 0;
        char tracked = s1.charAt(index);
        StringBuilder output = new StringBuilder();
        while (index < s1.length()) {
            if (s1.charAt(index) == tracked) {
                count++;
            } else {
                output.append(tracked);
                output.append(count);
                tracked = s1.charAt(index);
                count = 1;
            }
            index++;
        }
        output.append(tracked);
        output.append(count);

        String result = output.toString();

        return (result.length() > s1.length()) ? s1 : result;
    }

    // Write an algorithm such that if an element in an MxN matrix is 0, its
    // entire row and column are set to zero.
    public int[][] zeroMatrix(int[][] matrix) {
        // 0. Take inner matrix and look for 0's.
        // 1. For every row and column where a 0 is found, insert a 0 in the 0th row and column to mark it.
        // 2. Do a pass on X 0'ing out all the rows.
        // 3. Do a pass on Y 0'ing out all the columns.

        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        for(int i =1; i < rowLength; i++) {
            for(int j = 1; j < colLength; j++){
                if( matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < rowLength; i++){
            if(matrix[i][0] == 0) {
                for (int j = 1; j < colLength; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for(int i = 1; i < colLength; i++){
            if(matrix[0][i] == 0) {
                for (int j = 1; j < rowLength; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        if(matrix[0][0] == 0){
            for(int i = 0; i < colLength; i++){
                matrix[0][i] = 0;
            }

            for(int i = 1; i < rowLength; i++){
                matrix[i][0] = 0;
            }
        }
       return matrix;
    }

    // Write a method to check if s2 is a rotation of s1.
    // e.g  waterbottle is a rotation of erbottlewat
    public Boolean isRotation(String s1, String s2) {

        if (s1.length() > 0 && s1.length() == s2.length()){
            String combine = s2+s2;
            return combine.contains(s1);
        }

        return false;

    }


    public char[] reverseString(char[] input) {
        // 1. mark start and end of string.
        // 2. move inward swapping
        // 3. end when left and right markers cross

        int start = 0;
        int end = input.length - 1;

        while (start < end) {
            char tmp = input[start];
            input[start] = input[end];
            input[end] = tmp;
            start++;
            end--;
        }

        return input;
    }

    public List<String> wordWrap(String text, int width) {

        int count = 0;

        List<String> output = new ArrayList<String>();
        StringBuilder chunk = new StringBuilder();

        String[] tokens = text.split(" ");

        for (String token : tokens) {

            count += token.length();
            if(token.length() <= width) {
                if(count <= width) {
                    chunk.append(token);
                } else {
                    if(chunk.length() > 0) {
                        chunk.setLength(chunk.length() - 1);
                        output.add(chunk.toString());
                        chunk.setLength(0);
                    }
                    chunk.append(token);
                    count = token.length();
                }
                chunk.append(" ");
                count++;
            } else {
                if(chunk.length() > 0) {
                    chunk.setLength(chunk.length() - 1);
                    output.add(chunk.toString());
                    chunk.setLength(0);
                }
                output.add(token);
            }
        }

        if(chunk.length() > 0) {
            chunk.setLength(chunk.length() - 1);
            output.add(chunk.toString());
        }

        return output;
    }

    public List<String> wordWrapa(String text, int width) {

        int count = 0;

        List<String> output = new ArrayList<String>();
        StringBuilder chunk = new StringBuilder();

        String[] tokens = text.split(" ");

        for (String token : tokens) {

            count += token.length();

            // If we have a chunk and the current token is larger than our limit
            // or the current chunk char count is larger than our limit we should
            // append this and reset chunk.
            if (chunk.length() > 0 && (token.length() > width || count > width) ) {
                // Remove added space.
                chunk.setLength(chunk.length() - 1);
                output.add(chunk.toString());
                chunk.setLength(0);
            }

            // If we are dealing with larger tokens than our limit we should just append.
            if(token.length() <= width) {
                if(count > width) {
                    count = token.length();
                }
                chunk.append(token);
                chunk.append(" ");
                count++;
            } else {
                output.add(token);
            }
        }

        if(chunk.length() > 0) {
            // Remove added space.
            chunk.setLength(chunk.length() - 1);
            output.add(chunk.toString());
        }
        return output;
    }

    public String parseCodea(String input) {
        Scanner sc = new Scanner(input);

        StringBuilder chunk = new StringBuilder();
        boolean isMultiLine = false;
        while(sc.hasNextLine()) {
            String line = sc.nextLine().trim();

            int start = 0;
            int end = 0;

            start = line.indexOf("/*");
            if(start >= 0) {
                chunk.append("/*");

                end = line.indexOf("*/");
                if(end >= 0){
                    chunk.append(line.substring(start+2, end).trim());
                    chunk.append("*/");
                } else {
                    chunk.append(line.substring(start+2, line.length()).trim());
                    isMultiLine = true;
                }

                chunk.append('\n');
            } else {
                if(isMultiLine) {
                    end = line.indexOf("*/");
                    if(end >= 0) {
                        chunk.append(line.substring(0, end).trim());
                        chunk.append("*/");
                        isMultiLine = false;
                    } else {
                        chunk.append(line.substring(0, line.length()).trim());
                    }
                    chunk.append('\n');
                } else {
                    start = line.indexOf("//");
                    if(start >= 0) {
                        chunk.append("//");
                        chunk.append(line.substring(start+2, line.length()).trim());
                        chunk.append('\n');
                    }
                }
            }



        }
        chunk.setLength(chunk.length() - 1);
        System.out.println(chunk.toString());

        return null;
    }

    public String parseCode(String input) {
        // comment before multiline /*This is a program to calculate area of a circle after getting the radius as input from the user*/
        Scanner sc = new Scanner(input);

        StringBuilder chunk = new StringBuilder();
        boolean isMultiLine = false;
        while(sc.hasNextLine()) {
            String line = sc.nextLine().trim();

            int start = 0;
            int end;

            int singleLineIdx = line.indexOf("//");
            int multiLineIdx = line.indexOf("/*");

            boolean isSingleLineComment = false;
            boolean isMultiLineComment = false;

            if(multiLineIdx >= 0 && singleLineIdx >= 0){
                if(singleLineIdx < multiLineIdx) isSingleLineComment = true;
                if(multiLineIdx < singleLineIdx) isMultiLineComment = true;
            } else {
                if(singleLineIdx >=0) isSingleLineComment = true;
                if(multiLineIdx >=0) isMultiLineComment = true;
            }

            if(isSingleLineComment) start = singleLineIdx;
            if(isMultiLineComment) start = multiLineIdx;

            if(isSingleLineComment) {
                chunk.append("//");
                chunk.append(line.substring(start+2, line.length()));
                chunk.append('\n');
            } else if(isMultiLine) {
                if( (end = line.indexOf("*/")) >= 0) {
                    chunk.append(line.substring(start, end));
                    chunk.append("*/");
                    isMultiLine = false;
                } else {
                    chunk.append(line.substring(start, line.length()));
                }
                chunk.append('\n');
            } else if(isMultiLineComment){
                chunk.append("/*");
                if( (end = line.indexOf("*/")) >= 0){
                    chunk.append(line.substring(start+2, end));
                    chunk.append("*/");
                } else {
                    chunk.append(line.substring(start+2, line.length()));
                    isMultiLine = true;
                }
                chunk.append('\n');
            }
        }
        chunk.setLength(chunk.length() - 1);
        System.out.println(chunk.toString());

        return null;
    }

}
