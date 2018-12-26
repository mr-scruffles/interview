import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Map.Entry;
import java.util.Set;
import java.util.List;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by ryan on 8/9/17.
 */
public class Alice {

    public void printFile(){

        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("/home/ryan/interview/alice/resources/alice.txt")));
            String line;
            int count = 0;
            String out = new String();
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println(out);
            System.out.println("Count: " + count);
            reader.close();
        } catch(Exception e) {
            System.out.println(e.toString());
        }
    }

    public void printFileByChar() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("/home/ryan/interview/alice/resources/alice.txt")));
            int elem;
            StringBuilder builder = new StringBuilder();
            while((elem = reader.read()) != -1) {
                builder.append((char)elem);
            }
            System.out.println(builder.toString());
            reader.close();
        } catch(Exception e) {
            System.out.println(e.toString());
        }
    }

    public void printFileByTokens() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("/home/ryan/interview/alice/resources/alice.txt")));
            String line;
            while((line = reader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line);
                while (st.hasMoreTokens()) {
                    System.out.println(st.nextToken());
                }
            }
            reader.close();
        } catch(Exception e) {
            System.out.println(e.toString());
        }
    }

    public void tenMostUsedWords() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("/home/ryan/interview/alice/resources/alice.txt")));
            String line;

            HashMap<String, Integer> freqTable = new HashMap<>();
            while((line = reader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line);
                while (st.hasMoreTokens()) {

                    String token = st.nextToken();
                    if (freqTable.containsKey(token)) {
                        Integer value = freqTable.get(token);
                        freqTable.put(token, ++value);
                    } else {
                        freqTable.put(token, 1);
                    }
                }
            }

            Set<Entry<String,Integer>> mapEntries = freqTable.entrySet();
            List<Entry<String,Integer>> listEntries = new LinkedList<Entry<String,Integer>>(mapEntries);
            Collections.sort(listEntries, new Comparator<Entry<String,Integer>>() {
                @Override
                public int compare(Entry<String, Integer> ele1, Entry<String, Integer> ele2) {
                    return ele2.getValue().compareTo(ele1.getValue());
                }
            });

            //System.out.println(freqTable);
//            for(Entry entry: listEntries) {
//
//                System.out.println(entry.getKey() + " -- " + entry.getValue());
//            }

            for(int i=0; i < 10; i++) {
                System.out.println(listEntries.get(i).getKey());
            }

        } catch(Exception e) {
            System.out.println(e.toString());
        }
    }
}
