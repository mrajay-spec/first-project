import java.util.ArrayList;

public class arr {
    public static void main(String[] args) {
       
        ArrayList<String> names = new ArrayList<>();


        names.add("Rahul");
        names.add("Sneha");
        names.add("Amit");
        names.add("Priya");
        names.add("Karan");

       
        System.out.println("Names in the ArrayList:");
        for (String name : names) {
            System.out.println(name);
        }
    }
}
