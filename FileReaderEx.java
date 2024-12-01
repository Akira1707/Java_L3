import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReaderEx {
    public static void main(String[] args) {
        // Указываем путь к файлу
        File file = new File("example.txt");

        try {
            // Создаем объект Scanner для чтения данных из файла
            Scanner scanner = new Scanner(file);

            // Чтение данных из файла
            while (scanner.hasNext()) { // Пока есть данные для чтения
                String word = scanner.next(); // Чтение следующего слова
                System.out.println(word);
            }

            // Закрытие ресурса после использования
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }
    }
}
