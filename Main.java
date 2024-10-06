interface Animal {
    void makeSound(); 
}

class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
}

class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}

public class Main {
    public static void main(String[] args) {
       
        var dog = new Dog(); 
        var cat = new Cat(); 
        
        dog.makeSound();    // Woof!
        cat.makeSound();    //Meow!
    }
}
