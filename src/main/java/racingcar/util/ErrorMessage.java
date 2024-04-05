package racingcar.util;

public enum ErrorMessage {
    INPUT_STRING_DUPLICATE("입력 값이 중복되었습니다."),
    INPUT_STRING_NOT_NULL("입력 값이 null이 될 수 없습니다."),
    INPUT_CAR_NAME_OVER_DIGIT("입력 값이 자리 수를 초과했습니다.");
    final String message;

    ErrorMessage(String message) {
        this.message = message;
    }
}
