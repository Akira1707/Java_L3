class Parent {
    // Объявляем метод с модификатором final
    public final void displayMessage() {
        System.out.println("Это метод из суперкласса Parent.");
    }
}

class Child extends Parent {
    // Попытка переопределить final-метод вызовет ошибку компиляции
    /*
    @Override
    public void displayMessage() {
        System.out.println("Попытка переопределения final-метода.");
    }
    */
}

public class OverridingFinal {
    public static void main(String[] args) {
        Child child = new Child();
        child.displayMessage(); // Вызов метода суперкласса
    }
}

