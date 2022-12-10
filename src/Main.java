import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Задание
 * У вас имеется текстовый файл text.txt. Посчитайте в этом тексте, как часто встречается каждое слово,
 * затем выведите в отдельный файл result.txt данную информацию. Также, в конец этого файла выведите
 * самое часто встречаемое слово и его частоту.
 */
public class Main {
    public static void main(String[] args) {
        String tempWorldKey ="";
        int tempValue=0;

        ParserText parserText = new ParserText("text.txt");
        parserText.parse();

        Map<String,Integer>  frequency1 = parserText.frequency();
        try(FileWriter fileWriter = new FileWriter("result.txt",true)){

            for(Map.Entry<String,Integer> entry : frequency1.entrySet()){
                String s = String.format("%15s встречается %5d раз \n",entry.getKey(),entry.getValue());
                fileWriter.write(s);
            }

            for(Map.Entry<String,Integer> entry : frequency1.entrySet()){

                if(entry.getValue()>tempValue){
                    tempWorldKey=entry.getKey();
                    tempValue =entry.getValue();
                }
            }
            String maxSrt =String.format("%s самое часто встречаемое слово повторяется %d раз",tempWorldKey,tempValue);
            fileWriter.write(maxSrt);

        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }


    }
}
