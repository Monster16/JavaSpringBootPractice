package JavaRevisionDated20_11_23.Day_1_Assignement.IntermediateOOP;

public class EmployeesSalary {
    public static void main(String[] args) {

        Employee empLabour = new Labour();
        System.out.println(empLabour.calculateSalary(26));

        Employee empManager = new Manager();
        System.out.println(empManager.calculateSalary(22));

    }
}

class Employee{
    public int calculateSalary(int days) {
        return days;
    }
}
class Manager extends Employee{
    int incentive = 2500;

    @Override
    public int calculateSalary(int days) {
        return (days * 1800) + incentive;
    }
}
class Labour extends Employee{
    int overTime = 1500;
    @Override
    public int calculateSalary(int days) {
        return (days * 800) + overTime;
    }
}
