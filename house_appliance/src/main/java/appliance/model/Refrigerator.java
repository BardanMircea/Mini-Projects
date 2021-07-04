package appliance.model;

public class Refrigerator extends AbstractPowerConsumer implements Appliance{

    private String name;
    private double targetTemperature;


    public Refrigerator(String name) {
        this.name = name;
        this.targetTemperature = 8;
    }

    public void setToMinTemp() {
        setTargetTemperature(-20);
    }

    public void setToMaxTemp() {
        setTargetTemperature(20);
    }

    public void warmer() {
        if (getTargetTemperature() >= 20) {
            setTargetTemperature(20);
            return;
        }
        this.targetTemperature += 0.5;
    }

    public void colder() {
        if (getTargetTemperature() <= -20) {
            setTargetTemperature(-20);
            return;
        }
        this.targetTemperature -= 0.5;
    }

    public double getTargetTemperature() {
        return targetTemperature;
    }

    public void setTargetTemperature(double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }

    @Override
    public int getMaxWatts() {
        return 600;
    }

    @Override
    public int getCurrentWatts() {
        return (int)(15 * (20 - getTargetTemperature()));
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Refrigerator{" +
                "name='" + name + '\'' +
                ", wattage=" + getCurrentWatts() +
                "/" + getMaxWatts() +
                ", targetTemperature=" + targetTemperature +
                " degrees" +
                '}';
    }
}
