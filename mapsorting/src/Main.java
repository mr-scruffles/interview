/*
=begin
Given a phrase, calculate freq of occurrence of each letter
display sorted order by frequency, and alphabetically if the frequency is the same


mama mia

a - 3
m - 3
i - 1
=end
*/

import java.util.*;
public class Main {

    public static void main(String[] arg) {


        frequency("i  lOve YOu  ");
    }

    public static void frequency(String input) {

        HashMap<Character,Integer> map = new HashMap<Character, Integer>();

        for(int i=0; i < input.length(); i++) {

            Character charr = Character.toLowerCase(input.charAt(i));

            if(Character.isLetter(charr)) {
                if(map.containsKey(charr)) {
                    int count = map.get(charr);
                    count++;
                    map.put(charr, count);
                } else {
                    map.put(charr, 1);
                }
            }
        }

        ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort( new Comparator<Map.Entry<Character, Integer>>() {
                    public int compare( Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2 )
                    {
                        return o1.getValue().equals(o2.getValue()) ?
                                o1.getKey().compareTo(o2.getKey()) : o2.getValue().compareTo(o1.getValue());
                    }
                }
        );

        System.out.println(list);

    }
}

//import java.io.*;
//import java.util.*;
//public class Solution {
//    public static void main(String args[] ) throws Exception {
//        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
//
//        Scanner sc = new Scanner(System.in);
//
//        StringBuilder chunk = new StringBuilder();
//
//        while(sc.hasNextLine()) {
//            String line = sc.nextLine().trim();
//
//            int start = 0;
//            int end = 0;
//
//            start = line.indexOf("/*");
//            if(start >= 0) {
//                chunk.append("/*");
//
//                end = line.indexOf("*/");
//                if(end >= 0){
//                    chunk.append(line.substring(start+2, end-1).trim());
//                    chunk.append("*/");
//                } else {
//                    chunk.append(line.substring(start+2, line.length()-1).trim());
//                }
//
//                chunk.append('\n');
//            } else {
//                int index = line.indexOf("//");
//                if(index >= 0) {
//                    // found inline comment
//                } else {
//                    chunk.append(line.substring(0, line.length()-1).trim());
//                }
//
//            }
//
//
//            /*
//            if(line.charAt(start) == '/' && line.charAt(start+1) == '*') {
//                chunk.append("/*");
//                while(true) {
//                    if(line.charAt(end+1) == '*' && line.charAt(end+2) == '/') {
//                        chunk.append(line.substring(start+2, end).trim());
//                        chunk.append("*");
//                    }
//
//                    if(end == line.length() -1 ) {
//                        chunk.append(line.substring(start+2, end).trim());
//                        chunk.append('\n');
//                        break;
//                    }
//                    end++;
//                }
//            } else {
//                while(true) {
//                   if(end == line.length() -1 ) {
//                        chunk.append(line.substring(start, end).trim());
//                        chunk.append('\n');
//                        break;
//                    }
//                    end ++;
//                }
//            }
//            */
//        }
//
//        System.out.println(chunk.toString());
//    }
//}