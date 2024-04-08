package racingcar.model;

import racingcar.util.Validator;

public class Car {
    private final int MIN_FORWARD_REQUIREMENT = 4;
    private final String NAME;
    private int movement = 0;

    public Car(String name) {
        Validator.checkOverRange(name);
        Validator.checkSpace(name);

        this.NAME = name;
    }

    public String getName() {
        return NAME;
    }

    public int getMovement() {
        return movement;
    }

    public void setMovement(int number) {
        if (number >= MIN_FORWARD_REQUIREMENT) {
            movement++;
        }
    }

}
