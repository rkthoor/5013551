import java.util.*;

class Employee {
    private int employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }
}


public class Main {
    private ArrayList<Employee> employees;

    public Main() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public String searchEmployee(int employeeId) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId() == employeeId) {
                return employee.getName();
            }
        }
        return null;
    }

    public void traverseEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }
    }

    public boolean deleteEmployee(int employeeId) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployeeId() == employeeId) {
                employees.remove(i);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Main system = new Main();

        Employee emp1 = new Employee(1, "John Doe", "Developer", 50000);
        Employee emp2 = new Employee(2, "Jane Smith", "Manager", 70000);
        Employee emp3 = new Employee(3, "Jim Brown", "Designer", 40000);

        system.addEmployee(emp1);
        system.addEmployee(emp2);
        system.addEmployee(emp3);

        System.out.println("Traverse Employees:");
        system.traverseEmployees();

        System.out.println("\nSearch Employee with ID 2:");
        String searchedEmployee = system.searchEmployee(2);
        System.out.println(searchedEmployee != null ? searchedEmployee : "Employee not found");

        System.out.println("\nDelete Employee with ID 1:");
        boolean isDeleted = system.deleteEmployee(1);
        System.out.println("Employee deleted: " + isDeleted);

        System.out.println("\nTraverse Employees after deletion:");
        system.traverseEmployees();
    }
}

