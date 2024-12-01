class OverloadingEx {
    // Перегруженный метод: без параметров
    void display() {
        System.out.println("Метод display() без параметров");
    }

    // Перегруженный метод: один параметр
    void display(int a) {
        System.out.println("Метод display() с одним параметром: " + a);
    }

    // Перегруженный метод: два параметра
    void display(String str, int a) {
        System.out.println("Метод display() с двумя параметрами: " + str + ", " + a);
    }

    public static void main(String[] args) {
        OverloadingEx obj = new OverloadingEx();
        obj.display();
        obj.display(10);
        obj.display("Пример", 20);
    }
}
