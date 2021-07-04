package UniversityDiagram;

import java.util.ArrayList;


public class Student extends Person implements Printable {
    private String studentIdNumber;
    private String group;
    private String year;
    private ArrayList<Course> coursesEnrolledIn;

    public Student(String name, String studentIdNumber, String year) {
        super(name);
        this.studentIdNumber = studentIdNumber;
        this.year = year;
        this.coursesEnrolledIn = new ArrayList<>();
    }

    public String getIdNumber() {
        return studentIdNumber;
    }

    public void setIdNumber(String idNumber) {
        this.studentIdNumber = idNumber;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public ArrayList<Course> getCoursesEnrolledIn() {
        return coursesEnrolledIn;
    }

    public void setCoursesEnrolledIn(ArrayList<Course> coursesEnrolledIn) {
        this.coursesEnrolledIn = coursesEnrolledIn;
    }

    public void addCourse(Course course) {
        this.coursesEnrolledIn.add(course);
    }

    public String sayHello() {
        return ("Hi " + getName());
    }

    public void printSchedule(ArrayList<String> weeklySchedule) {
        System.out.println("Schedule for student: " + this.getName() + " (ID number:" + this.getIdNumber() + "): ");
        int index = 0;
        for (String line : weeklySchedule) {
            for (Course course : this.coursesEnrolledIn) {
                if (line.contains(course.courseName)) {
                    System.out.println(line);
                    index++;
                }
            }
        }

        if (index == 0) {
            System.out.println(" - Hasn't signed up for any courses, yet - ");
        }
        System.out.println();
    }
}
