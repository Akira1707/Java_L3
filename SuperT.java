import java.util.ArrayList;
import java.util.List;

class Shape {
    public void draw() {
        System.out.println("Drawing a shape");
    }
}

class Circle extends Shape {
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

class Square extends Shape {
    public void draw() {
        System.out.println("Drawing a square");
    }
}

public class SuperT {
    public static void addShapes(List<? super Circle> shapes) {
        shapes.add(new Circle()); // We can add Circle or its subclasses
    }

    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        addShapes(shapes);
        // shapes can now contain Circle objects
    }
}
