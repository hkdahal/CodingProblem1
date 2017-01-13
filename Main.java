import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {


    private static String doStuff(String filename) throws FileNotFoundException {

        File srcFile = new File(filename);
        Scanner in = new Scanner(srcFile);

        String theWord = "";
        int highestValue = 0;

        while (in.hasNext()){
            String word = in.next();
            int the_value = commonValue(cleanWord(word));
            if(the_value > highestValue){
                highestValue = the_value;
                theWord = word;
            }
        }

        return theWord;
    }

    private static int commonValue(String word){

        Map<Character, Integer> myDict = new HashMap<>();

        int highest = 1;

        for (int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            if (myDict.containsKey(ch)){
                Integer value = myDict.get(ch) + 1;
                myDict.put(ch, value);
                if (value > highest){
                    highest = value;
                }
            }else{
                myDict.put(ch, 1);
            }
        }

        return highest;
    }


    private static String cleanWord(String word){
        return word.toLowerCase().replaceAll("[^a-z]", "");
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.print("Enter filename: ");

        Scanner in = new Scanner(System.in);
        String filename = in.next();
        System.out.println(doStuff(filename));

    }
}
