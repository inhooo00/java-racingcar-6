package racingcar.model;

import racingcar.util.Validator;

import java.util.List;

public class Car {
    private final String NAME;
    private int movement;

    public Car(String name) {
        Validator.checkEmpty(name);
        Validator.checkOverRange(name);

        this.NAME = name;
    }

    public String getName() {
        return NAME;
    }

    public int getMovement(){
        return movement;
    }
}
