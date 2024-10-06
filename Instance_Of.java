public class Instance_Of {
    public static void main(String[] args) {
        String str = "Hello";
        Integer num = 42;

        System.out.println("str instanceof String: " + (str instanceof String)); // true
        System.out.println("num instanceof Integer: " + (num instanceof Integer)); // true


        String nullStr = null;
        System.out.println("nullStr instanceof String: " + (nullStr instanceof String)); // false
    }
}