package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Car {
    String name;
    int distance = 0;
    Boolean winner = false;
    static ArrayList<Car> carList = new ArrayList<>();

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
            carList.add(new Car(name));
        }
    }

    public static void forward() {
        for (Car car : carList) {
            int randomNum = Randoms.pickNumberInRange(0, 9);
            if (randomNum >= 4) {
                car.distance++;
            }
        }
    }

    public static void printRoundResult() {
        for (Car car : carList) {
            StringBuilder result = new StringBuilder();
            result.append(car.getName()).append(" : ").append("-".repeat(car.getDistance()));
            System.out.println(result);
        }
        System.out.println();
    }
}