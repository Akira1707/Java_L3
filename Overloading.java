class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public double add(double a, double b) {
        return a + b;
    }
}

public class Overloading {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        System.out.println("Sum (int): " + calc.add(5, 3));  // 8
        System.out.println("Sum (int, int, int): " + calc.add(5, 3, 2));  // 10
        System.out.println("Sum (double): " + calc.add(5.5, 3.3));  // 8.8
    }
}

