public class OuterClass3 {

    private String outerField = "Outer field";

    public class InnerClass {
        private String innerField = "Inner field";

        public void innerMethod() {
            System.out.println("Inner method");
        }
    }

    public static void main(String[] args) {
        OuterClass3 outer = new OuterClass3();

        // Создаем экземпляр внутреннего класса
        OuterClass3.InnerClass inner = outer.new InnerClass();

        // Внешний класс может получить доступ к методам внутреннего класса
        inner.innerMethod();

        // Внешний класс НЕ может напрямую получить доступ к полям внутреннего класса
        // System.out.println(inner.innerField); // Ошибка: innerField имеет модификатор private
    }
}

