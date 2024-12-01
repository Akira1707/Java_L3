class A {
    int a = 10;

    public A() {
        System.out.println("Конструктор класса A");
    }

    void display() {
        System.out.println("Метод display() из класса A");
    }
}

class B extends A {
    int a = 20;

    public B() {
        super(); // Вызов конструктора суперкласса
        System.out.println("Конструктор класса B");
    }

    void display() {
        super.display(); // Вызов метода суперкласса
        System.out.println("Метод display() из класса B");
    }

    void show() {
        System.out.println("Поле a из класса B: " + a);
        System.out.println("Поле a из класса A: " + super.a); // Доступ к полю суперкласса
    }
}

public class SuperKeyword {
    public static void main(String[] args) {
        B obj = new B();
        obj.display();
        obj.show();
    }
}

