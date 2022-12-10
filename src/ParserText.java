import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class ParserText implements Parser {
    private String fileName;
    private Map<String, Integer> wordsDictionary;

    public ParserText(String fileName) {
        this.fileName = fileName;
        this.wordsDictionary = new TreeMap<>();
    }

    public Map<String,Integer> frequency() {return wordsDictionary ;}

    @Override
    public void parse() {
        if (!wordsDictionary.isEmpty()) {
            return;
        }

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String str = null;


            while( (str= bufferedReader.readLine()) != null){
                String[] words = str.split("[^A-Za-z]+");
                for(String word : words) {
                    if (!word.equals("")) {
                        String wordLowerCase = word.toLowerCase();


                        if (wordsDictionary.get(wordLowerCase) == null ){
                            wordsDictionary.put(wordLowerCase,1);
                        }else {
                            int oldFrequency = wordsDictionary.get(wordLowerCase);
                            wordsDictionary.replace(wordLowerCase,oldFrequency+1);
                        }
                    }
                }
            }

        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
