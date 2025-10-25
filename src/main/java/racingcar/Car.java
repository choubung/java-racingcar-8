package racingcar;

public class Car {
    String name;
    int distance = 0;
    Boolean winner = false;
    static int times;

    public Car() { }
    public Car(String name) {
        this.name = name;
    }

    public static void setTimes(int times) {
        Car.times = times;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public Boolean getWinner() {
        return winner;
    }
}
