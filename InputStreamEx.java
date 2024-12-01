import java.io.FileInputStream;
import java.io.IOException;

public class InputStreamEx {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("example.txt")) {
            int byteData;
            // Чтение байтов из файла до конца
            while ((byteData = fis.read()) != -1) {
                System.out.print((char) byteData); // Преобразование байта в символ
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
