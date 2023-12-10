package cf.mindaugas;

public class EmployeeCalculator {
    private EmployeeFileManager employeeFileManager;
    public EmployeeCalculator(EmployeeFileManager employeeFileManager) {
        this.employeeFileManager = employeeFileManager;
    }

    public EmployeeCalculator() {
    }

    public double getSalaryAverage(){
        var employees = employeeFileManager.getEmployees();
        var x = employeeFileManager.readFile("../likethis");
        double sum = 0;
        for (var employee: employees)
            sum += employee.getSalary();
        return sum / employees.size();
    }
}
