import java.util.HashMap;
import java.util.Scanner;

public class Airport {
    private HashMap<String, Airplane> planes = new HashMap<String, Airplane>();
    private HashMap<String, Flight> flights = new HashMap<String, Flight>();

    public void start(Scanner reader){
        airportPanel(reader);
        flightService(reader);
    }

    private void airportPanel(Scanner reader){
        System.out.print("Airport panel\n" +
                "--------------------\n" +
                "\n");

        while (true) {
            printAirportOperation();
            String command = reader.nextLine();
            if (command.equals("x")){
                break;
            }

            if (command.equals("1")){
                addPlane(reader);
            } else if (command.equals("2")){
                addFlight(reader);
            }
        }
        System.out.println();
    }

    private void flightService(Scanner reader){
        System.out.print("Flight service\n" +
                "------------\n");
        while (true){
            printFlightOperation();
            String command = reader.nextLine();
            if (command.equals("x")){
                break;
            }

            if (command.equals("1")){
                printPlanes();
            } else if (command.equals("2")){
                printFlights();
            } else if (command.equals("3")){
                printPlaneInfo(reader);
            }
        }
    }



    private static void printAirportOperation(){
        System.out.print("Choose operation:\n" +
                "[1] Add airplane\n" +
                "[2] Add flight\n" +
                "[x] Exit\n" +
                "> ");
    }

    private static void printFlightOperation(){
        System.out.print("Choose operation:\n" +
                "[1] Print planes\n" +
                "[2] Print flights\n" +
                "[3] Print plane info\n" +
                "[x] Quit\n" +
                "> ");
    }

    private void addPlane(Scanner reader) {
        System.out.println("Give plane ID: ");
        String planeID = reader.nextLine();
        System.out.println("Give plane capacity: ");
        int planeCapatity = Integer.parseInt(reader.nextLine());
        Airplane plane = new Airplane(planeID, planeCapatity);
        planes.put(planeID, plane);
    }

    private void addFlight(Scanner reader){
        Airplane plane = askAirplane(reader);
        System.out.print("Give departure airport code: ");
        String departureCode = reader.nextLine();
        System.out.print("Give destination airport code: ");
        String destinationCode = reader.nextLine();

        Flight flight = new Flight(plane, departureCode, destinationCode);
        flights.put(flight.toString(), flight);
    }

    private void printPlanes(){
        for (String key : planes.keySet()){   // keySet holds all the keys
            System.out.println(planes.get(key));
        }
    }

    private void printFlights(){
        for (String key: flights.keySet()) {
            System.out.println(flights.get(key));
        }
    }

    private void printPlaneInfo(Scanner reader){
        Airplane plane = askAirplane(reader);
        System.out.println(plane);
        System.out.println();
    }

    private Airplane askAirplane(Scanner reader){
        Airplane plane = null;
        while (plane == null){
            System.out.print("Give plane ID: ");
            String id = reader.nextLine();
            plane = planes.get(id); //hashmap.get matches keys to open the treasure
                                    // if same key doesn't match, ask again.. like a password almost
            if(plane == null) {
                System.out.println("Plane with ID " + id + " doesn't exist.");
            }
        }
        return plane;
    }

}
//basically HashMap(2 params) is a better version of ArrayList(1 param).