public class ExceptionEx {

    public static void main(String[] args) {
        try {
            // Генерируем первое исключение (ArithmeticException), которое будет перехвачено
            int result = 10 / 0;  // Деление на ноль
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: Деление на ноль! " + e.getMessage());
        }

        // Генерируем второе исключение (NullPointerException), которое не будет перехвачено
        String str = null;
        System.out.println(str.length());  // Попытка вызвать метод на null, вызовет NullPointerException
    }
}
