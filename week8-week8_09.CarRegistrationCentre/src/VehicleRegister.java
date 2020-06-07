import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VehicleRegister {
    private Map<RegistrationPlate,String> owners;

    public VehicleRegister() {
        this.owners = new HashMap<RegistrationPlate, String>();
    }

    public boolean add(RegistrationPlate plate, String owner){
        if (owners.containsKey(plate)) {
            return false;
        }

        owners.put(plate, owner);

        return true;
    }

    public String get(RegistrationPlate plate){
        return owners.get(plate);
    }

    public boolean delete(RegistrationPlate plate){
        if (!owners.containsKey(plate)) {
            return false;
        }

        owners.remove(plate);

        return true;
    }

    public void printRegistrationPlates() {
        for (RegistrationPlate r : owners.keySet()) {
            System.out.println(r);
        }
    }

    public void printOwners() {
        List<String> alreadyPrinted = new ArrayList<String>();

        for (String owner : owners.values()) {
            if (!alreadyPrinted.contains(owner)) {
                System.out.println(owner);
                alreadyPrinted.add(owner);  // to not print the same owner twice
            }
        }
    }
}
