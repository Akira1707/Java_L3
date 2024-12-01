public class StringMethods {
    public static void main(String[] args) {
        String str = "Hello, World!";
        
        // 1. length() — возвращает длину строки
        System.out.println("Длина строки: " + str.length()); // 13
        
        // 2. charAt() — возвращает символ по индексу
        System.out.println("Символ на позиции 1: " + str.charAt(1)); // 'e'
        
        // 3. substring() — возвращает подстроку
        System.out.println("Подстрока (7, 12): " + str.substring(7, 12)); // "World"
        
        // 4. toUpperCase() — преобразует строку в верхний регистр
        System.out.println("Верхний регистр: " + str.toUpperCase()); // "HELLO, WORLD!"
        
        // 5. toLowerCase() — преобразует строку в нижний регистр
        System.out.println("Нижний регистр: " + str.toLowerCase()); // "hello, world!"
        
        // 6. contains() — проверяет, содержится ли подстрока
        System.out.println("Содержит ли 'World'? " + str.contains("World")); // true
        
        // 7. startsWith() — проверяет, начинается ли строка с подстроки
        System.out.println("Начинается ли с 'Hello'? " + str.startsWith("Hello")); // true
        
        // 8. endsWith() — проверяет, заканчивается ли строка подстрокой
        System.out.println("Заканчивается ли на '!': " + str.endsWith("!")); // true
        
        // 9. indexOf() — находит индекс первого вхождения символа или подстроки
        System.out.println("Индекс первого вхождения 'o': " + str.indexOf('o')); // 4
        
        // 10. replace() — заменяет символы или подстроки
        System.out.println("Заменить 'World' на 'Java': " + str.replace("World", "Java")); // "Hello, Java!"
    }
}
