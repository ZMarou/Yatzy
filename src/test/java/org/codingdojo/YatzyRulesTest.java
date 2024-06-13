package org.codingdojo;

import org.codingdojo.model.CategoryEnum;
import org.codingdojo.model.Roll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatzyRulesTest {

    @ParameterizedTest(name = "For dices ({0}) and category ({1}) => expected {2}")
    @MethodSource("defineARoll")
    public void should_return_expected_value_when_choose_selected_category_given_dices(int[] dices, CategoryEnum category, int expected) {
        Roll roll = new Roll(dices);
        assertEquals(expected, roll.score(category));
    }

    private static Stream<Arguments> defineARoll() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 3, 3, 6}, CategoryEnum.CHANCE, 14),
                Arguments.of(new int[]{4, 5, 5, 6, 1}, CategoryEnum.CHANCE, 21),
                Arguments.of(new int[]{1, 1, 1, 1, 1}, CategoryEnum.YATZY, 50),
                Arguments.of(new int[]{1, 1, 1, 2, 1}, CategoryEnum.YATZY, 0),
                Arguments.of(new int[]{1, 1, 2, 4, 4}, CategoryEnum.ONES, 2),
                Arguments.of(new int[]{1, 1, 2, 4, 4}, CategoryEnum.TWOS, 2),
                Arguments.of(new int[]{1, 1, 2, 4, 4}, CategoryEnum.THREES, 0),
                Arguments.of(new int[]{1, 1, 2, 4, 4}, CategoryEnum.FOURS, 8),
                Arguments.of(new int[]{1, 1, 2, 4, 4}, CategoryEnum.FIVES, 0),
                Arguments.of(new int[]{1, 1, 2, 4, 4}, CategoryEnum.SIXES, 0),
                Arguments.of(new int[]{2, 3, 2, 5, 1}, CategoryEnum.TWOS, 4),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, CategoryEnum.PAIR, 0),
                Arguments.of(new int[]{3, 3, 3, 4, 4}, CategoryEnum.PAIR, 8),
                Arguments.of(new int[]{1, 1, 6, 2, 6}, CategoryEnum.PAIR, 12),
                Arguments.of(new int[]{3, 3, 3, 4, 1}, CategoryEnum.PAIR, 6),
                Arguments.of(new int[]{3, 3, 3, 3, 1}, CategoryEnum.PAIR, 6),
                Arguments.of(new int[]{1, 1, 2, 3, 3}, CategoryEnum.TWO_PAIRS, 8),
                Arguments.of(new int[]{1, 1, 2, 3, 4}, CategoryEnum.TWO_PAIRS, 0),
                Arguments.of(new int[]{1, 1, 2, 2, 2}, CategoryEnum.TWO_PAIRS, 6),
                Arguments.of(new int[]{3, 3, 3, 3, 1}, CategoryEnum.TWO_PAIRS, 0),
                Arguments.of(new int[]{3, 3, 3, 4, 5}, CategoryEnum.THREE_OF_A_KIND, 9),
                Arguments.of(new int[]{3, 3, 4, 5, 6}, CategoryEnum.THREE_OF_A_KIND, 0),
                Arguments.of(new int[]{3, 3, 3, 3, 1}, CategoryEnum.THREE_OF_A_KIND, 9),
                Arguments.of(new int[]{2, 2, 2, 2, 5}, CategoryEnum.FOUR_OF_A_KIND, 8),
                Arguments.of(new int[]{2, 2, 2, 5, 5}, CategoryEnum.FOUR_OF_A_KIND, 0),
                Arguments.of(new int[]{2, 2, 2, 2, 2}, CategoryEnum.FOUR_OF_A_KIND, 8),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, CategoryEnum.SMALL_STRAIGHT, 15),
                Arguments.of(new int[]{2, 3, 4, 5, 6}, CategoryEnum.LARGE_STRAIGHT, 20),
                Arguments.of(new int[]{1, 1, 2, 2, 2}, CategoryEnum.FULL_HOUSE, 8),
                Arguments.of(new int[]{2, 2, 3, 3, 4}, CategoryEnum.FULL_HOUSE, 0),
                Arguments.of(new int[]{4, 4, 4, 4, 4}, CategoryEnum.FULL_HOUSE, 0));
    }

}
