import java.lang.Exception;
// Creating a custom exception class, inherited from Exception
public class MyException extends Exception {

    // Constructor with no parameters
    public MyException() {
        super("An error occurred in MyFirstException"); // Default message
    }

    // Constructor accepting a string message
    public MyException(String message) {
        super(message); // Message passed to the constructor
    }

    // Constructor accepting a string message and a Throwable cause (another exception)
    public MyException(String message, Throwable cause) {
        super(message, cause); // Message and cause (another exception)
    }

    // Constructor accepting a Throwable cause
    public MyException(Throwable cause) {
        super(cause); // Cause (another exception)
    }

    public static void main(String[] args) {
        try {
            // Generating a custom exception
            throw new MyException("This is my custom exception!");
        } catch (MyException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}

