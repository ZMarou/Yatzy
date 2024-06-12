package org.codingdojo.model;

import java.util.*;
import java.util.function.Predicate;

public final class YatzyRules {

    private static final Predicate<Integer> upperThanTwo = i -> i >= 2;
    private static final Predicate<Integer> upperThanThree = i -> i >= 3;
    private static final Predicate<Integer> equalToTwo = i -> i == 2;
    private static final Predicate<Integer> equalToOne = i -> i == 1;

    public static int yatzy(Roll roll, int score) {
        Dice dice1 = roll.dices()[0];
        return Arrays.stream(roll.dices())
                .allMatch(dice -> dice.equals(dice1)) ? score : 0;
    }

    public static int sumByDiceValue(Roll roll, int diceValue, boolean enableFilter) {
        return Arrays.stream(roll.dices())
                .filter(dice -> !enableFilter || dice.isSameValue(diceValue))
                .reduce(0, (acc, el) -> acc + el.value(), Integer::sum);
    }

    public static int pair(Roll roll) {
        Map<Integer, Integer> map = calculateFrequency(roll);
        int score = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (upperThanTwo.test(e.getValue()) && e.getKey() > score) score = e.getKey();
        }
        return score * 2;
    }

    public static int twoPair(Roll roll) {
        Map<Integer, Integer> map = calculateFrequency(roll);
        int occurrence = 0;
        int score = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (upperThanTwo.test(e.getValue())) {
                score += e.getKey();
                occurrence++;
            }
        }
        return equalToTwo.test(occurrence) ? score * 2 : 0;
    }

    public static int scoreKindNumber(Roll roll, int kindNumber) {
        Map<Integer, Integer> map = calculateFrequency(roll);
        int score = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() >= kindNumber) score = e.getKey();
        }
        return score * kindNumber;
    }

    public static int scoreStraight(Roll roll, int score, int nbStraight) {
        Map<Integer, Integer> map = calculateFrequency(roll);
        return map.values().stream().allMatch(equalToOne) && map.containsKey(nbStraight) ? score : 0;
    }

    public static int fullHouse(Roll roll) {
        Map<Integer, Integer> map = calculateFrequency(roll);
        boolean twoOfAKind = false;
        boolean threeOfAKind = false;
        int score = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (upperThanThree.test(e.getValue())) {
                score += e.getKey() * 3;
                threeOfAKind = true;
            } else if (upperThanTwo.test(e.getValue())) {
                score += e.getKey() * 2;
                twoOfAKind = true;
            }
        }
        return twoOfAKind && threeOfAKind ? score : 0;
    }

    private static Map<Integer, Integer> calculateFrequency(Roll roll) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Dice> dices = Arrays.stream(roll.dices()).toList();
        for (int i = 0; i < dices.size(); i++) {
            map.putIfAbsent(dices.get(i).value(), Collections.frequency(dices, dices.get(i)));
        }
        return map;
    }
}



