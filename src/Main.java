import Bus.*;
import Passengers.Passenger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean innerLoop, loop;
        loop = innerLoop = true;
        int choice;
        Bus b = new Bus();
        Scanner sc = new Scanner(System.in);
        while(loop){
            innerLoop = true;
            System.out.println("""
                    1. Admin
                    2. User
                    3. Exit
                    """);
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    while (innerLoop){
                        System.out.println("""
                                1. Add Bus
                                2. Show All Seater Bus
                                3. Show All Sleeper Bus
                                4. Show All Passengers
                                5. Return to Main Menu
                                """);
                        choice = sc.nextInt();
                        switch (choice){
                            case 1:
                                System.out.println("""
                                        1. Add Sleeper Bus
                                        2. Add Seater Bus
                                        """);
                                choice = sc.nextInt();

                                System.out.print("Enter Bus Name: ");
                                String name = sc.next();
                                System.out.print("Enter Bus Number: ");
                                String number = sc.next();
                                System.out.print("Enter Seat Capacity: ");
                                int capacity = sc.nextInt();
                                System.out.print("Is bus AC? (true/false): ");
                                String acstring = sc.next().toLowerCase();
                                boolean isAC = Boolean.parseBoolean(acstring);
                                switch (choice){
                                    case 1:
                                        Sleeper s1 = new Sleeper(name, number, capacity, isAC);
                                        b.addBus(s1);
                                        break;
                                    case 2:
                                        Seater s2 = new Seater(name, number, capacity, isAC);
                                        b.addBus(s2);
                                        break;
                                }
                                break;
                            case 2:
                                b.showAllSeaterBus();
                                break;
                            case 3:
                                b.showAllSleeperBus();
                                break;
                            case 4: System.out.println("""
                                        1. Sleeper
                                        2. Seater
                                        """);
                                choice = sc.nextInt();
                                int serial;
                                switch (choice){
                                    case 1:
                                        boolean result = b.showAllSleeperBus();
                                        if(!result){
                                            System.out.println("Enter bus serial number: ");
                                            serial = sc.nextInt();
                                            Sleeper sleeper = b.getSleeperBus(serial);
                                            sleeper.showAllPassenger();
                                        }
                                        break;
                                    case 2:
                                        result = b.showAllSeaterBus();
                                        if(!result){
                                            System.out.println("Enter bus serial number: ");
                                            serial = sc.nextInt();
                                            Seater seater = b.getSeaterBus(serial);
                                            seater.showAllPassenger();
                                        }
                                        break;
                                }
                                break;
                            case 5:
                                innerLoop = false;
                        }
                    }
                    break;
                case 2:
                    while (innerLoop){
                        System.out.println("""
                                1. Book Ticket
                                2. Cancel Ticket
                                3. Exit
                                """);
                        choice = sc.nextInt();
                        switch (choice){
                            case 1:
                                System.out.print("Enter User Name: ");
                                String name = sc.next();
                                System.out.print("Enter User Email: ");
                                String email = sc.next();
                                System.out.print("Enter User Age: ");
                                int age = sc.nextInt();
                                System.out.print("Enter User Phone Number: ");
                                String phoneNumber = sc.next();

                                Passenger p = new Passenger(name, email, age, phoneNumber);
                                System.out.println("""
                                        1. Sleeper
                                        2. Seater
                                        """);
                                choice = sc.nextInt();
                                int serial;
                                switch (choice){
                                    case 1:
                                        if(!b.showAllSleeperBus()){
                                            System.out.println("Enter bus serial number: ");
                                            serial = sc.nextInt();
                                            Sleeper sleeper = b.getSleeperBus(serial);
                                            System.out.println(sleeper.getName());
                                            sleeper.bookTicket(p);
                                        }
                                        break;
                                    case 2:
                                        if(!b.showAllSeaterBus()){
                                            System.out.println("Enter bus serial number: ");
                                            serial = sc.nextInt();
                                            Seater seater = b.getSeaterBus(serial);
                                            System.out.println(seater.getName());
                                            seater.bookTicket(p);
                                        }
                                        break;
                                }
                                break;
                            case 2:
                                System.out.println("""
                                        1. Sleeper
                                        2. Seater
                                        """);
                                choice = sc.nextInt();
                                switch (choice){
                                    case 1:
                                        if(!b.showAllSleeperBus()){
                                            System.out.println("Enter bus serial number: ");
                                            serial = sc.nextInt();
                                            Sleeper sleeper = b.getSleeperBus(serial);
                                            System.out.println("Enter Seat Number: ");
                                            int seatNumber = sc.nextInt();
                                            sleeper.cancelTicket(seatNumber);
                                        }
                                        break;
                                    case 2:
                                        if(!b.showAllSeaterBus()){
                                            System.out.println("Enter bus serial number: ");
                                            serial = sc.nextInt();
                                            Seater seater = b.getSeaterBus(serial);
                                            System.out.println("Enter Seat Number: ");
                                            int seatNumber = sc.nextInt();
                                            seater.cancelTicket(seatNumber);
                                        }
                                        break;
                                }
                                break;

                            case 3:
                                innerLoop = false;
                        }
                    }
                    break;
                case 3:
                    loop = false;
                    break;
            }
        }
    }
}