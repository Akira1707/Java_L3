interface InterfaceA {

    // Неабстрактный метод
    default void commonMethod() {
        System.out.println("Method from InterfaceA");
    }
}

interface InterfaceB {

    // Неабстрактный метод с таким же именем
    default void commonMethod() {
        System.out.println("Method from InterfaceB");
    }
}

// Класс, реализующий оба интерфейса
class MyClass implements InterfaceA, InterfaceB {

    // Переопределяем метод commonMethod() и разрешаем конфликт
    @Override
    public void commonMethod() {
        // Явно вызываем метод одного из интерфейсов
        InterfaceA.super.commonMethod();  // Вызывает метод из InterfaceA
        // InterfaceB.super.commonMethod();  // Вызываем метод из InterfaceB, если нужно
        System.out.println("Method from MyClass (resolved conflict)");
    }
}

public class MultipleInheritance{
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.commonMethod();  // Выводит: Method from InterfaceA
                             //          Method from MyClass (resolved conflict)
    }
}
