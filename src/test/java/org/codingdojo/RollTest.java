package org.codingdojo;

import org.codingdojo.exception.InvalidNumberDicePerRollException;
import org.codingdojo.model.Roll;
import org.junit.jupiter.api.Test;

import static org.codingdojo.YatzyUtilsTest.initDices;
import static org.codingdojo.model.Constants.INVALID_NUMBER_DICE_PER_ROLL_EXCEPTION_MESSAGE;
import static org.junit.jupiter.api.Assertions.*;

public class RollTest {

    @Test
    public void should_validate_roll_when_create_roll_given_5_dices() {
        Roll roll = new Roll(initDices(new int[]{1, 1, 3, 3, 6}));
        assertNotNull(roll);
    }

    @Test
    public void should_throw_exception_when_create_roll_given_not_exactly_5_dices() {
        Exception exception = assertThrows(InvalidNumberDicePerRollException.class, () -> new Roll(initDices(new int[]{1, 1, 3, 3, 6, 5})));
        assertEquals(INVALID_NUMBER_DICE_PER_ROLL_EXCEPTION_MESSAGE, exception.getMessage());
    }

    @Test
    public void should_throw_exception_when_create_roll_given_null() {
        Exception exception = assertThrows(InvalidNumberDicePerRollException.class, () -> new Roll(null));
        assertEquals(INVALID_NUMBER_DICE_PER_ROLL_EXCEPTION_MESSAGE, exception.getMessage());
    }
}
