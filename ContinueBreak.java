public class ContinueBreak{
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                System.out.println(i);
                break; 
            }

            if (i % 2 == 0) {
                continue; 
            }
            System.out.println("Odd: "+ i);
        }
    }
}
