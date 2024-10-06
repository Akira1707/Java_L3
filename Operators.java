public class Operators {
    public static void main(String[] args) {
        int a = 10;
        int b = 5;

        System.out.println("a + b = " + (a + b)); // 15
        System.out.println("a - b = " + (a - b)); // 5
        System.out.println("a * b = " + (a * b)); // 50
        System.out.println("a / b = " + (a / b)); // 2
        System.out.println("a % b = " + (a % b)); // 0

        a += b; // a = 15
        System.out.println("a += b: " + a); // 15

        System.out.println("++a = " + (++a)); // 16
        System.out.println("a++ = " + (a++)); // 16, a = 17
        System.out.println("a = " + a); // 17

        String s1 = "Hello";
        String s2 = "World";
        System.out.println(s1 + " " + s2); // Hello World
    }
}