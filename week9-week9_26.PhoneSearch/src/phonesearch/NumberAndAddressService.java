package phonesearch;

import java.util.*;

public class NumberAndAddressService {

    private Map<String, Person> personsByName;
    private Map<String, Person> personsByPhoneNumber;

    public NumberAndAddressService() {
        personsByName = new TreeMap<String, Person>();
        personsByPhoneNumber = new TreeMap<String, Person>();
    }

    public void addPhoneNumber(String name, String number) {
        Person person = searchAndCreateIfDoesntExist(name);

        person.addPhoneNumber(number);
        personsByPhoneNumber.put(number, person);
    }

    public Collection<String> getPhoneNumbers(String name) {
        Person person = personsByName.get(name);
        if (person == null) {
            return new ArrayList<String>();
        }

        return personsByName.get(name).getPhoneNumbers();
    }

    public String getName(String number) {
        Person person = personsByPhoneNumber.get(number);
        if (person == null) {
            return null;
        }

        return personsByPhoneNumber.get(number).getName();
    }

    public void addAddress(String name, String street, String city) {
        Person person = searchAndCreateIfDoesntExist(name);
        person.setAddress(street, city);
    }

    public Person searchByName(String name) {
        for (Person h : personsByName.values()) {
            if (h.getName().equals(name)) {
                return h;
            }
        }
        return null;
    }

    private Person searchAndCreateIfDoesntExist(String name) {
        Person person = searchByName(name);
        if (person == null) {
            person = new Person(name);
            personsByName.put(name, person);
        }
        return person;
    }

    public void remove(String name) {
        Person h = searchByName(name);

        if (h == null) {
            return;
        }

        for (String number : h.getPhoneNumbers()) {
            personsByPhoneNumber.remove(number);
        }

        personsByName.remove(name);
    }

    public Set<Person> get(String keyword) {
        Set<Person> found = new TreeSet<Person>();

        for (Person person : personsByName.values()) {
            if (entryExists(person, keyword)) {
                found.add(person);
            }
        }

        return found;
    }

    private boolean entryExists(Person person, String keyword) {
        String lowerCaseKeyword = keyword.toLowerCase();

        if (person.getName().toLowerCase().contains(lowerCaseKeyword)) {
            return true;
        } else if (person.getStreet() != null && person.getStreet().toLowerCase().contains(lowerCaseKeyword)) {
            return true;
        }
        return person.getCity() != null && person.getCity().toLowerCase().contains(lowerCaseKeyword);
    }
}