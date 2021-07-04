package appliance.model;


import java.util.*;

public class SimpleHouse implements House {

    private final List<Appliance> appliances = new ArrayList<>();

    private final List<PowerSource> powerSources;

    public SimpleHouse(List<PowerSource> powerSources) {
        this.powerSources = Collections.unmodifiableList(powerSources);
    }

    private PowerSource getPowerSourceByName(String name) {
        for (PowerSource powerSource : this.powerSources) {
            if (powerSource.getName().equals(name)) {
                return powerSource;
            }
        }
        return null;
    }

    public List<Appliance> getAppliances() {
        return Collections.unmodifiableList(appliances);
    }

    public void addAppliance(Appliance appliance) {
        appliances.add(appliance);
    }

    public Collection<PowerSource> getPowerSources() {
        return powerSources;
    }

    public int getLoadInWatts(PowerSource powerSource) {
        //TODO implement correctly

        int loadInWatts = 0;
        for (Appliance app : this.getAppliances()) {
            if ((app instanceof PowerConsumer) && ((PowerConsumer) app).getPowerSource().equals(powerSource)) {
               loadInWatts += ((PowerConsumer) app).getCurrentWatts();
            }
        }
        return loadInWatts;
    }

    public void switchOnAllLights() {
        //TODO implement

        for (Appliance app : this.getAppliances()) {
            if (app instanceof Light) {
                ((Light) app).on();
            }
        }
    }

    public void switchOffAllLights() {
        //TODO implement

        for (Appliance app : this.getAppliances()) {
            if (app instanceof Light) {
                ((Light) app).off();
            }
        }
    }

    public void switchAllToGrid() {
        for(Appliance app : appliances) {
            if (app instanceof PowerConsumer) {
                ((PowerConsumer) app).setPowerSource(findPowerSourceByName("Grid"));
            }
        }
    }

    private PowerSource findPowerSourceByName(String name) {
        for(PowerSource powerSource : powerSources) {
            if (powerSource.getName().equals(name)) {
                return powerSource;
            }
        }
        return null;
    }

    public void switchOffGrid() {
        for(Appliance app : appliances) {
            int load = 0;
            if (app instanceof PowerConsumer && ((PowerConsumer) app).getPowerSource().getName().equals("Grid")) {
                for (Appliance  appliance : appliances) {
                    if (appliance instanceof PowerConsumer && ((PowerConsumer) appliance).getPowerSource().getName().equals("Solar")) {
                        load += ((PowerConsumer) appliance).getCurrentWatts();
                    }
                }
                if (load + ((PowerConsumer) app).getCurrentWatts() <= Objects.requireNonNull(getPowerSourceByName("Solar")).getMaxPowerWatt()) {
                    ((PowerConsumer) app).setPowerSource(getPowerSourceByName("Solar"));
                } else if(load + ((PowerConsumer) app).getCurrentWatts() <= Objects.requireNonNull(getPowerSourceByName("Battery")).getMaxPowerWatt()) {
                    ((PowerConsumer) app).setPowerSource(getPowerSourceByName("Battery"));
                } else {
                    if (app instanceof Switchable) {
                        ((Switchable) app).off();
                    }
                    if (app instanceof Refrigerator) {
                        ((Refrigerator) app).setToMaxTemp();
                    }
                }
            }
        }
    }
}
