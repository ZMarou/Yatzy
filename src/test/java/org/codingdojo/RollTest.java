package org.codingdojo;

import org.codingdojo.exception.InvalidNumberDicePerRollException;
import org.codingdojo.model.Roll;
import org.junit.jupiter.api.Test;

import static org.codingdojo.YatzyUtilsTest.getDices;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RollTest {

    @Test
    public void should_validate_roll_when_create_roll_given_5_dices() {
        Roll roll = new Roll(getDices(new int[]{1, 1, 3, 3, 6}));
        assertNotNull(roll);
    }

    @Test
    public void should_throw_exception_when_create_roll_given_not_exactly_5_dices() {
        assertThrows(InvalidNumberDicePerRollException.class, () -> new Roll(getDices(new int[]{1, 1, 3, 3, 6, 5})));
    }
}
