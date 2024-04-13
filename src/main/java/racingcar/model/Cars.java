package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.util.CarValidator;
import java.util.ArrayList;
import java.util.Arrays;
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

    public void carsMovement(List<Car> cars) {
        for (Car car : cars) {
            car.carMove(Randoms.pickNumberInRange(0, 9));
        }
    }

    private void checkInputCarNames(String input) {
        CarValidator.checkEmpty(input);
        CarValidator.checkDuplicate(input);
    }

    private void addCars(String input) {
        List<String> carNames = Arrays.asList(input.split(","));
        for (String carName : carNames) {
            this.cars.add(new Car(carName));
        }
    }

}
