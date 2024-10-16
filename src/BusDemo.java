import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.ArrayList;
public class BusDemo {
    public static void main(String[] args) {
//        Bus buses[] = new Bus[50];//bus object
        ArrayList<Bus> buses = new ArrayList<Bus>();
        ArrayList<Booking> bookings = new ArrayList<Booking>();
        buses.add(new Bus(1,true,2));
        buses.add(new Bus(2,false,50));
        buses.add(new Bus(3,true,48));

        Scanner sc = new Scanner(System.in);
        for(Bus b:buses){
            b.displayBusInfo();
        }
        int userOp=1;
        while(userOp==1){
            System.out.println("Enter 1 to Book and 2 to Exit");
            userOp = sc.nextInt();
            if(userOp == 1){
                Booking booking = new Booking();
                if(booking.isAvailable(bookings,buses)){
                    bookings.add(booking);
                    System.out.println("Your Booking Is Confirmed");
                }
                else{
                    System.out.println("Sorry :( , Bus is full. Try Booking another bus or with a different date.");
                }
            }
        }

    }
}