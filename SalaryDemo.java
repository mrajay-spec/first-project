// Parent class
class Manager {
    String name;
    double baseSalary;

    // Constructor
    Manager(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Method to get base salary
    double getSalary() {
        return baseSalary;
    }
}

// Child class extending Manager
class EmployeeX extends Manager {
    double bonus;

    // Constructor
    EmployeeX(String name, double baseSalary, double bonus) {
        super(name, baseSalary); // Call parent constructor
        this.bonus = bonus;
    }

    // Override method to calculate total salary (base + bonus)
    @Override
    double getSalary() {
        return baseSalary + bonus;
    }

    // Display employee details
    void display() {
        System.out.println("Employee Name: " + name);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Bonus: " + bonus);
        System.out.println("Total Salary: " + getSalary());
    }
}

// Main class
public class SalaryDemo {
    public static void main(String[] args) {
        EmployeeX emp = new EmployeeX("Ajay", 50000, 10000);
        emp.display();
    }
}

