import java.util.HashMap;

public class PermPhoneAndWords {

    public static void main(String[] args) {
        String input = "0123456789";
        // Dont let len be confusing. Its just to limit the permutations.
        // There are a ton of permutations so its hard to debug if your constantly
        // trying to permute 10 number combinations. So the length is just a way
        // to limit that to make it simpler. But ideally the length should be the
        // same length as the number possibilites (10 numbers in this case 0-9)
        Permute perm = new Permute(input, 10);
        perm.permute();
    }
}

class Permute {

    private String number;
    private StringBuilder numberBuilder;
    private String wordNumber;
    private StringBuilder wordNumberBuilder;

    private int len;

    private HashMap<Integer, String> keyMap;

    public Permute(String input, int len) {
        this.number = input;
        this.len = len;

        this.keyMap = new HashMap<>();
        this.keyMap.put(2, "ABC");
        this.keyMap.put(3, "DEF");
        this.keyMap.put(4, "GHI");
        this.keyMap.put(5, "JKL");
        this.keyMap.put(6, "MNO");
        this.keyMap.put(7, "PQRS");
        this.keyMap.put(8, "TUV");
        this.keyMap.put(9, "WXYZ");
    }

    private Character getKeyChar(int key, int pos) {

        if(!this.keyMap.containsKey(key)) return null;
        String values = this.keyMap.get(key);
        if(values.length() == 0 ) return null;

        return values.charAt(pos);
    }

    public void permute() {
        this.numberBuilder = new StringBuilder();
        permuteNumber();
    }


    public void permuteNumber() {

        if(this.numberBuilder.length() == this.len) {
            permuteWords(this.numberBuilder.toString());
            return;
        }

        // Ignore 1 or 0 if its the first number.
        // Loop over each number spot and pick a number. The magic starts as it
        // reaches end of first loop and starts rolling back.
        for(int i = 0; i < this.len; i++) {
            if(this.numberBuilder.length() == 0 && (this.number.charAt(i) == '1' || this.number.charAt(i) == '0') ) continue;
            this.numberBuilder.append(this.number.charAt(i));
            permuteNumber();
            this.numberBuilder.setLength(this.numberBuilder.length() - 1);
        }
    }

    public void permuteWords(String number) {
        this.wordNumber = number;
        this.wordNumberBuilder = new StringBuilder();
        permuteWordsHelper(0);
    }

    public void permuteWordsHelper(int digitIndex) {

        // If we have built a number equal to the length of our input
        // then print.
        if(this.wordNumberBuilder.length() == this.wordNumber.length()) {
            String formattedNumber = formatWordNumber(this.wordNumber);
            System.out.println(formattedNumber + " " + this.wordNumberBuilder);
            return;
        }

        // convert string value to number value.
        int keyNum = Character.getNumericValue(this.wordNumber.charAt(digitIndex));
        // Get the length of the letters for a given key. This will be our looping limit
        // as we are looping over each character creating combinations for that number.
        int len = this.keyMap.getOrDefault(keyNum, "").length();

        // If key number is 1 or 0 just add 1 or 0 and permute like any other key.
        if(keyNum == 1 || keyNum == 0) {
            this.wordNumberBuilder.append(keyNum);
            permuteWordsHelper(digitIndex + 1);
            this.wordNumberBuilder.setLength(this.wordNumberBuilder.length() - 1);
        } else {
            // for a given key iterate over the letters 1 by 1 appending and backtracking.
            // this process is identical to the number permutation above. The digit index
            // is just the index value of the string input number we are evaluating.
            for (int i = 0; i < len; i++) {
                this.wordNumberBuilder.append(getKeyChar(keyNum, i));
                permuteWordsHelper(digitIndex + 1);
                this.wordNumberBuilder.setLength(this.wordNumberBuilder.length() - 1);
            }
        }
    }

    // Just make the string look pretty with spaces.
    private String formatWordNumber(String number) {

        StringBuilder sb = new StringBuilder();

        for(int i =0; i < number.length(); i++) {
            if(i == 3) sb.append(" ");
            if(i == 6) sb.append(" ");
            sb.append(number.charAt(i));
        }
        return sb.toString();
    }
}
