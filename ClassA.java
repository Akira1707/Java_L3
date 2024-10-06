public class ClassA {
    public int publicVar = 1;        
    protected int protectedVar = 2;   
    int defaultVar = 3;               
    private int privateVar = 4;       

    public void printVariables() {
        System.out.println("publicVar: " + publicVar);
        System.out.println("protectedVar: " + protectedVar);
        System.out.println("defaultVar: " + defaultVar);
        System.out.println("privateVar: " + privateVar);
    }
}