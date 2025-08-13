class poymain {
    public void shape() {
        System.out.println("Making a circle");
    }
}

class B extends poymain {
    @Override
    public void shape() {
        System.out.println("Making a square");
    }
}

class C extends poymain {
    @Override
    public void shape() {
        System.out.println("Making a triangle");
    }
}

public class polymain {
    public static void main(String[] args) {
        poymain circle = new poymain();
        poymain square = new B();
        poymain triangle = new C();
        circle.shape();
        square.shape();
        triangle.shape();
    }
}