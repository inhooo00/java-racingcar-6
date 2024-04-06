package racingcar.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import static racingcar.util.ErrorMessage.*;

public class Validator {

    private static final int MAX_DIGIT_CAR_NAME = 5;

    // 입력 받은 문자열만 검사
    public static void checkDuplicate(String input) {
        if (hasDuplicateCarName(input)) {
            throw new IllegalArgumentException(INPUT_STRING_DUPLICATE.message);
        }
    }

    public static void checkEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(INPUT_STRING_NOT_NULL.message);
        }
    }

    // Car 유효성 검사
    private static boolean hasDuplicateCarName(String input) {
        List<String> allCarNames = Parser.parseCarNames(input);
        Set set = new HashSet(allCarNames);

        return allCarNames.size() != set.size();
    }

    public static void checkOverRange(String input) {
        if (isOverRange(input)) {
            throw new IllegalArgumentException(INPUT_CAR_NAME_OVER_RANGE.message);
        }
    }

    private static boolean isOverRange(String input) {
        return MAX_DIGIT_CAR_NAME < input.length();
    }

    // 라운드 수 유효성 검사
    public static void checkRoundNumber(String input) {
        if (!isRightRoundNumber(input)) {
            throw new IllegalArgumentException(INPUT_WRONG_ROUND_NUMBER.message);
        }
    }

    private static boolean isRightRoundNumber(String input) {
        return Pattern.matches("^[1-9]\\d*$", input);
    }
}
