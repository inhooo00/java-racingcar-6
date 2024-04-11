package racingcar.model;

import racingcar.util.CarValidator;

public class Car {
    private final int MIN_FORWARD_REQUIREMENT = 4;
    private final String NAME;
    private int move = 0;

    public Car(String name) {
        CarValidator.checkOverRange(name);
        CarValidator.checkSpace(name);

        this.NAME = name;
    }

    public String getName() {
        return NAME;
    }

    public int getMove() {
        return move;
    }

    public void carMove(int number) {
        if (number >= MIN_FORWARD_REQUIREMENT) {
            move++;
        }
    }

}
