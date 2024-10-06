class Calculator1 {

    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public int add(int... numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

    public double add(double... numbers) {
        double sum = 0.0;
        for (double num : numbers) {
            sum += num;
        }
        return sum;
    }
}

public class VariableNumber {
    public static void main(String[] args) {
        Calculator1 calc = new Calculator1();

        System.out.println("Sum of two numbers: " + calc.add(2, 3)); //5
        System.out.println("Sum of three numbers: " + calc.add(2, 3, 4)); //9
        System.out.println("Sum with variable number of parameters: " + calc.add(1, 2, 3, 4, 5)); //15
        System.out.println("Sum of floating-point numbers: " + calc.add(1.5, 2.5, 3.5)); //7.5
    }
}
