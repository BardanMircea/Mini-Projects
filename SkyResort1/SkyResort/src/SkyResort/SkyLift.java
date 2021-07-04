package SkyResort;

public class SkyLift {

     private int cost;

     public SkyLift(int cost) {
         this.cost = cost;
     }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "SkyResort.SkyLift{" +
                "cost=" + cost +
                '}';
    }
}
