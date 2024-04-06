package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.Validator;

public class Referee {
    private final String roundNumber;

    public Referee(String roundNumber) {
        Validator.checkEmpty(roundNumber);
        Validator.checkRoundNumber(roundNumber);

        this.roundNumber = roundNumber;
    }

    public static List<Car> judgementWinnerCars(List<Car> cars) {
        int maxMovement = cars.stream()
                .mapToInt(Car::getMovement)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("자동차 목록이 비어 있습니다."));

        List<Car> winnerCars = cars.stream()
                .filter(car -> car.getMovement() == maxMovement)
                .collect(Collectors.toList());

        return winnerCars;
    }

}
