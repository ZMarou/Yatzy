package org.codingdojo.model;

import org.codingdojo.exception.InvalidNumberDicePerRollException;

public record Roll(Dice[] dices) {

    public Roll {
        if (dices == null || dices.length != 5) {
            throw new InvalidNumberDicePerRollException();
        }
    }
}
