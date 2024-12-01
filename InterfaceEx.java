// Интерфейс с неабстрактным и статическим методом
interface MyInterface {

    // Неабстрактный метод (метод с реализацией по умолчанию)
    default void defaultMethod() {
        System.out.println("Default method from MyInterface");
    }

    // Статический метод
    static void staticMethod() {
        System.out.println("Static method from MyInterface");
    }
}

// Класс, реализующий интерфейс MyInterface
class MyClass implements MyInterface {

    // Переопределяем default метод
    @Override
    public void defaultMethod() {
        System.out.println("Overridden default method in MyClass");
    }
}

public class InterfaceEx {
    public static void main(String[] args) {
        // Создаем объект класса MyClass
        MyClass obj = new MyClass();

        // Вызов переопределенного метода defaultMethod()
        obj.defaultMethod();  // Выводит: Overridden default method in MyClass

        // Вызов статического метода через имя интерфейса
        MyInterface.staticMethod();  // Выводит: Static method from MyInterface
    }
}

