package Bus;
import Passengers.*;
import java.util.ArrayList;

public class Bus {
    private String name, number;
    private int seatCapacity;
    private boolean isAC;
    private ArrayList<Seater> seaterBus;
    private ArrayList<Sleeper> sleeperBus;
    public Bus() {
        this.seaterBus = new ArrayList<>();
        this.sleeperBus = new ArrayList<>();
    }
    public Bus(String name, String number, int seatCapacity, boolean isAC) {
        this.name = name;
        this.number = number;
        this.seatCapacity = seatCapacity;
        this.isAC = isAC;
        this.seaterBus = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public String getNumber() {
        return number;
    }
    public int getSeatCapacity() {
        return seatCapacity;
    }
    public boolean isAC() {
        return isAC;
    }
    public boolean showAllSeaterBus(){
        if(seaterBus.isEmpty()){
            System.out.println("Bus not available!");
            return true;
        }
        else {
            for(int i=0; i<seaterBus.size(); i++){
                //getting elements
                Seater b = seaterBus.get(i);
                String name = b.getName();
                String number = b.getNumber();
                int capacity = b.getSeatCapacity();
                String isAC = b.isAC() ? "AC" : "NON AC";

                //printing elements
                System.out.println("SR.NO: " + (i+1));
                System.out.println("Name: "+ name);
                System.out.println("Number: "+ number);
                System.out.println("Capacity: "+ capacity);
                System.out.println("TYPE: "+ isAC);
                System.out.println("__________________________________");
            }
            return false;
        }

    }
    public boolean showAllSleeperBus(){
        if(sleeperBus.isEmpty()){
            System.out.println("Bus not available!");
            return true;
        }
        else {
            for(int i=0; i<sleeperBus.size(); i++){
                //getting elements
                Sleeper b = sleeperBus.get(i);
                String name = b.getName();
                String number = b.getNumber();
                int capacity = b.getSeatCapacity();
                String isAC = b.isAC() ? "AC" : "NON AC";

                //printing elements
                System.out.println("SR.NO: " + (i+1));
                System.out.println("Name: "+ name);
                System.out.println("Number: "+ number);
                System.out.println("Capacity: "+ capacity);
                System.out.println("TYPE: "+ isAC);
                System.out.println("__________________________________");
            }
            return false;
        }

    }
    public void addBus(Seater bus){
        seaterBus.add(bus);
    }
    public void addBus(Sleeper bus){
        sleeperBus.add(bus);
    }
    public Seater getSeaterBus(int index){
        return seaterBus.get(index-1);
    }
    public Sleeper getSleeperBus(int index){
        return sleeperBus.get(index-1);
    }

}
