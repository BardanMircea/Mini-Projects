package UniversityDiagram;


import java.util.ArrayList;

public class Laboratory extends Room implements Printable {
    private String laboratoryType;


    public Laboratory(String roomNumber, String laboratoryType) {
        super(roomNumber);
        this.laboratoryType = laboratoryType;
    }

    public String getLaboratoryType() {
        return laboratoryType;
    }

    public void setLaboratoryType(String laboratoryType) {
        this.laboratoryType = laboratoryType;
    }

    public String toString() {
        return this.laboratoryType;
    }

    public void printSchedule(ArrayList<String> weeklySchedule) {
        System.out.println("Schedule for room number " +  this.getRoomNumber() + " (" + this.getLaboratoryType() + " lab): ");
        int index = 0;
        for (String line : weeklySchedule) {
            if (line.contains(this.getRoomNumber())) {
                System.out.println(line);
                index++;
            }
        }

        if (index == 0) {
            System.out.println(" - Non utilized room - ");
        }

        System.out.println();
    }
}
