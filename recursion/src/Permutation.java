/**
 * Created by ryan on 8/22/17.
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Permutation {


    public static void permuteWords(String[][] input, ArrayList<String[]> output, int currDigit, String[] temp) {

        if(currDigit == input.length) {
            output.add(Arrays.copyOf(temp, temp.length));
            return;
        }

        for(int wordIndex=0; wordIndex < input[currDigit].length; wordIndex++) {
            temp[currDigit] = input[currDigit][wordIndex];
            permuteWords(input, output, currDigit + 1, temp);
        }
    }
    public static void main(String[] args) {


        String[][] input = {{"bob", "alice"}, {"stay","cold","today"}};
        ArrayList<String[]> output = new ArrayList<String[]>();
        String[] temp = new String[input.length];
        permuteWords(input, output, 0, temp);
        for(String[] item : output ) {
            String out = String.format("%s and julie decided to %s", item[0], item[1]);
            System.out.println(out);
        }
    }
}


/*
// package whatever; // don't place package name!

// Given a string of characters, generate all possible permutations of strings
// using those characters.
// Eg. (“abc”) would result in (“abc”, “acb”, “bac”, “bca”, “cab”, “cba”).

import java.io.*;
import java.util.*;

class myCode
{


    public static void main (String[] args) throws java.lang.Exception
    {

        String input = null;
        for(String elem : permute(input)) {
            System.out.println(elem);
        }

    }

    public static List<String> permute(String input) {
        List<String> output = new ArrayList<>();

        if(input == null || input.length() == 0) return output;
        boolean[] isUsed = new boolean[input.length()];
        StringBuilder sb = new StringBuilder();

        permuteHelper(input, isUsed, sb, output);

        return output;
    }

    public static void permuteHelper(String input, boolean[] isUsed, StringBuilder sb, List<String> output) {

        if(sb.length() == input.length()) {
            output.add(sb.toString());
            return;
        }

        for(int i=0; i < input.length(); i++) {
            if(isUsed[i]) continue;
            sb.append(input.charAt(i));
            isUsed[i] = true;
            permuteHelper(input, isUsed, sb, output);
            isUsed[i] = false;
            sb.setLength(sb.length() - 1);
        }
    }


}

 */