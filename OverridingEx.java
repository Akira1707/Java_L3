class A {
    // Метод суперкласса
    void display() {
        System.out.println("Метод display() из класса A");
    }
}

class B extends A {
    // Переопределенный метод
    @Override
    void display() {
        System.out.println("Метод display() из класса B");
    }
}

public class OverridingEx {
    public static void main(String[] args) {
        A obj1 = new A(); // Объект класса A
        obj1.display(); // Вызов метода из класса A

        B obj2 = new B(); // Объект класса B
        obj2.display(); // Вызов метода из класса B

        A obj3 = new B(); // Объект класса B, но тип ссылки A
        obj3.display(); // Вызов метода из класса B (динамическое связывание)
    }
}
