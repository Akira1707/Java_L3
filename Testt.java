interface MyInterface {

    // Вложенный класс в интерфейсе
    public static class NestedClass {
        public void displayMessage() {
            System.out.println("Message from NestedClass inside MyInterface");
        }
    }

    // Можно также объявить вложенный интерфейс в интерфейсе
    public interface NestedInterface {
        void show();
    }
}

public class Testt {
    public static void main(String[] args) {
        // Вызов метода из вложенного класса интерфейса
        MyInterface.NestedClass nestedObj = new MyInterface.NestedClass();
        nestedObj.displayMessage();  // Выводит: Message from NestedClass inside MyInterface

        // Пример использования вложенного интерфейса
        MyInterface.NestedInterface nestedInterface = new MyInterface.NestedInterface() {
            @Override
            public void show() {
                System.out.println("Show method from NestedInterface");
            }
        };

        nestedInterface.show();  // Выводит: Show method from NestedInterface
    }
}
