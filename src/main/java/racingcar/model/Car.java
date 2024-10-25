package racingcar.model;

import racingcar.util.CarValidator;

public class Car {
    private static final int MIN_FORWARD_REQUIREMENT = 4;
    private static String Name;
    private int move = 0;

    public Car(String name) {
        CarValidator.checkOverRange(name);
        CarValidator.checkSpace(name);

        this.Name = name;
    }

    public String getName() {
        return Name;
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
