import java.io.FileReader;
import java.io.IOException;

public class AutoCloseableEx {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("example.txt")) {
            int data;
            while ((data = reader.read()) != -1) {
                System.out.print((char) data); // Чтение файла
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
