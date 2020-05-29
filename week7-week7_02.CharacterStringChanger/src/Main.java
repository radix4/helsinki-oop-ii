public class Main{

    public static void main(String[] args){

        Changer objChanger = new Changer();

        objChanger.addChange(new Change('e','o'));

        System.out.println(objChanger.change("Hello"));


    }

}