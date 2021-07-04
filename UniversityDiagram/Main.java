package UniversityDiagram;


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        University babesBolyai = new University("UBB", "Cluj-Napoca");
        Faculty facultyOfLaw = new Faculty("Faculty of Law", babesBolyai.getInstitutionName());


        Professor prof1 = new Professor("Florin Streteanu", "00");
        Professor prof2 = new Professor("Sorin Alamoreanu", "01");
        Professor prof3 = new Professor("Sergiu Bogdan", "02");


        facultyOfLaw.getFacultyMembers().add(prof1);
        facultyOfLaw.getFacultyMembers().add(prof2);
        facultyOfLaw.getFacultyMembers().add(prof3);



        Course course1 = new Course("General Penal Law", prof1, CourseType.THEORETICAL);
        prof1.getCoursesTaught().add(course1);

        Course course2 = new Course("Special Penal Law", prof3, CourseType.THEORETICAL);
        prof3.getCoursesTaught().add(course2);

        Course course3 = new Course("Forensics", prof2, CourseType.PRACTICAL);
        prof2.getCoursesTaught().add(course3);

        Course course4 = new Course("Criminology", prof3, CourseType.PRACTICAL);
        prof3.getCoursesTaught().add(course4);

        Course course5 = new Course("Course5", prof1, CourseType.THEORETICAL);
        prof1.getCoursesTaught().add(course5);

        Course course6 = new Course("Course6", prof1, CourseType.PRACTICAL);
        prof1.getCoursesTaught().add(course6);

        Course course7 = new Course("Course7", prof2, CourseType.THEORETICAL);
        prof2.getCoursesTaught().add(course7);

        Course course8 = new Course("Course8", prof3, CourseType.THEORETICAL);
        prof3.getCoursesTaught().add(course8);


        facultyOfLaw.getCourses().add(course1);
        facultyOfLaw.getCourses().add(course2);
        facultyOfLaw.getCourses().add(course3);
        facultyOfLaw.getCourses().add(course4);
        facultyOfLaw.getCourses().add(course5);
        facultyOfLaw.getCourses().add(course6);
        facultyOfLaw.getCourses().add(course7);
        facultyOfLaw.getCourses().add(course8);


        Amphitheatre amphitheatre1 = new Amphitheatre("01","Liviu Pop", 100);
        Laboratory lab1 = new Laboratory("03","Forensics");
        Laboratory lab2 = new Laboratory("21","Criminology");
        Amphitheatre amphitheatre2 = new Amphitheatre("02", "Eugeniu Sperantia", 200);

        facultyOfLaw.getAmphitheatres().add(amphitheatre1);
        facultyOfLaw.getAmphitheatres().add(amphitheatre2);
        facultyOfLaw.getLabs().add(lab1);
        facultyOfLaw.getLabs().add(lab2);


        Student student1 = new Student("First Student", "123", "3");
        student1.setGroup("301");

        facultyOfLaw.getFacultyStudents().add(student1);

        student1.addCourse(course1);
        student1.addCourse(course2);
        student1.addCourse(course4);
        student1.addCourse(course3);
        student1.addCourse(course8);

        Student student2 = new Student("Second Student", "465", "2");
        student2.setGroup("203");

        facultyOfLaw.getFacultyStudents().add(student2);

        student2.addCourse(course1);
        student2.addCourse(course5);
        student2.addCourse(course6);
        student2.addCourse(course7);

        for (Student student : facultyOfLaw.getFacultyStudents()) {
            for (Course course : student.getCoursesEnrolledIn()) {
                course.studentsSignedUp.add(student);
            }
        }


        ArrayList<String> weeklySchedule = facultyOfLaw.generateWeeklySchedule();

        facultyOfLaw.printSchedule(weeklySchedule);

        prof1.printSchedule(weeklySchedule);

        prof2.printSchedule(weeklySchedule);

        course1.printSchedule(weeklySchedule);

        student1.printSchedule(weeklySchedule);

        lab1.printSchedule(weeklySchedule);

        amphitheatre2.printSchedule(weeklySchedule);
    }
}
