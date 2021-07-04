package UniversityDiagram;

import java.util.ArrayList;
import java.util.List;


public class University {
    String institutionName;
    String institutionAddress;

    List<Student> students;
    List<Employee> employees;
    List<Faculty> faculties;
    Professor rector;

    public University(String institutionName, String institutionAddress) {
        this.institutionName = institutionName;
        this.institutionAddress = institutionAddress;
        this.employees = new ArrayList<>();
        this.students = new ArrayList<>();
        this.faculties = new ArrayList<>();
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getInstitutionAddress() {
        return institutionAddress;
    }

    public void setInstitutionAddress(String institutionAddress) {
        this.institutionAddress = institutionAddress;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    public Professor getRector() {
        return rector;
    }

    public void setRector(Professor rector) {
        this.rector = rector;
    }

    public void addFaculty(Faculty faculty) {
        this.faculties.add(faculty);
    }
}
