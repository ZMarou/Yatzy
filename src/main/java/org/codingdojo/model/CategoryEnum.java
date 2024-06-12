package org.codingdojo.model;

import static org.codingdojo.model.Constants.*;

public enum CategoryEnum {
    CHANCE(0),
    YATZY(YATZY_SCORE),
    ONES(1),
    TWOS(2),
    THREES(3),
    FOURS(4),
    FIVES(5),
    SIXES(6),
    PAIR(2),
    TWO_PAIRS(2),
    THREE_OF_A_KIND(3),
    FOUR_OF_A_KIND(4),
    SMALL_STRAIGHT(SMALL_STRAIGHT_SCORE),
    LARGE_STRAIGHT(LARGE_STRAIGHT_SCORE),
    FULL_HOUSE(0);

    public final int score;

    CategoryEnum(int score) {
        this.score = score;
    }

}
