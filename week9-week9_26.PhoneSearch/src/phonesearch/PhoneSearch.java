package phonesearch;

import java.util.*;

public class PhoneSearch {

    private Scanner reader;
    private Map<String, String> commands;
    private NumberAndAddressService service;

    public PhoneSearch(Scanner reader) {
        this.reader = reader;
        service = new NumberAndAddressService();

        commands = new TreeMap<String, String>();
        commands.put("1", "1 add a number");
        commands.put("2", "2 search for a number");
        commands.put("3", "3 search for a person by phone number");
        commands.put("4", "4 add an address");
        commands.put("5", "5 search for personal information");
        commands.put("6", "6 delete personal information");
        commands.put("7", "7 filtered listing");
        commands.put("x", "x quit");
    }

    public void start() {
        System.out.println("phone search");
        printInstructions();
        while (true) {
            System.out.println();
            System.out.print("command: ");
            String command = reader.nextLine();
            if (!commands.keySet().contains(command)) {
                System.out.println("invalid command.");
                printInstructions();
            }

            if (command.equals("x")) {
                break;
            } else if (command.equals("1")) {
                addNumber();
            } else if (command.equals("2")) {
                getNumbers();
            } else if (command.equals("3")) {
                getPerson();
            } else if (command.equals("4")) {
                addAddress();
            } else if (command.equals("5")) {
                getPersonalInformation();
            } else if (command.equals("6")) {
                deletePerson();
            } else if (command.equals("7")) {
                list();
            }

        }
    }

    private void getNumbers() {
        System.out.print("whose number: ");
        String name = reader.nextLine();
        Collection<String> numbers = service.getPhoneNumbers(name);
        if (numbers.isEmpty()) {
            System.out.println("  not found");
            return;
        }

        for (String number : numbers) {
            System.out.println(" " + number);
        }
    }

    private void addNumber() {
        System.out.print("whose number: ");
        String name = reader.nextLine();
        System.out.print("number: ");
        String number = reader.nextLine();
        service.addPhoneNumber(name, number);
    }

    private void printInstructions() {
        System.out.println("available operations: ");
        for (String command : commands.values()) {
            System.out.println(" " + command);
        }
    }

    private void getPerson() {
        System.out.print("number: ");
        String number = reader.nextLine();
        String name = service.getName(number);
        if (name == null) {
            System.out.println(" not found");
            return;
        }
        System.out.println(" " + name);
    }

    private void addAddress() {
        System.out.print("whose address: ");
        String name = reader.nextLine();
        System.out.print("street: ");
        String street = reader.nextLine();
        System.out.print("city: ");
        String city = reader.nextLine();
        service.addAddress(name, street, city);
    }

    private void getPersonalInformation() {
        System.out.print("whose information: ");
        String name = reader.nextLine();
        Person person = service.searchByName(name);
        if (person == null) {
            System.out.println("  not found");
            return;
        }

        printPersonalInformation(person);
    }

    private void printPersonalInformation(Person person) {
        printAddress(person);
        printPhoneNumbers(person);
    }

    private void printAddress(Person person) {
        if (person.getStreet() == null || person.getCity() == null) {
            System.out.println("  address unknown");
            return;
        }

        System.out.println("  address: " + person.getStreet() + " " + person.getCity());
    }

    private void printPhoneNumbers(Person person) {
        if (person.getPhoneNumbers().isEmpty()) {
            System.out.println("  phone number not found");
            return;
        }

        System.out.println("  phone numbers:");
        for (String number : person.getPhoneNumbers()) {
            System.out.println("   " + number);
        }
    }

    private void deletePerson() {
        System.out.print("whose information: ");
        String name = reader.nextLine();
        service.remove(name);
    }

    private void list() {
        System.out.print("keyword (if empty, all listed): ");
        String keyword = reader.nextLine();
        Set<Person> found = service.get(keyword);
        if (found.isEmpty()) {
            System.out.println(" keyword not found");
            return;
        }

        for (Person h : service.get(keyword)) {
            System.out.println();
            System.out.println(" " + h.getName());
            printPersonalInformation(h);
        }
    }
}
