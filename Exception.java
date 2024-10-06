public class Exception {
    public static void main(String[] args) {
        Integer i = null;
        try {
            int j = i; 
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException");
        }
    }
}