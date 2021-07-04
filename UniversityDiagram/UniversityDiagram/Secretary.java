package UniversityDiagram;

public class Secretary extends Employee{
    private boolean employeeConfidential;

    public Secretary(String name, String employeeIdNumber) {
        super(name, employeeIdNumber);
    }

    public boolean isEmployeeConfidential() {
        return employeeConfidential;
    }

    public void setEmployeeConfidential(boolean employeeConfidential) {
        this.employeeConfidential = employeeConfidential;
    }
}
