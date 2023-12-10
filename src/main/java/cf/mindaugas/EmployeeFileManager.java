package cf.mindaugas;

import java.util.ArrayList;
import java.util.List;

public class EmployeeFileManager {
    public EmployeeFileManager() {}
    public String readFile(String path){
        return "";
    }

    public List<Employee> getEmployees(){
        var fileOutput = this.readFile("./");
        // ...
        return new ArrayList<>(){{
            add(new Employee("Mindaugas", 1500.0));
            add(new Employee("John", 8250.0));
        }};
    }
}

class Employee {
    private String name;
    private Double salary;

    public Employee(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}