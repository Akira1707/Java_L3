public class OuterClass1 {

    // Внутренний класс с модификатором доступа private
    private class PrivateInner {
        void display() {
            System.out.println("PrivateInner class");
        }
    }

    // Внутренний класс с модификатором доступа по умолчанию (default)
    class DefaultInner {
        void display() {
            System.out.println("DefaultInner class");
        }
    }

    // Внутренний класс с модификатором доступа protected
    protected class ProtectedInner {
        void display() {
            System.out.println("ProtectedInner class");
        }
    }

    // Внутренний класс с модификатором доступа public
    public class PublicInner {
        void display() {
            System.out.println("PublicInner class");
        }
    }

    public static void main(String[] args) {
        OuterClass1 outer = new OuterClass1();

        // Доступ к внутреннему классу с разными модификаторами
        // PrivateInner innerPrivate = outer.new PrivateInner(); // Ошибка, доступ только внутри OuterClass
        OuterClass1.DefaultInner innerDefault = outer.new DefaultInner();
        OuterClass1.ProtectedInner innerProtected = outer.new ProtectedInner();
        OuterClass1.PublicInner innerPublic = outer.new PublicInner();

        // Вызов метода display()
        innerDefault.display();
        innerProtected.display();
        innerPublic.display();
    }
}
