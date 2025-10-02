package org.employee;

import java.util.List;
import java.util.Scanner;

public class MainApp{
    private static final EmployeeDAO dao=new EmployeeDAO();
    private static final Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        int ch;
        do{
            System.out.println("---Employee-JDBC App---");
            System.out.println("1-Add");
            System.out.println("2-ViewAll");
            System.out.println("3-ViewById");
            System.out.println("4-Update");
            System.out.println("5-Delete");
            System.out.println("6-Exit");
            System.out.println("Enter Your Choice");
            ch=sc.nextInt();
            switch (ch){
                case 1->addemployee();
                case 2->viewemployee();
                case 3->viewById();
                case 4->Updateemployee();
                case 5->deleteemployee();
                case 6->{
                    System.out.println("Exit From Employee-JDBC App..Thank You!Visit Again");
                }
                default -> System.out.println("Invalid Choice!Please Try Again");
            }
        }while (ch!=6);
    }

    private static void deleteemployee() {
        System.out.println("Enter Employee Id to Delete:");
        int id=sc.nextInt();
        boolean d=dao.deleteEmployee(id);
        System.out.println(d ?"Deleted":"Not Found");
    }

    private static void Updateemployee() {
        System.out.println("Enter Employee Id:");
        int id=sc.nextInt();
        System.out.println("Enter Employee Name:");
        sc.nextLine();
        String name=sc.nextLine();
        System.out.println("Enter Employee Department");
        String department=sc.nextLine();
        System.out.println("Enter Employee Salary");
        Double salary=sc.nextDouble();
        Employee emp=new Employee(id,name,department,salary);
        boolean e=dao.updateEmployee(emp);
        System.out.println(e ?"Employee Updated Successfully":"Employee Not Found");
    }

    private static void viewById() {
        System.out.println("Enter Employee Id:");
        int id=sc.nextInt();
        Employee e=dao.getEmployeeById(id);
        System.out.println(e==null ? "No Employee Found":e);
    }

    private static void viewemployee() {
        List<Employee> list=dao.getAllEmployees();
        if(list==null){
            System.out.println("No Employees");
        }
        else {
            for(Employee l:list){
                System.out.println(l);
            }
        }

    }

    private static void addemployee() {
        System.out.println("Enter Employee Id:");
        int id=sc.nextInt();
        System.out.println("Enter Employee Name:");
        sc.nextLine();
        String name=sc.nextLine();
        System.out.println("Enter Employee Department:");
        String department=sc.nextLine();
        System.out.println("Enter Employee Salary:");
        double salary = Double.parseDouble(sc.nextLine());
        Employee emp=new Employee(id,name,department,salary);
        Employee saved=dao.addEmployee(emp);
        System.out.println(saved!=null ?"Added"+saved:"Failed");
    }
}