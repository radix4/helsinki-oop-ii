package PhoneBook;

import java.util.*;

public class Person {
    private String name;
    private Map<String, Set<Phone>> persons;
    private Map<String, String> nameByNumber;
    private Map<String, Set<Address>> nameByAddress;
    private Map<String, String> addressByName;


    public Person() {
        this.persons = new HashMap<String, Set<Phone>>();
        this.nameByNumber = new HashMap<String, String>();
        this.nameByAddress = new HashMap<String, Set<Address>>();
        this.addressByName = new HashMap<String, String>();
    }

    public void filteredSearch(String keyWord){ // in name or address
        if (keyWord.isEmpty()){  // if all empty print all
            for (String name : this.persons.keySet()){
                System.out.println(" " + name);
                searchPersonalInfo(name);
                System.out.println();
            }
            return;
        }

        for (String name : this.persons.keySet()){
            if (name.contains(keyWord)) { // checking for matching name
                searchPersonalInfo(name);
            }
        }

        for (String address : this.addressByName.keySet()){
            if (address.contains(keyWord)){ // check of matching city or street
                searchPersonalInfo(this.addressByName.get(address));
            }
        }



    }

    public void deleteOnePersonInfo(String name){
        this.persons.remove(name);
        this.nameByAddress.remove(name);
        this.nameByNumber.remove(name);
    }

    public void searchPersonalInfo(String name){
        if (this.persons.get(name) == null && this.nameByAddress.get(name) == null){
            System.out.println("  not found");
            return;
        }

        searchNameByAddress(name);
        searchPhoneByName(name);

    }

    public void searchPhoneByName(String name){
        if (!this.persons.containsKey(name)){
            System.out.print("  phone number not found");
        } else {
            System.out.println("  phone numbers:");
            for (Phone phone : this.persons.get(name)) {
                System.out.println("  " + phone.getNumber());
            }
        }
    }

    public void searchNameByAddress(String name){
        if (!this.nameByAddress.containsKey(name)){
            System.out.println("  address unknown");
        } else {
            for (Address address : this.nameByAddress.get(name)){
                System.out.println("  address: " + address);
            }
        }
    }

    public void addAddress(String name, String street, String city){
        if (!this.nameByAddress.containsKey(name)){ //check for key
            this.nameByAddress.put(name, new HashSet<Address>()); // create an empty hashset
        }

        Set<Address> addresses = this.nameByAddress.get(name); // new addresses list, can do this because reference, all connnected
        addresses.add(new Address(street,city));

        this.addressByName.put(street, name);
        this.addressByName.put(city, name);

    }

    public void searchPersonByPhone(String number){
        if (!this.nameByNumber.containsKey(number)) {
            System.out.println(" not found");
        } else {
            System.out.println(" " + this.nameByNumber.get(number));
        }
    }

    public void searchForNumber(String name){ // returns values
        if (!this.persons.containsKey(name)){
            System.out.println("  not found");
        } else {
            for (Phone phone : this.persons.get(name)) {
                System.out.println(" " + phone.getNumber());
            }
        }

        System.out.println();
    }

    public void addPhone(String name, String number){
        if (!this.persons.containsKey(name)){ //if the persons doesn't have the key
            this.persons.put(name, new HashSet<Phone>()); // this creates an empty list of phones
        }

        Set<Phone> phones = this.persons.get(name); //get the set containing user's phones
        phones.add(new Phone(number)); // add a new phone to the list

        this.nameByNumber.put(number,name);
    }
}
