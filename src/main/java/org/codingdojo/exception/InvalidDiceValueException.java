package org.codingdojo.exception;

public class InvalidDiceValueException extends RuntimeException {

    public InvalidDiceValueException() {
        super("Invalid Dice Value");
    }
}
