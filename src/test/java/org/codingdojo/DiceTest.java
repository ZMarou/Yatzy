package org.codingdojo;

import org.codingdojo.exception.InvalidDiceValueException;
import org.codingdojo.model.Dice;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.codingdojo.model.Constants.INVALID_DICE_VALUE_EXCEPTION_MESSAGE;
import static org.junit.jupiter.api.Assertions.*;

public class DiceTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    public void should_validate_dice_when_create_dice_given_value_between_1_and_6(int value) {
        Dice d1 = new Dice(value);
        assertNotNull(d1);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 7})
    public void should_throw_exception_when_create_dice_given_value_not_between_1_and_6(int value) {
        Exception exception = assertThrows(InvalidDiceValueException.class, () -> new Dice(value));
        assertEquals(INVALID_DICE_VALUE_EXCEPTION_MESSAGE, exception.getMessage());
    }
}
