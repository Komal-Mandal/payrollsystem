package apnacollege.com;
import java.util.*;

abstract class Employee{
    private String name;
    private int id;

    public Employee(String name,int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }


  public abstract  double calculatesalary();

    public String toString() {
        return "Employee[Name" + name + "id" + id + "salary" + calculatesalary() + "]";
    }
}

class FullTimeEmployee extends Employee{
    private double salary;

    public FullTimeEmployee(String name,int id,double salary) {
        super(name,id);
        this.salary = salary;

    }
    public double calculatesalary() {
        return salary;
    }
}

class partTimeEmployee extends Employee{

    private int hourswork;
    private double hourlyrate;

    public partTimeEmployee( String name,int id, int hourswork,double hourlyrate) {
        super(name,id);
        this.hourswork = hourswork;
        this.hourlyrate = hourlyrate;
    }

    public double calculatesalary() {
        return hourswork*hourlyrate;
    }
}

class payrollSystem{
    private ArrayList<Employee>EmployeeList;

    public payrollSystem(){
        EmployeeList = new ArrayList();
    }

    public void AddEmployee(Employee employee){
        EmployeeList.add(employee);
    }

    public void removeEmployee(int id){

        Employee employeeToRemove = null;
        for(Employee employee:EmployeeList) {
            if(employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }
        if(employeeToRemove!= null){

            EmployeeList.remove(employeeToRemove);

        }
    }

public void display() {

        for(Employee employee: EmployeeList) {
            System.out.println(employee);
        }
}


}


public class prr {
    public static void main(String args[]) {

        payrollSystem p1 = new payrollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("vikash" , 10, 70000);
        partTimeEmployee emp2 = new partTimeEmployee("akash", 20, 40, 200);
        p1.AddEmployee(emp1);
        p1.AddEmployee(emp2);
        p1.display();
        p1.removeEmployee(10);
        p1.display();


    }
}
