package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private static final int MAX_CAR_NAME_LENGTH = 5;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );

        // 공동우승
        assertRandomNumberInRangeTest(
                () -> {
                    run("soo,ji,chou", "1");
                    assertThat(output()).contains("soo : -", "ji : -", "chou : ", "최종 우승자 : soo, ji");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름_예외_테스트() {
        // 이름 길이
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.valueOf(MAX_CAR_NAME_LENGTH))
        );

        // 이름에 특수문자 포함
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("soo,ji,chou%", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("특수문자")
        );

        // 아무 이름도 입력되지 않음
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("1대 이상")
        );

        // 빈 문자열이 있음
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("soo,,chou", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("빈 문자열")
        );

        // 동명이인
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("soo,ji,soo", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("동명이인")
        );
    }

    // 이동 횟수가 정수가 아닌 경우 예외 테스트
    @Test
    void 이동횟수_예외_테스트(){
        // 정수가 아닌 입력
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("soo,ji", "c"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("정수")
        );

        // 입력이 1이상의 정수가 아닌 경우
        // 0인 경우
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("soo,ji", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("정수")
        );

        // 음수인 경우
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("soo,ji", "-2"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("정수")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
