package SkyResort;

public class Card {
    private static int serialNumber;
    private int points;
    private RegisteredCustomer owner;
    boolean active;


    public Card(int points) {

        serialNumber++;
        active = true;

        switch (points) {
            case 5 -> this.points = 5;
            case 10 -> this.points = 10;
            case 15 -> this.points = 15;
            case 25 -> this.points = 25;
            case 50 -> this.points = 50;
            default -> throw new ValidationException("Only 5, 10, 15, 25 or 50 values accepted");
        }

    }

    public Card(int points, int extraPoints) {
        this(points);
        setPoints(points + extraPoints);
    }


    public int getSerialNumber() {
        return serialNumber;
    }

    public int getPoints() {
        return this.points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public RegisteredCustomer owner() {
        return owner;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public String toString() {
        return "SkyResort.Card{" +
                "serialNumber=" + serialNumber +
                ", points=" + points +
                ", owner=" + owner +
                '}';
    }
}
