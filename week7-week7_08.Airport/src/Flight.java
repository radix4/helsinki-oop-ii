public class Flight {

    private Airplane plane;
    private String departureId;
    private String destinationId;

    public Flight(Airplane plane, String departureId, String destinationId) {
        this.plane = plane;
        this.departureId = departureId;
        this.destinationId = destinationId;
    }

    public Airplane getAirplane() {
        return plane;
    }

    public String getDepartureID() {
        return departureId;
    }

    public String getDestinationID() {
        return destinationId;
    }

    @Override
    public String toString() {
        return plane + " (" + departureId + "-" + destinationId + ")";
    }
}