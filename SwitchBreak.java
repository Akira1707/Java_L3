public class SwitchBreak {
    public static void main(String[] args) {
        int value = 2;
        switch(value) {
            case 1:
                System.out.println("One");
                break;
            case 2:
                System.out.println("Two");
                break;
            case 3:
                System.out.println("Three");
                break;
            default:
                System.out.println("Other");
        }

        char letter = 'A';
        switch(letter) {
            case 'A':
                System.out.println("Letter A");
                break;
            case 'B':
                System.out.println("Letter B");
                break;
        }

        String name = "Alice";
        switch(name) {
            case "Alice":
                System.out.println("Hello, Alice!");
                break;
            case "Bob":
                System.out.println("Hello, Bob!");
                break;
        }
    }
}

