package racingcar.controller;

import racingcar.dto.CarNameDto;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Referee;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class RacingCarGameController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void start() {
        String inputCarNames = inputView.getCarNames();

        Cars cars = new Cars(inputCarNamesToList(inputCarNames));

        Referee referee = new Referee(inputView.getNumberOfRound());

        outputView.printNewline();
        outputView.printResultMessage();

        carsMovementProgress(referee, cars);

        List<Car> winnercarNamesList = referee.judgementWinnerCars(cars.getCars());

        List<CarNameDto> winnerCarNames = winnercarNamesList.stream()
                .map(Car::getName)
                .map(CarNameDto::of)
                .toList();

        outputView.printWinners(winnerCarNames);
    }

    private void carsMovementProgress(Referee referee, Cars carsList) {
        for (int i = 0; i < referee.getRoundNumber(); i++) {
            carsList.carsMovement(carsList.getCars());
            outputView.printAllCarMovement(carsList.getCars());
            outputView.printNewline();
        }
    }

    private List<String> inputCarNamesToList(String input) {
        List<String> carNames = Arrays.asList(input.split(","));
        return carNames;
    }
}
