interface test {
     int x=10;
    }

interface test1 {
     int y=20;
    
}

class test3 implements test,test1 {
    int z =30;
    
}
public class Main {
    public static void main(String[] args) {
        test3 c1 = new test3();
        System.out.println("x:"+c1.x);
        System.out.println("y:"+c1.y);
        System.out.println("z:"+c1.z);
        
    }
}