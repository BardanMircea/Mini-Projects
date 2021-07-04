package UniversityDiagram;

import java.util.ArrayList;

public class Professor extends Employee implements Printable {
    private boolean doctor;
    private boolean lecturer;
    private ArrayList<Course> coursesTaught;

    public Professor(String name, String employeeIdNumber) {
        super(name, employeeIdNumber);
        this.coursesTaught = new ArrayList<>();
    }

    public boolean isDoctor() {
        return doctor;
    }

    public void setDoctor(boolean doctor) {
        this.doctor = doctor;
    }

    public boolean isLecturer() {
        return lecturer;
    }

    public void setLecturer(boolean lecturer) {
        this.lecturer = lecturer;
    }

    public ArrayList<Course> getCoursesTaught() {
        return coursesTaught;
    }

    public void setCoursesTaught(ArrayList<Course> coursesTaught) {
        this.coursesTaught = coursesTaught;
    }


    public String sayHello() {
        String title = "prof.";
        if (doctor) {
            title += " dr.";
        }

        if (lecturer) {
            title += " lect.";
        }

        return ("Hello " + title + " " + getName());
    }

    public String toString() {
        return this.getName();
    }

    public void printSchedule(ArrayList<String> weeklySchedule) {
        System.out.println("Schedule for prof. " + this.getName() + " (Employee ID number: " + this.getEmployeeIdNumber() + "): ");
        int index = 0;
        for (String line : weeklySchedule) {
            for (Course course : coursesTaught) {
                if (line.contains(course.courseName)) {
                    System.out.println(line);
                    index++;
                }
            }
        }

        if (index == 0) {
            System.out.println(" - No courses taught by prof. " + this.getName() + " -");
        }

        System.out.println();
    }
}
