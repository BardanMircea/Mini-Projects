package UniversityDiagram;

import java.util.ArrayList;


public class Faculty implements printable {
    private String name;
    private String address;

    private String universityName;
    private ArrayList<Student> facultyStudents;
    private ArrayList<Course> courses;
    private ArrayList<Professor> facultyMembers;
    private Professor dean;
    private ArrayList<Employee> staff;
    private ArrayList<Amphitheatre> amphitheatres;
    private ArrayList<Laboratory> labs;
    private ArrayList<Library> libraries;
    private final String [] workingHours = {"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00"};
    private final String [] workingDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};


    public Faculty(String name, String universityName) {
        this.name = name;
        this.universityName = universityName;
        this.amphitheatres = new ArrayList<>();
        this.facultyMembers = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.labs = new ArrayList<>();
        this.facultyStudents = new ArrayList<>();
        this.staff = new ArrayList<>();
        this.libraries = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public ArrayList<Student> getFacultyStudents() {
        return facultyStudents;
    }

    public void setStudents(ArrayList<Student> students) {
        this.facultyStudents = students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public ArrayList<Professor> getFacultyMembers() {
        return facultyMembers;
    }

    public void setFacultyMembers(ArrayList<Professor> facultyMembers) {
        this.facultyMembers = facultyMembers;
    }

    public Professor getDean() {
        return dean;
    }

    public void setDean(Professor dean) {
        this.dean = dean;
    }

    public ArrayList<Employee> getStaff() {
        return staff;
    }

    public void setStaff(ArrayList<Employee> staff) {
        this.staff = staff;
    }

    public ArrayList<Amphitheatre> getAmphitheatres() {
        return amphitheatres;
    }

    public void setAmphitheatres(ArrayList<Amphitheatre> amphitheatres) {
        this.amphitheatres = amphitheatres;
    }

    public ArrayList<Laboratory> getLabs() {
        return labs;
    }

    public void setLabs(ArrayList<Laboratory> labs) {
        this.labs = labs;
    }

    public ArrayList<Library> getLibraries() {
        return libraries;
    }

    public void setLibraries(ArrayList<Library> libraries) {
        this.libraries = libraries;
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<String> generateWeeklySchedule() {
        ArrayList<String> weeklySchedule = new ArrayList<>();
        weeklySchedule.add(this.name + " weekly schedule: ");
        int daysIndex = 0;
        int courseIndex = 0;
        int hoursIndex = 2;
        while ( hoursIndex < workingHours.length && daysIndex < workingDays.length) {
            if (courseIndex < courses.size()) {
                if (courses.get(courseIndex).isLabCourse()) {

                    for (int i = 0; i < labs.size(); i++) {
                        if (courses.get(courseIndex).getCourseName().equals(labs.get(i).getLaboratoryType())) {
                            weeklySchedule.add(workingDays[daysIndex] + " - " + workingHours[hoursIndex - 2] + "-" + workingHours[hoursIndex] + " - " + courses.get(courseIndex) +
                                    "(prof. " + courses.get(courseIndex).tenuredProfessor +  "), in the " + labs.get(i) + " laboratory (Room " + labs.get(i).getRoomNumber() + ")");
                            break;
                        }
                        if (i == labs.size() - 1) {
                            weeklySchedule.add(workingDays[daysIndex] + " - " + workingHours[hoursIndex - 2] + "-" + workingHours[hoursIndex] + " - " + courses.get(courseIndex) +
                                    " - no default laboratory. Please contact prof. " + courses.get(courseIndex).tenuredProfessor + " for info on the" +
                                    " course location.");
                        }
                    }

                }

                if (courses.get(courseIndex).isTheoretical()){

                    for (int i = 0; i < amphitheatres.size(); i++) {
                        if (courses.get(courseIndex).studentsSignedUp.size() <= amphitheatres.get(i).getRoomCapacity()) {
                            weeklySchedule.add(workingDays[daysIndex] + " - " + workingHours[hoursIndex - 2] + "-" + workingHours[hoursIndex] + " - " + courses.get(courseIndex) +
                                    "(prof. " + courses.get(courseIndex).tenuredProfessor +  "), in the " + amphitheatres.get(i) + " amphitheatre (Room " + amphitheatres.get(i).getRoomNumber() + ")");
                            break;
                        }
                        if (i == amphitheatres.size() - 1) {
                            weeklySchedule.add(workingDays[daysIndex] + " - " + workingHours[hoursIndex - 2] + "-" + workingHours[hoursIndex] + " - " + courses.get(courseIndex) +
                                    " - no default amphitheatre. Please contact prof. " + courses.get(courseIndex).tenuredProfessor + " for info on the" +
                                    " course location.");
                        }
                    }
                }
            }

            hoursIndex += 2;
            courseIndex++;

            if (hoursIndex >= workingHours.length && courseIndex < courses.size()) {
                daysIndex++;
                hoursIndex = 2;
            }
        }

        return weeklySchedule;
    }

    public void printSchedule (ArrayList<String> weeklySchedule) {
        for (String line : weeklySchedule) {
            System.out.println(line);
        }
        System.out.println();
    }

}
