public class person
{
    String name;
    int age;

    public person(String name, int age) {
        this.name = name;
        this.age = age;
    }
public class student extends person {
    public student(String name, int age)
    {
        super(name, age);
    }
}    
}
