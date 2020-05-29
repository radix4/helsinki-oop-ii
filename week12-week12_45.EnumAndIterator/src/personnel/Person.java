package personnel;

public class Person {
    private String name;
    private Education title;


    public Person(String name, Education title) {
        this.name = name;
        this.title = title;
    }

    public Education getEducation(){
        return title;
    }

    @Override
    public String toString() {
        return name + ", " + title;
    }
}
