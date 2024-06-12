package org.codingdojo.model;

import org.codingdojo.exception.InvalidDiceValueException;

import static org.codingdojo.model.Constants.C_1;
import static org.codingdojo.model.Constants.C_6;

public record Dice(int value) {

    public Dice {
        if (value < C_1 || value > C_6) {
            throw new InvalidDiceValueException();
        }
    }

    public boolean isSameValue(int val){
        return this.value == val;
    }
}
