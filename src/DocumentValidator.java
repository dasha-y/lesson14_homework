import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DocumentValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу: ");
        String path = scanner.nextLine();
        try (FileWriter fileWriterValid = new FileWriter("Valid.txt");
             FileWriter fileWriterInvalid = new FileWriter("Invalid.txt");){
            FileReader fileReader = new FileReader(path);



            Scanner scanner1 = new Scanner(fileReader);
            while (scanner1.hasNextLine()){
                String line = scanner1.nextLine();
                if(validator(line)){
                    fileWriterValid.write(line + " \n");
                } else{
                    fileWriterInvalid.write(line + " " + reason(line) + "\n");
                }
            }
//            fileWriterValid.close();
//            fileWriterInvalid.close();
//            fileReader.close();
//            scanner1.close();

        } catch (IOException e){
            System.out.println("Проблема с файлом: "+ e.getMessage());
        }
        scanner.close();

    }
    public static boolean validator(String number){
        if(number.length() ==15 && (number.startsWith("docnum") || number.startsWith("contract"))){
            return true;
        }
        return false;
    }
    public static String reason(String number){

        if(!number.startsWith("docnum") && !number.startsWith("contract")){
            return  "Не начинается с последовательности docnum или contract";
        }
        if(number.length() != 15){
            return  "Длина не равна 15 символов" ;
        }
        return "Неизвесная причина";
    }
}
