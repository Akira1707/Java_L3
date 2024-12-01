public class StringBuilderBuffer {
    public static void main(String[] args) {
        // Пример с StringBuilder
        StringBuilder sb = new StringBuilder("Hello");

        // 1. append() — добавляет строку в конец
        sb.append(", World!");
        System.out.println("После append: " + sb); // Hello, World!

        // 2. insert() — вставляет строку на указанную позицию
        sb.insert(5, " Java");
        System.out.println("После insert: " + sb); // Hello Java, World!

        // 3. delete() — удаляет подстроку
        sb.delete(5, 10);
        System.out.println("После delete: " + sb); // Hello, World!

        // 4. reverse() — переворачивает строку
        sb.reverse();
        System.out.println("После reverse: " + sb); // !dlroW ,olleH

        // 5. replace() — заменяет часть строки
        sb.replace(0, 5, "Java");
        System.out.println("После replace: " + sb); // Java, World!

        // Пример с StringBuffer
        StringBuffer sbf = new StringBuffer("Java");

        // 6. append() — добавляет строку в конец (для StringBuffer)
        sbf.append(" Programming");
        System.out.println("После append (StringBuffer): " + sbf); // Java Programming

        // 7. insert() — вставляет строку на указанную позицию (для StringBuffer)
        sbf.insert(4, " Language");
        System.out.println("После insert (StringBuffer): " + sbf); // Java Language Programming

        // 8. delete() — удаляет подстроку (для StringBuffer)
        sbf.delete(4, 14);
        System.out.println("После delete (StringBuffer): " + sbf); // Java Programming

        // 9. charAt() — возвращает символ на указанной позиции
        char ch = sbf.charAt(5);
        System.out.println("Символ на позиции 5: " + ch); // P

        // 10. capacity() — возвращает емкость буфера
        System.out.println("Емкость StringBuffer: " + sbf.capacity()); // 34 (емкость зависит от длины строки)
    }
}
