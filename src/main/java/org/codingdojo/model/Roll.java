package org.codingdojo.model;

import org.codingdojo.exception.InvalidDiceValueException;
import org.codingdojo.exception.InvalidNumberDicePerRollException;

import java.util.Arrays;

import static org.codingdojo.model.Constants.NUMBER_OF_DICES;

public record Roll(int[] dices) {

    public Roll {
        if (dices.length != NUMBER_OF_DICES) {
            throw new InvalidNumberDicePerRollException();
        }
        if (!Arrays.stream(dices).allMatch(dice -> dice >= 1 && dice <= 6)) {
            throw new InvalidDiceValueException();
        }
    }

    public int score(CategoryEnum category) {
        int score = 0;
        switch (category) {
            case CHANCE -> score = YatzyRules.sumByDiceValue(this, category.score, false);
            case YATZY -> score = YatzyRules.yatzy(this, category.score);
            case ONES, TWOS, THREES, FOURS, FIVES, SIXES ->
                    score = YatzyRules.sumByDiceValue(this, category.score, true);
            case PAIR -> score = YatzyRules.pair(this);
            case TWO_PAIRS -> score = YatzyRules.twoPair(this);
            case THREE_OF_A_KIND, FOUR_OF_A_KIND -> score = YatzyRules.scoreKindNumber(this, category.score);
            case SMALL_STRAIGHT -> score = YatzyRules.scoreStraight(this, category.score, 1);
            case LARGE_STRAIGHT -> score = YatzyRules.scoreStraight(this, category.score, 6);
            case FULL_HOUSE -> score = YatzyRules.fullHouse(this);
        }
        return score;
    }

}
