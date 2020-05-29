package personnel;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Employees {
    private List<Person> employees;

    public Employees() {
        this.employees = new ArrayList<Person>();
    }

    public void fire(Education education){
        Iterator<Person> iterator = employees.iterator();

        while(iterator.hasNext()){
            if (iterator.next().getEducation().equals(education)) {
                iterator.remove();
            }
        }

        // OR employees.removeIf(person -> person.getEducation().equals(education));
    }


    public void add(Person person){
        this.employees.add(person);
    }

    public void add(List<Person> persons){
        employees.addAll(persons);
    }

    public void print(){
        Iterator<Person> iterator = employees.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
    }

    public void print(Education education){
        Iterator<Person> iterator = employees.iterator();

        while(iterator.hasNext()){
            Person person = iterator.next();

            if (person.getEducation() == education) {
                System.out.println(person);
            }
        }
    }

}
