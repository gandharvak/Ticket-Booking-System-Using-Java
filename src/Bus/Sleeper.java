package Bus;
import Passengers.Passenger;
import java.util.ArrayList;

public class Sleeper extends Bus {

    private ArrayList<Passenger> passengers = new ArrayList<>();
    public Sleeper(String name, String number, int seatCapacity, boolean isAC) {
        super(name, number, seatCapacity, isAC);
    }

    public void bookTicket(Passenger passenger){
        if(passengers.size() < getSeatCapacity()){
            passenger.setSeatNumber(passengers.size() + 1);
            passengers.add(passenger);
            System.out.println("Ticket Booked!");
        }
        else
            System.out.println("Bus is already full. Cannot add more passengers.");
    }

    public void cancelTicket(int seatNumber){
        int seat = passengers.get(seatNumber-1).getSeatNumber();
        if(seat == seatNumber){
            passengers.remove(seatNumber -1);
            System.out.println("Ticket Cancelled Successfully!");
        }
        else {
            System.out.println("Passenger doesn't exits!");
        }
    }

    public void showAllPassenger(){
        if(passengers.isEmpty()){
            System.out.println("Bus is empty!");
        }
        else {
            for(int i=0; i<passengers.size(); i++){
                System.out.println("Name: "+ passengers.get(i).getName() + " Seat Number: "+ passengers.get(i).getSeatNumber());
            }
        }

    }

}
