package org.codingdojo.model;

import org.codingdojo.exception.InvalidDiceValueException;

public record Dice(int value) {

    public Dice {
        if (value < 1 || value > 6) {
            throw new InvalidDiceValueException();
        }
    }
}
