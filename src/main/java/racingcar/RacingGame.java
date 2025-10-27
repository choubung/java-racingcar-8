package racingcar;

import java.util.*;
import java.util.stream.Collectors;

public class RacingGame {
    List<Car> carList = new ArrayList<>();
    static final int MAX_CAR_NAME_LENGTH = 5;

    public RacingGame(String[] nameList) {
        if (nameList.length == 1 && nameList[0].equals("")) {
            throw new IllegalArgumentException("자동차는 1대 이상 입력되어야 합니다.");
        }

        HashSet<String> nameSet = new HashSet<>(Arrays.asList(nameList)); // Set으로 동명이인 여부 판별
        if (nameList.length != nameSet.size()) {
            throw new IllegalArgumentException("동명이인이 있습니다. 구분할 수 있게 입력해주세요.");
        }

        for (String name : nameList) {
            if (name.equals("")) {
                throw new IllegalArgumentException("빈 문자열은 이름으로 사용이 불가합니다ㅏ.");
            }

            if (!name.matches("^[a-zA-Z0-9가-힣]*$")) {
                throw new IllegalArgumentException("특수문자 사용이 불가합니다. 이름은 한글, 영문자, 숫자만 사용할 수 있습니다.");
            }

            if (name.length() > MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차의 이름은 "+ MAX_CAR_NAME_LENGTH +"자 이하여야 합니다.");
            }

            carList.add(new Car(name));
        }
    }

    public void playRound(){
        for (Car car : carList) {
            car.forward();
        }
    }

    public void printRoundResult() {
        playRound();

        for (Car car : carList) {
            StringBuilder result = new StringBuilder();
            result.append(car.getName()).append(" : ").append("-".repeat(car.getDistance()));
            System.out.println(result);
        }
        System.out.println();
    }

    public void printWinners() {
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
                .collect(Collectors.joining(", ")); // 최종 우승자 스트링 만들기

        System.out.println("최종 우승자 : " + winnerNames);
    }
}
