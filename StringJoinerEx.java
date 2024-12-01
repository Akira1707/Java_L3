import java.util.StringJoiner;

public class StringJoinerEx {
    public static void main(String[] args) {
        // Пример 1: Простое соединение строк с разделителем
        StringJoiner joiner1 = new StringJoiner(", ");
        joiner1.add("Apple");
        joiner1.add("Banana");
        joiner1.add("Cherry");
        System.out.println(joiner1.toString()); // "Apple, Banana, Cherry"
        
        // Пример 2: Использование префикса и суффикса
        StringJoiner joiner2 = new StringJoiner(", ", "Fruits: ", ".");
        joiner2.add("Apple");
        joiner2.add("Banana");
        joiner2.add("Cherry");
        System.out.println(joiner2.toString()); // "Fruits: Apple, Banana, Cherry."
    }
}
