import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * �������
 * � ��� ������� ��������� ���� text.txt. ���������� � ���� ������, ��� ����� ����������� ������ �����,
 * ����� �������� � ��������� ���� result.txt ������ ����������. �����, � ����� ����� ����� ��������
 * ����� ����� ����������� ����� � ��� �������.
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
                String s = String.format("%15s ����������� %5d ��� \n",entry.getKey(),entry.getValue());
                fileWriter.write(s);
            }

            for(Map.Entry<String,Integer> entry : frequency1.entrySet()){

                if(entry.getValue()>tempValue){
                    tempWorldKey=entry.getKey();
                    tempValue =entry.getValue();
                }
            }
            String maxSrt =String.format("%s ����� ����� ����������� ����� ����������� %d ���",tempWorldKey,tempValue);
            fileWriter.write(maxSrt);

        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }


    }
}
