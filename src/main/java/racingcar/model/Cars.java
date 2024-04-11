package racingcar.model;

import racingcar.util.CarValidator;
import racingcar.util.Parser;
import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(String input) {
        this.cars = new ArrayList<>();
        checkInputCarNames(input);
        addCars(input);
    }

    public List<Car> getCars() {
        return this.cars;
    }

    private void checkInputCarNames(String input) {
        CarValidator.checkEmpty(input);
        CarValidator.checkDuplicate(input);
    }

    private void addCars(String input) {
        List<String> carNames = Parser.parseStringToList(input);
        for (String carName : carNames) {
            this.cars.add(new Car(carName));
        }
    }

}
