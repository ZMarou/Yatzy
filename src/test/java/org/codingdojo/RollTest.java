package org.codingdojo;

import org.codingdojo.exception.InvalidDiceValueException;
import org.codingdojo.exception.InvalidNumberDicePerRollException;
import org.codingdojo.model.Roll;
import org.junit.jupiter.api.Test;

import static org.codingdojo.model.Constants.INVALID_DICE_VALUE_EXCEPTION_MESSAGE;
import static org.codingdojo.model.Constants.INVALID_NUMBER_DICE_PER_ROLL_EXCEPTION_MESSAGE;
import static org.junit.jupiter.api.Assertions.*;

public class RollTest {

    @Test
    public void should_validate_roll_when_create_roll_given_5_dices() {
        Roll roll = new Roll(new int[]{1, 1, 3, 3, 6});
        assertNotNull(roll);
    }

    @Test
    public void should_throw_exception_when_create_roll_given_invalid_number_of_dices() {
        Exception exception = assertThrows(InvalidNumberDicePerRollException.class, () -> new Roll(new int[]{1, 1, 3, 3, 6, 5}));
        assertEquals(INVALID_NUMBER_DICE_PER_ROLL_EXCEPTION_MESSAGE, exception.getMessage());
    }

    @Test
    public void should_throw_exception_when_create_roll_given_invalid_dice() {
        Exception exception = assertThrows(InvalidDiceValueException.class, () -> new Roll(new int[]{0, 1, 3, 3, 7}));
        assertEquals(INVALID_DICE_VALUE_EXCEPTION_MESSAGE, exception.getMessage());
    }

}
