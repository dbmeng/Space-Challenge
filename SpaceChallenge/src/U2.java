import java.util.Random;

public class U2 extends Rocket {

    U2(){
        cost = 120000000;
        maxWeight = 29000;
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
        return 1.04 * ((double) currentWeight / (double) maxWeight);
    }

    private double getLandExplosionChance(){
        return 1.08 * ((double) currentWeight / (double) maxWeight);
    }

    private double getExplosionChanceLimit(){
        Random random = new Random();
        return random.nextDouble();
    }
}
