package UniversityDiagram;


import java.util.ArrayList;

public class Amphitheatre extends Room implements Printable {
    private String name;
    private int roomCapacity;

    public Amphitheatre(String roomNumber, String name, int roomCapacity) {
        super(roomNumber);
        this.name = name;
        this.roomCapacity = roomCapacity;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(int roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    public void printSchedule(ArrayList<String> weeklySchedule) {
        System.out.println("Schedule for amphitheatre " + this.getName() + " (Room number" + this.getRoomNumber() + "): ");
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
