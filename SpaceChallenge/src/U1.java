import java.util.Random;

public class U1 extends Rocket {

    U1(){
        cost = 100000000;
        maxWeight = 18000;
    }

    @Override
    public boolean land() {

        if (getLandExplosionChance() >= getExplosionChanceLimit()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean launch(){

        if (getLaunchExplosionChance() >= getExplosionChanceLimit()) {
            return false;
        } else {
            return true;
        }
    }

    private double getLaunchExplosionChance(){
        return 1.05 * ((double) currentWeight / (double) maxWeight);
    }

    private double getLandExplosionChance(){
        return 1.01 * ((double) currentWeight / (double) maxWeight);
    }

    private double getExplosionChanceLimit(){
        Random random = new Random();
        return random.nextDouble();
    }
}
