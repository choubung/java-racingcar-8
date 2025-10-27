package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        RacingGame game = startNewGame();

        System.out.println("시도할 횟수는 몇 회인가요?");
        int rounds = setRounds();

        System.out.println("실행 결과");
        while (rounds-- > 0) {
            game.printRoundResult();
        }

        game.printWinners();
    }

    private static RacingGame startNewGame() {
        String[] nameList = Console.readLine().replace(" ", "").split(",");
        return new RacingGame(nameList);
    }

    private static int setRounds() {
        try {
            int rounds = Integer.parseInt(Console.readLine());

            if (rounds <= 0) {
                throw new Exception();
            }

            return rounds;

        } catch (Exception e) {
            throw new IllegalArgumentException("1 이상의 정수를 입력해야 합니다.");
        }
    }
}