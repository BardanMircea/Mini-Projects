package UniversityDiagram;

public class Employee extends Person {
    private String employeeIdNumber;
    private String rank;


    public Employee(String name, String employeeIdNumber) {
        super(name);
        this.employeeIdNumber = employeeIdNumber;
    }

    public String getEmployeeIdNumber() {
        return employeeIdNumber;
    }

    public void setEmployeeIdNumber(String employeeIdNumber) {
        this.employeeIdNumber = employeeIdNumber;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
