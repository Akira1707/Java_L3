public class DecodeEx {
    public static void main(String[] args) {

        Integer decimal = Integer.decode("123"); // 123
        Integer hex = Integer.decode("0x7F"); // 127
        Integer octal = Integer.decode("017"); // 15

        System.out.println("Decimal: " + decimal);
        System.out.println("Hexadecimal: " + hex);
        System.out.println("Octal: " + octal);
    }
}
