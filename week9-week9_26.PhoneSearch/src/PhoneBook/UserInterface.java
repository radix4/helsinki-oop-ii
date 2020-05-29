package PhoneBook;

import java.util.Scanner;

public class UserInterface {
    private Person person;

    public UserInterface(Scanner reader) {
        this.person = new Person();

        start();
        commands(reader);
    }

    public void commands(Scanner reader){
        while (true) {
            System.out.print("command: ");
            String command = reader.nextLine();

            if (command.equals("x")){
                break;
            }

            if (command.equals("1")){
                addNumber(reader);
            }else if (command.equals("2")){
                searchForNumber(reader);
            }else if (command.equals("3")){
                searchPersonByPhone(reader);
            }else if (command.equals("4")){
                addAddress(reader);
            }else if (command.equals("5")){
                searchPersonalInfo(reader);
            }else if (command.equals("6")){
                deleteOnePersonInfo(reader);
            }else if (command.equals("7")){
                filteredSearch(reader);
            }

        }
    }

    public void filteredSearch(Scanner reader){
        System.out.print("keyword (if empty, all listed): ");
        String keyWord = reader.nextLine();

        this.person.filteredSearch(keyWord);

    }

    public void deleteOnePersonInfo(Scanner reader){
        System.out.print("whose information: ");
        String name = reader.nextLine();

        this.person.deleteOnePersonInfo(name);
        System.out.println();
    }

    public void searchPersonalInfo(Scanner reader){
        System.out.print("whose information: ");
        String name = reader.nextLine();

        this.person.searchPersonalInfo(name);
        System.out.println();
    }

    public void addAddress(Scanner reader){
        System.out.print("whose address: ");
        String name = reader.nextLine();
        System.out.print("street: ");
        String street = reader.nextLine();
        System.out.print("city: ");
        String city = reader.nextLine();

        this.person.addAddress(name,street,city);
        System.out.println();
    }

    public void searchPersonByPhone(Scanner reader){
        System.out.print("number: ");
        String number = reader.nextLine();

        this.person.searchPersonByPhone(number);
        System.out.println();
    }

    public void searchForNumber(Scanner reader){
        System.out.print("whose number: ");
        String name = reader.nextLine();

        this.person.searchForNumber(name);
    }

    public void addNumber(Scanner reader){
        System.out.print("whose number: ");
        String name = reader.nextLine();
        System.out.print("number: ");
        String number = reader.nextLine();

        person.addPhone(name,number);

        System.out.println();
    }

    public void start(){
        System.out.println("phone search\n" +
                "available operations:\n" +
                " 1 add a number\n" +
                " 2 search for a number\n" +
                " 3 search for a person by phone number\n" +
                " 4 add an address\n" +
                " 5 search for personal information\n" +
                " 6 delete personal information\n" +
                " 7 filtered listing\n" +
                " x quit\n");

    }
}
