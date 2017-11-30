import java.util.Random;

public class Rocket implements Spaceship{

    public int cost;
    public int weight;
    public int maxWeight;
    public int currentWeight;

    public Rocket(){}

    public boolean launch() {
        return true;
    }

    public boolean land() {
        return true;
    }

    public boolean canCarry(Item item) {
        return currentWeight + item.weight <= this.maxWeight;
    }

    public int carry(Item item) {
        return currentWeight += item.weight;
    }
}
