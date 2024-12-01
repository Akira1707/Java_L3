public class MultipleExceptions{

    public static void main(String[] args) {
        try {
            // Генерация нескольких исключений, которые обрабатываются идентичным образом
            String str = null;
            System.out.println(str.length());  // NullPointerException

            int[] arr = new int[2];
            System.out.println(arr[5]);  // ArrayIndexOutOfBoundsException

        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            // Обработка двух исключений идентичным образом
            System.out.println("Ошибка: Неверное использование объекта или индекса: " + e.getMessage());
        }

        try {
            // Генерация исключений с иерархией
            throw new Ex3("Ошибка в Ex3");

        } catch (Ex1 e) {
            // Обработка исключений в иерархии Ex1 < Ex2 < Ex3
            System.out.println("Обработано исключение из иерархии: " + e.getMessage());
        }
    }

    // Родительский класс исключений
    static class Ex1 extends Exception {
        public Ex1(String message) {
            super(message); // Передаем сообщение родительскому классу
        }
    }

    // Подкласс исключения
    static class Ex2 extends Ex1 {
        public Ex2(String message) {
            super(message); // Передаем сообщение родительскому классу Ex1
        }
    }

    // Еще один подкласс исключения
    static class Ex3 extends Ex2 {
        public Ex3(String message) {
            super(message); // Передаем сообщение родительскому классу Ex2
        }
    }
}
