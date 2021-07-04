package appliance.model;

import java.util.ArrayList;
import java.util.List;

public class HousePowerSources {
    
    List<PowerSource> housePowerSources = new ArrayList<>();
    
    
    public void addPowerSource(PowerSource powerSource) {
        this.housePowerSources.add(powerSource);
    }
    
    public PowerSource getPowerSourceByName(String name) {
        for (PowerSource powerSource : this.housePowerSources) {
            if (powerSource.getName().equals(name)) {
                return powerSource;
            }
        }
        return null;
    } 
}
