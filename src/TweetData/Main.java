package TweetData; /**
 * From the list of twitter tweets .txt extract the hashtags
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String [] args) {
        BufferedReader bufferedReader = null;
        String filename = "src/TweetData/TweetData.txt";
        String line = "";
        List <String> hashtags = new ArrayList<>();

        try {
            bufferedReader = new BufferedReader(new FileReader(filename));

            while ((line = bufferedReader.readLine()) != null) {
                String [] words = line.split(" ");
                for (String s : words){
                    if (s.contains("#")){
                        /**when start of the string is not # remove it
                         * ^start of the string; [^#]* not hashtag
                         */
                        s.replaceAll("^[^#]*", "");

                        //ignore repeating hashtags
                        if (!hashtags.contains(s)){
                            hashtags.add(s);
                        }
                    }
                }
            }
            hashtags.sort(String::compareTo);
            for(String s : hashtags){
                System.out.println(s);
            }
            System.out.println("Number of unique hashtags: " + hashtags.size());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try{
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }
}
