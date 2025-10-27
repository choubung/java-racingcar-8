package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int distance = 0;
    private static final int FORWARD_CONDITION = 4;

    public Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    public void forward() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        if (randomNum >= FORWARD_CONDITION) {
            this.distance++;
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}