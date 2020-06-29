package farmsimulator;

import java.util.Random;

public class Cow implements Milkable, Alive {
    private static final String[] NAMES = new String[] {
            "Anu", "Arpa", "Essi", "Heluna", "Hely",
            "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
            "Jaana", "Jami", "Jatta", "Laku", "Liekki",
            "Mainikki", "Mella", "Mimmi", "Naatti",
            "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
            "Rima", "Soma", "Sylkki", "Valpu", "Virpi"
    };

    private Random random = new Random();
    private String name;
    private double capacity;
    private double amount;

    public Cow() {
        this(NAMES[new Random().nextInt(NAMES.length)]);
    }

    public Cow(String name) {
        this.name = name;
        this.capacity = 15 + random.nextInt(26);
        this.amount = 0;
    }

    public String getName() {
        return name;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public double milk() {
        double milkedAmount = amount;
        amount = 0;
        return milkedAmount;
    }

    @Override
    public void liveHour() {
        double producedAmount = 0.7 + random.nextDouble() * 1.3;
        if (amount + producedAmount > capacity) {
            amount = capacity;
        } else {
            amount += producedAmount;
        }
    }

    @Override
    public String toString() {
        return name + " " + Math.ceil(amount) + "/" + Math.ceil(capacity);
    }
}