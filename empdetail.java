
import java.util.Scanner;
public class empdetail 
{
    public static void main(String[] args) 
    {
       System.out.println("Enter employee_id,Phone_No:");
       Scanner Rk = new Scanner (System.in);
       int emp_id = Rk.nextInt();
       long phone_no = Rk.nextLong();
       System.out.println("Employee ID: " + emp_id + "\n Phone No: " + phone_no);

System.out.println("Enter the Bs,Da,Hra,Ta:");

       float bs = Rk.nextFloat();
       float da = Rk.nextFloat();
       float Hra = Rk.nextFloat();
       float ta = Rk.nextFloat();
       
       System.out.println("Basic Salary: " + bs + "\n Dearness Allowance: " + da + "\n Hra :" +Hra + "\n Travelling Allowance: " + ta);

       float Gross_salary = bs + da + Hra + ta;
       System.out.println("Total Salary: " + Gross_salary);

       
 Rk.close();

    } 
}
