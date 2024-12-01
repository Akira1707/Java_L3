import java.util.Formatter;

public class FormatterEx1 {
    public static void main(String[] args) {
        Formatter formatter = new Formatter();

        // Пример с использованием спецификаторов
        boolean boolValue = true;
        char charValue = 'A';
        int intValue = 123;
        double doubleValue = 3.14159;
        String stringValue = "Hello, world!";
        
        // Логическое значение
        formatter.format("Boolean value: %b%n", boolValue);
        
        // Символьное представление
        formatter.format("Character value: %c%n", charValue);
        
        // Десятичное целое значение
        formatter.format("Integer value: %d%n", intValue);
        
        // Десятичное значение с плавающей точкой
        formatter.format("Floating point value: %f%n", doubleValue);
        
        // Строковое представление
        formatter.format("String value: %s%n", stringValue);

        // Вывод
        System.out.println(formatter.toString());
        
        // Закрытие formatter
        formatter.close();
    }
}
