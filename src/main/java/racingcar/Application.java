package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        try {
            String[] nameList = Console.readLine().replace(" ", "").split(",");
            Car.register(nameList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        int rounds = Integer.parseInt(Console.readLine());

        System.out.println("실행 결과");
        while (rounds-- > 0) {
            Car.forward();
            Car.printRoundResult();
        }

        Car.printWinners();
    }
}