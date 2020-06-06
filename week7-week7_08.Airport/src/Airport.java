import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Airport {

    private Map<String, Airplane> planes = new HashMap<String, Airplane>();
    private Map<String, Flight> flights = new HashMap<String, Flight>();

    public void start(Scanner reader) {
        startAirportPanel(reader);
        System.out.println();
        startFlightService(reader);
        System.out.println();
    }

    private void startAirportPanel(Scanner reader) {
        System.out.println("Airport panel");
        System.out.println("----------------\n");

        while (true) {
            printOperation();
            String input = reader.nextLine();

            if (input.equals("1")) {
                addAirplane(reader);
            } else if (input.equals("2")) {
                addFlight(reader);
            } else if (input.equals("x")) {
                break;
            }
        }
    }

    private static void printOperation(){
        System.out.println("Choose operation:");
        System.out.println("[1] Add airplane");
        System.out.println("[2] Add flight");
        System.out.println("[x] Exit");

        System.out.print("> ");
    }

    private void addAirplane(Scanner reader) {
        System.out.print("Give plane ID: ");
        String id = reader.nextLine();
        System.out.print("Give plane capacity: ");
        int capacity = Integer.parseInt(reader.nextLine());

        Airplane plane = new Airplane(id, capacity);
        planes.put(id, plane);
    }

    private void addFlight(Scanner reader) {
        Airplane plane = askAirplane(reader);
        System.out.print("Give departure airport code: ");
        String departure = reader.nextLine();
        System.out.print("Give destination airport code: ");
        String destination = reader.nextLine();

        Flight flight = new Flight(plane, departure, destination);
        flights.put(flight.toString(), flight);
    }

    private void startFlightService(Scanner reader) {
        System.out.println("Flight service");
        System.out.println("----------------");
        System.out.println();


        while (true) {
            printFlightOperation();
            String input = reader.nextLine();
            if (input.equals("1")) {
                printPlanes();
            } else if (input.equals("2")) {
                printFlights();
            } else if (input.equals("3")) {
                printPlane(reader);
            } else if (input.equals("x")) {
                break;
            }
        }
    }

    private static void printFlightOperation(){
        System.out.println("Choose operation:");
        System.out.println("[1] Print planes");
        System.out.println("[2] Print flights");
        System.out.println("[3] Print plane info");
        System.out.println("[x] Quit");

        System.out.print("> ");
    }

    private void printPlanes() {
        for (Airplane plane : planes.values()) {
            System.out.println(plane);
        }
    }

    private void printFlights() {
        for (Flight flight : flights.values()) {
            System.out.println(flight.toString());
        }
        System.out.println();
    }

    private void printPlane(Scanner reader) {
        Airplane plane = askAirplane(reader);
        System.out.println(plane);
        System.out.println();
    }

    private Airplane askAirplane(Scanner reader) {
        Airplane plane = null;
        while (plane == null) {
            System.out.print("Give plane ID: ");
            String id = reader.nextLine();
            plane = planes.get(id);

            if (plane == null) {
                System.out.println("Plane with ID " + id + " doesn't exist.");
            }
        }

        return plane;
    }
}