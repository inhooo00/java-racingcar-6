package racingcar.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import static racingcar.util.ErrorMessage.*;

public class Validator {

    private static final int MAX_DIGIT_CAR_NAME = 5;
    private static final int MIN_DIGIT_CAR_NAME = 1;
    
    /**
     * 입력 받은 문자열 그대로 검사
     * 
     * @param input 자동차 이름 String 전체
     * */
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

    /**
     * Car 유효성 검사
     *
     * @param input 자동차 객체 생성 시 넣을 자동차 이름
     * */
    public static void checkOverRange(String input) {
        if (isOverRange(input) || isUnderRange(input)) {
            throw new IllegalArgumentException(INPUT_CAR_NAME_IS_INCORRECT.message);
        }
    }

    public static void checkSpace(String input) {
        if (isSpace(input)) {
            throw new IllegalArgumentException(INPUT_CAR_NAME_BLANK.message);
        }
    }

    /**
     * 라운드 횟수 유효성 검사
     *
     * @param input 라운드 횟수
     * */
    public static void checkRoundNumber(String input) {
        if (!isRightRoundNumber(input)) {
            throw new IllegalArgumentException(INPUT_WRONG_ROUND_NUMBER.message);
        }
    }
    
    private static boolean hasDuplicateCarName(String input) {
        List<String> allCarNames = Parser.parseStringToList(input);
        Set set = new HashSet(allCarNames);

        return allCarNames.size() != set.size();
    }
    
    private static boolean isOverRange(String input) {
        return MAX_DIGIT_CAR_NAME < input.length();
    }

    private static boolean isUnderRange(String input) {
        return MIN_DIGIT_CAR_NAME > input.length();
    }

    private static boolean isSpace(String input) {
        return Pattern.matches("^\\s+$", input);
    }

    private static boolean isRightRoundNumber(String input) {
        return Pattern.matches("^[1-9]\\d*$", input);
    }
}
