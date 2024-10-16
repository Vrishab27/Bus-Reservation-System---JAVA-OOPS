import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;
// for converting string to date
public class Booking {
    String passengerName;
    int busNo;
    Date date;
    Booking() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name of passenger: ");
        passengerName = sc.next();
        System.out.println("Enter bus no: ");
        busNo = sc.nextInt();
        System.out.println("Enter date dd-mm-yyyy: ");
        String dateInput = sc.next(); // Idhula scan panna modhu string ah dhan irukum since namba date obj use panradhu nala SimpleDateFormat indha class
        //use panni namaku vendiya format ku mathikirom andha string ah.
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");//Indha inbuilt class ah use panrom to convert string to date ,
        // crct ah date endha format la mathanum nu kudukanum parameters mari

        try {
            date = dateFormat.parse(dateInput); //String to date
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
        public  boolean isAvailable(ArrayList<Booking> bookings, ArrayList<Bus> buses){
            int capacity = 0;
            for(Bus bus:buses){
                if(bus.getBusNo() ==busNo ){
                    capacity=bus.getCapacity();
                }
            }
            int booked = 0;
            for (Booking b:bookings){
                if(b.busNo==busNo && b.date.equals(date)){
                    booked++;
                }
            }
            return booked<capacity?true:false;
        }
}
