
public class RaceCar extends Car {

    private int max_speed;

    public RaceCar(int speed) {
        this.max_speed = speed;
    }

    public void setMax_speed(int max_speed) {
        this.max_speed = max_speed;
    }

    public int getMax_speed() {
        return max_speed;
    }

    @Override
    public String toString() {
        return "RaceCar{" +
                "max_speed=" + max_speed +
                '}';
    }
}
