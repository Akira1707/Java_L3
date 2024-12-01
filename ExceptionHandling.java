public class ExceptionHandling{

    public static void main(String[] args) {
        // Пример для ArithmeticException
        try {
            int result = 10 / 0;  // Деление на ноль
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: Деление на ноль! " + e.getMessage());
        }

        // Пример для ArrayIndexOutOfBoundsException
        try {
            int[] arr = new int[5];
            arr[10] = 25;  // Обращение к элементу с неверным индексом
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: Индекс выходит за пределы массива! " + e.getMessage());
        }

        // Пример для IllegalArgumentException
        try {
            setAge(-5);  // Невозможно установить отрицательный возраст
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: Неверный аргумент! " + e.getMessage());
        }

        // Пример для ClassCastException
        try {
            Object obj = new String("Привет");
            Integer num = (Integer) obj;  // Преобразование типов
        } catch (ClassCastException e) {
            System.out.println("Ошибка: Невозможно преобразовать тип! " + e.getMessage());
        }

        // Пример для NullPointerException
        try {
            String str = null;
            int length = str.length();  // Попытка вызова метода на null
        } catch (NullPointerException e) {
            System.out.println("Ошибка: Попытка обращения к методу на null! " + e.getMessage());
        }
    }

    // Метод, который выбрасывает IllegalArgumentException, если возраст отрицательный
    public static void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным.");
        }
        System.out.println("Возраст установлен: " + age);
    }
}
