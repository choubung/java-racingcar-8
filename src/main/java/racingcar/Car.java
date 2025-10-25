package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Car {
    static List<Car> carList = new ArrayList<>();
    String name;
    int distance = 0;

    public Car() {
    }

    public Car(String name) {
        this.name = name;
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

    public static void printWinners() {
        List<Car> winners = new ArrayList<>();
        int maxDistance = carList.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);

        for (Car car : carList) {
            if (car.getDistance() == maxDistance) {
                winners.add(car);
            }
        }

        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.println("최종 우승자 : " + winnerNames);
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}