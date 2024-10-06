import java.util.ArrayList;
import java.util.List;

class Animal {
    public void makeSound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    public void makeSound() {
        System.out.println("Woof");
    }
}

class Cat extends Animal {
    public void makeSound() {
        System.out.println("Meow");
    }
}

public class ExtendsT {
    public static void makeSounds(List<? extends Animal> animals) {
        for (Animal animal : animals) {
            animal.makeSound();
        }
    }

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());
        
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat());

        makeSounds(dogs); // Output: Woof
        makeSounds(cats); // Output: Meow
    }
}
