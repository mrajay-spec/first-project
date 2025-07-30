//import java.io.*;
import java.util.Scanner;
class student
{
    public String university;
    public int roll_no;
    public float marks;
    public student()
    {
        this.university = "centurion university";
    }
    public static void main(String[] aargs)
    {
student s1 = new student();
System.out.println("university name is:"+ s1.university);

Scanner scanner = new Scanner(System.in);
System.out.println("Enter roll number:");
s1.roll_no = scanner.nextInt();
System.out.println("Enter marks:");
s1.marks = scanner.nextFloat();
System.out.println("Roll Number: " + s1.roll_no + "\n Marks: " + s1.marks);

student s2 = new student();
System.out.println("university name is:"+ s1.university);

System.out.println("Enter roll number:");
s2.roll_no = scanner.nextInt();
System.out.println("Enter marks:");
s2.marks = scanner.nextFloat();
System.out.println("Roll Number: " + s2.roll_no + "\n Marks: " + s2.marks);
scanner.close();
    }

}