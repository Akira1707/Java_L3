public class  Overloaded{
    public static void main(String[] args) {
        // Перегруженный оператор + для строк
        String str1 = "Hello, ";
        String str2 = "World!";
        String result = str1 + str2; // Результат: "Hello, World!"
        
        // Сложение строки и числа
        String result2 = "Number: " + 123; // Результат: "Number: 123"
        
        System.out.println(result);
        System.out.println(result2);
    }
}
