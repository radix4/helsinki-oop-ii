public class Airplane {
    private String planeID;
    private int capacity;

    public Airplane(String planeID, int planeCapacity){
        this.planeID = planeID;
        this.capacity = planeCapacity;
    }

    public String getPlane(){
        return this.planeID;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public String toString(){
        return this.planeID + " (" + this.capacity + " ppl)";
    }
}
