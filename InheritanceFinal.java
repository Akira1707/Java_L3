// Объявляем класс как final
final class FinalClass {
    public void displayMessage() {
        System.out.println("Это метод из final-класса.");
    }
}

// Попытка наследоваться от final-класса вызовет ошибку
/*
class SubClass extends FinalClass {
    // Код здесь невозможен, так как FinalClass нельзя наследовать
}
*/
public class InheritanceFinal {
    public static void main(String[] args) {
        FinalClass obj = new FinalClass();
        obj.displayMessage();
    }
}
