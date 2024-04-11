package racingcar.controller;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Referee;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void start() {

        String inputCarNames = inputView.getCarNames();

        Cars cars = new Cars(inputCarNames);

        Referee referee = new Referee(inputView.getNumberOfRound());

        outputView.printNewline();
        outputView.printResultMessage();

        carsMovementProgress(referee, cars);

        outputView.printWinners(referee.judgementWinnerCars(cars.getCars()));
    }

    private void carsMovementProgress(Referee referee, Cars carsList) {
        for (int i=0; i < referee.getRoundNumber(); i++) {
            carsMovement(carsList.getCars());
            outputView.printAllCarMovement(carsList.getCars());
            outputView.printNewline();
        }
    }

    private void carsMovement(List<Car> cars) {
        for (Car car : cars) {
            car.carMove(Randoms.pickNumberInRange(0, 9));
        }
    }

}
