public class ApplicationLogic {

    private int result;

    public void plus(int value) {
        result += value;
    }

    public void minus(int value) {
        result -= value;
    }

    public void reset() {
        result = 0;
    }

    public int result() {
        return result;
    }
}