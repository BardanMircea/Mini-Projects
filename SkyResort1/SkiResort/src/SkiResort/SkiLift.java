package SkiResort;

public class SkiLift {

     private int cost;

     public SkiLift(int cost) {
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
        return "SkiResort.SkiLift{" +
                "cost=" + cost +
                '}';
    }
}
