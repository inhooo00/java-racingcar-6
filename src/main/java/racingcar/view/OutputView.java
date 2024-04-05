package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {

    private static final int SOLO_WINNER = 1;

    public void printAllCarMovement(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(printEachCarMovement(car));
        }
    }

    public void printWinners(List<Car> winnerCars) {
        StringBuilder nameOfWinnerCars = new StringBuilder();

        if (isSoleWinner(winnerCars)) {
            System.out.println("최종 우승자: " + nameOfWinnerCars);
            return;
        }

        for (Car car : winnerCars) {
            nameOfWinnerCars.append(car.getName()).append(", ");
        }

        nameOfWinnerCars.deleteCharAt(nameOfWinnerCars.length() - 1);
        System.out.println("최종 우승자: " + nameOfWinnerCars);
    }

    private String printEachCarMovement(Car car) {
        return car.getName() + printPosition(car.getMovement());
    }

    private String printPosition(int movementNumber) {
        String totalDash = "";

        for (int i = 0; i <= movementNumber; i++) {
            totalDash += "-";
        }
        return totalDash;
    }

    private boolean isSoleWinner(List<Car> winnerCars) {
        return winnerCars.size() == SOLO_WINNER;
    }

}
