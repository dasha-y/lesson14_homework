import java.io.FileReader;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {

        String longestWord = " ";
        try (FileReader fr = new FileReader( "Romeo and Juliet.txt" )) {
            StringBuilder word = new StringBuilder();
            int ch = fr.read();
            while (ch != -1) {
                if(Character.isLetter(ch)){
                    word.append((char) ch);
                }
                else {
                    if (longestWord.length() < word.length()) {
                        longestWord = word.toString();
                    }
                    word.setLength(0);
                }
                ch = fr.read();
            }
        } catch (Exception e) {
            e.printStackTrace() ;
        }
        try (FileWriter fw = new FileWriter( "NewFile.txt" )) {
            fw.write( longestWord );
            fw.flush() ;
        } catch (Exception e) {
            e.printStackTrace() ;
        }
    }
}