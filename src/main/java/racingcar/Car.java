package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Car {
    String name;
    int distance = 0;
    Boolean winner = false;
    static ArrayList<Car> cars = new ArrayList<>();

    public Car() { }

    public Car(String name) {
        this.name = name;
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

    public static void register(String[] nameList) {
        for (String name : nameList) {
            cars.add(new Car(name));
        }
    }
}
