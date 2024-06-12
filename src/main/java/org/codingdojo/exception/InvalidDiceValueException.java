package org.codingdojo.exception;

import static org.codingdojo.model.Constants.INVALID_DICE_VALUE_EXCEPTION_MESSAGE;

public class InvalidDiceValueException extends RuntimeException {

    public InvalidDiceValueException() {
        super(INVALID_DICE_VALUE_EXCEPTION_MESSAGE);
    }
}
