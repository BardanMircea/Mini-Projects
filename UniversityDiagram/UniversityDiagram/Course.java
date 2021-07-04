package UniversityDiagram;

import java.util.ArrayList;

public class Course implements Printable {
    String courseName;
    Professor tenuredProfessor;
    ArrayList<Professor> assistantProfessors;
    ArrayList<Student> studentsSignedUp;
    int credits;
    String year;
    String semester;
    CourseType type;

    public Course(String name, Professor tenuredProfessor, CourseType type) {
        this.courseName = name;
        this.tenuredProfessor = tenuredProfessor;
        this.type = type;
        this.assistantProfessors = new ArrayList<>();
        this.studentsSignedUp = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Professor getTenuredProfessor() {
        return tenuredProfessor;
    }

    public void setTenuredProfessor(Professor tenuredProfessor) {
        this.tenuredProfessor = tenuredProfessor;
    }

    public ArrayList<Professor> getAssistantProfessors() {
        return assistantProfessors;
    }

    public void setAssistantProfessors(ArrayList<Professor> assistantProfessors) {
        this.assistantProfessors = assistantProfessors;
    }

    public ArrayList<Student> getStudentsSignedUp() {
        return studentsSignedUp;
    }

    public void setStudentsSignedUp(ArrayList<Student> studentsSignedUp) {
        this.studentsSignedUp = studentsSignedUp;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public boolean isLabCourse() {
        return this.type.equals(CourseType.PRACTICAL);
    }

    public boolean isTheoretical(){
        return this.type.equals(CourseType.THEORETICAL);
    }

    public String toString() {
        return this.courseName;
    }

    public void printSchedule(ArrayList<String> weeklySchedule) {
        System.out.println("Schedule for " + this.getCourseName() + " course: ");
        int index = 0;
        for (String line : weeklySchedule) {
            if (line.contains(courseName)) {
                System.out.println(line);
                index++;
            }
        }

        if (index == 0) {
            System.out.println(" - ");
        }

        System.out.println();
    }
}
