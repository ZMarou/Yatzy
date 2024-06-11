package org.codingdojo;

import org.codingdojo.model.Dice;

import java.util.Arrays;

public class YatzyUtilsTest {

    public static Dice[] getDices(int[] values) {
        return Arrays.stream(values)
                .mapToObj(Dice::new)
                .toArray(Dice[]::new);
    }
}
