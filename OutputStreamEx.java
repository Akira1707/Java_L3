import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStreamEx {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("output.txt")) {
            String text = "Hello, world!";
            for (int i = 0; i < text.length(); i++) {
                fos.write(text.charAt(i)); // Запись одного байта
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
