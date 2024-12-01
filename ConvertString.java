public class ConvertString {
    public static void main(String[] args) {
        // Преобразование String в StringBuilder
        String str = "Hello, World!";
        StringBuilder sb = new StringBuilder(str);
        System.out.println("String в StringBuilder: " + sb); // Hello, World!

        // Преобразование StringBuffer в String
        StringBuffer sbf = new StringBuffer("Java");
        String strFromBuffer = sbf.toString();
        System.out.println("StringBuffer в String: " + strFromBuffer); // Java

        // Преобразование StringBuilder в String
        String strFromBuilder = sb.toString();
        System.out.println("StringBuilder в String: " + strFromBuilder); // Hello, World!

        // Преобразование String в StringBuffer
        String str2 = "Programming";
        StringBuffer sb2 = new StringBuffer(str2);
        System.out.println("String в StringBuffer: " + sb2); // Programming
    }
}
