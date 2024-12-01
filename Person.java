class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Переопределение метода equals()
    @Override
    public boolean equals(Object obj) {
        // Проверка на самосравнение
        if (this == obj) {
            return true;
        }

        // Проверка на null и тип объекта
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        // Приведение типа
        Person person = (Person) obj;

        // Сравнение полей
        return name.equals(person.name) && age == person.age;
    }

    @Override
    public int hashCode() {
        // Вычисление хэш-кода на основе полей
        int result = name.hashCode();
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }

    public static void main(String[] args) {
        Person person1 = new Person("Alice", 30);
        Person person2 = new Person("Alice", 30);
        Person person3 = new Person("Bob", 25);

        System.out.println(person1.equals(person2)); // true
        System.out.println(person1.equals(person3)); // false
        System.out.println(person1.equals(null)); // false
    }
}
