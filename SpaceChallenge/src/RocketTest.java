import java.io.FileNotFoundException;
import java.util.ArrayList;

public class RocketTest {
    public static void main(String[] args){

        ArrayList<U1> u1FleetPhase1 = new ArrayList<U1>();
        ArrayList<U1> u1FleetPhase2 = new ArrayList<U1>();
        ArrayList<U2> u2FleetPhase1 = new ArrayList<U2>();
        ArrayList<U2> u2FleetPhase2 = new ArrayList<U2>();
        Simulation sim = new Simulation();
        try {


            u1FleetPhase1 = sim.loadU1("phase1");
            u1FleetPhase2 = sim.loadU1("phase2");
            System.out.println("U1 Phase 1 fleet consists of " + u1FleetPhase1.size() + " rockets.");
            long rocketBudget1 = sim.runSimulation(u1FleetPhase1);
            System.out.println("Current rocket budget = £" + rocketBudget1);
            System.out.println("U1 Phase 2 fleet consists of " + u1FleetPhase2.size() + " rockets.");
            long rocketBudget2 = sim.runSimulation(u1FleetPhase2);
            System.out.println("Current rocket budget = £" + rocketBudget2);
            long lU1Budget = rocketBudget1 + rocketBudget2;
            System.out.println("Total rocket budget using U1 rockets = £" + lU1Budget);

            System.out.println();

            u2FleetPhase1 = sim.loadU2("phase1");
            u2FleetPhase2 = sim.loadU2("phase2");
            System.out.println("U2 Phase 1 fleet consists of " + u2FleetPhase1.size() + " rockets.");
            long rocketBudget3 = sim.runSimulation(u2FleetPhase1);
            System.out.println("Current rocket budget = £" + rocketBudget3);
            System.out.println("U2 Phase 2 fleet consists of " + u2FleetPhase2.size() + " rockets.");
            long rocketBudget4 = sim.runSimulation(u2FleetPhase2);
            System.out.println("Current rocket budget = £" + rocketBudget4);
            long lU2Budget = rocketBudget3 + rocketBudget4;
            System.out.println("Total rocket budget using U2 rockets = £" + lU2Budget);

            System.out.println();

            if(lU1Budget > lU2Budget){
                System.out.println("It would be cheaper to use U2 rockets for the mission.");
            } else {
                System.out.println("It would be cheaper to use U1 rockets for the mission.");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
