import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    private String phase;

    Simulation(){}

    private String phase1 = "phase1.txt";
    private String phase2 = "phase2.txt";
    private String selectedPhase;

    private ArrayList<Item> loadItems(String phase) throws FileNotFoundException{

        if (phase == "phase1"){
            selectedPhase = phase1;
        }

        if (phase == "phase2"){
            selectedPhase = phase2;
        }

        File file = new File(selectedPhase);
        Scanner scanner = new Scanner(file);
        ArrayList<Item> lItemList = new ArrayList<Item>();

        while(scanner.hasNextLine()){
            String fileItem = scanner.nextLine();
            int index = fileItem.indexOf("=");
            String name = fileItem.substring(0,index);
            int weight = Integer.parseInt(fileItem.substring(index+1,fileItem.length()));
            Item item = new Item(name,weight);
            lItemList.add(item);
        }

        return lItemList;
    }

    public ArrayList<U1> loadU1(String phase) throws FileNotFoundException {
        int i = 0;
        ArrayList<U1> lU1List = new ArrayList<U1>();
        ArrayList<Item> itemList = new ArrayList<Item>();
        itemList = loadItems(phase);
        U1 rocket = new U1();
        for(Item item : itemList){
            if(!rocket.canCarry(item)){
                lU1List.add(rocket);
                rocket = new U1();
            }
            rocket.carry(item);
        }

        return lU1List;
    }

    public ArrayList<U2> loadU2(String phase) throws FileNotFoundException {
        int i = 0;
        ArrayList<U2> lU2List = new ArrayList<U2>();
        ArrayList<Item> itemList = new ArrayList<Item>();
        itemList = loadItems(phase);
        U2 rocket = new U2();
        for(Item item : itemList){
            if(!rocket.canCarry(item)){
                lU2List.add(rocket);
                rocket = new U2();
            }
            rocket.carry(item);
        }

        return lU2List;
    }

    public int runSimulation(ArrayList<? extends Rocket> rocketList){
        int rocketsSent = 0;
        int totalBudget = 0;
        for(Rocket rocket : rocketList){
            int lCost = rocket.cost;
            totalBudget += lCost;
            rocketsSent++;
            System.out.println("Rocket number " + rocketsSent + " being sent!");
            if (!rocket.launch()){
                System.out.println("Rocket " + rocketsSent + " failed to launch. Sending another rocket!");
                totalBudget += lCost;
                rocketsSent++;
                System.out.println("Rocket number " + rocketsSent + " being sent!");
                rocket.launch();
            }
            if(!rocket.land()){
                System.out.println("Rocket " + rocketsSent + " failed to land. Sending another rocket!");
                totalBudget += lCost;
                rocketsSent++;
                System.out.println("Rocket number " + rocketsSent + " being sent!");
                rocket.land();
            }
        }

        return totalBudget;
    }

}
