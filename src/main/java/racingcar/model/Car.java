package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.util.Validator;

public class Car {
    private final int MIN_FORWARD_REQUIREMENT = 4;
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

    public int getMovement() {
        return movement;
    }

    public void setMovement() {
        if (decideAction()) {
            movement++;
        }
    }

    private boolean decideAction() {
        int randomNumber = createRandomNumber();

        return randomNumber >= MIN_FORWARD_REQUIREMENT;
    }

    private int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

}
