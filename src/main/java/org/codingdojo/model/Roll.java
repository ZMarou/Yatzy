package org.codingdojo.model;

import org.codingdojo.exception.InvalidNumberDicePerRollException;

import static org.codingdojo.model.Constants.NUMBER_OF_DICES;

public record Roll(Dice[] dices) {

    public Roll {
        if (dices == null || dices.length != NUMBER_OF_DICES) {
            throw new InvalidNumberDicePerRollException();
        }
    }

    public int score(CategoryEnum category) {
        int score;
        switch (category) {
            case CHANCE -> score = YatzyRules.chance(this);
            case YATZY -> score = YatzyRules.yatzy(this);
            case ONES -> score = YatzyRules.ones(this);
            case TWOS -> score = YatzyRules.twos(this);
            case THREES -> score = YatzyRules.threes(this);
            case FOURS -> score = YatzyRules.fours(this);
            case FIVES -> score = YatzyRules.fives(this);
            case SIXES -> score = YatzyRules.sixes(this);
            case PAIR -> score = YatzyRules.pair(this);
            case TWO_PAIRS -> score = YatzyRules.twoPair(this);
            case THREE_OF_A_KIND -> score = YatzyRules.threeOfAKind(this);
            case FOUR_OF_A_KIND -> score = YatzyRules.fourOfAKind(this);
            case SMALL_STRAIGHT -> score = YatzyRules.smallStraight(this);
            case LARGE_STRAIGHT -> score = YatzyRules.largeStraight(this);
            case FULL_HOUSE -> score = YatzyRules.fullHouse(this);
            default -> score = -1;
        }
        return score;
    }

}
