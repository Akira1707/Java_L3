public class ClassB {
    public void accessClassA() {
        ClassA obj = new ClassA();
        System.out.println("publicVar: " + obj.publicVar);      
        System.out.println("protectedVar: " + obj.protectedVar); 
        System.out.println("defaultVar: " + obj.defaultVar);     
        // System.out.println("privateVar: " + obj.privateVar);  // Error
    }
}