interface test {
     int x=10;
    }

interface test1 {
     int y=20;
    
}

class test3 implements test,test1 {
    int z =30;
    
}
class test4 extends test3 {
    int w = 40; 
}
public class hyp {
    public static void main(String[] args) {
        test4 c1 = new test4();
        System.out.println("x:"+c1.x);
        System.out.println("y:"+c1.y);
        System.out.println("z:"+c1.z);
        System.out.println("w:"+c1.w);
        System.out.println("Total:"+ (c1.x + c1.y + c1.z + c1.w));
    }
}
