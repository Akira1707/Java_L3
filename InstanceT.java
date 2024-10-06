class Wrapper<T> {
    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}

public class InstanceT {
    public static void main(String[] args) {
        Wrapper<String> stringWrapper = new Wrapper<>();
        stringWrapper.setItem("Hello");

        Wrapper<Integer> integerWrapper = new Wrapper<>();
        integerWrapper.setItem(123);

        if (stringWrapper.getItem() instanceof String) {
            System.out.println("stringWrapper contains a string");
        }

        if (integerWrapper.getItem() instanceof Integer) {
            System.out.println("integerWrapper contains an integer");
        }

        if (stringWrapper.getItem() instanceof Object) {
            System.out.println("stringWrapper contains an object");
        }
    }
}
