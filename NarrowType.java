public class NarrowType {
    public static void main(String[] args) {
        int intValue = 130;
        byte byteValue = (byte) intValue; 
        
        System.out.println(byteValue);        // -126
    }
}