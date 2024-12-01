public class OuterClass2 {

    private String outerField = "Outer field";

    public void outerMethod() {
        System.out.println("Outer method");
    }

    class InnerClass {
        void accessOuterMembers() {
            // Доступ к полям и методам внешнего класса
            System.out.println("Accessing outer field: " + outerField);
            outerMethod();
        }
    }

    public static void main(String[] args) {
        OuterClass2 outer = new OuterClass2();
        OuterClass2.InnerClass inner = outer.new InnerClass();
        inner.accessOuterMembers();
    }
}
