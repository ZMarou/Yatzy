package org.codingdojo.exception;

import static org.codingdojo.model.Constants.INVALID_NUMBER_DICE_PER_ROLL_EXCEPTION_MESSAGE;

public class InvalidNumberDicePerRollException extends RuntimeException {

    public InvalidNumberDicePerRollException(){
        super(INVALID_NUMBER_DICE_PER_ROLL_EXCEPTION_MESSAGE);
    }
}
