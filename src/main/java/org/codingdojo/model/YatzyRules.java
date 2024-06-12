package org.codingdojo.model;

import java.util.*;

import static org.codingdojo.model.Constants.*;

public final class YatzyRules {

    public static int chance(Roll roll) {
        return Arrays.stream(roll.dices())
                .reduce(C_0, (acc, el) -> acc + el.value(), Integer::sum);
    }

    public static int yatzy(Roll roll) {
        Dice dice1 = roll.dices()[C_0];
        return Arrays.stream(roll.dices())
                .filter(dice -> dice.equals(dice1))
                .count() == NUMBER_OF_DICES ? YATZY_SOCRE : C_0;
    }

    public static int ones(Roll roll) {
        return sumByDiceValue(roll, C_1);
    }

    public static int twos(Roll roll) {
        return sumByDiceValue(roll, C_2);
    }

    public static int threes(Roll roll) {
        return sumByDiceValue(roll, C_3);
    }

    public static int fours(Roll roll) {
        return sumByDiceValue(roll, C_4);
    }

    public static int fives(Roll roll) {
        return sumByDiceValue(roll, C_5);
    }

    public static int sixes(Roll roll) {
        return sumByDiceValue(roll, C_6);
    }

    public static int pair(Roll roll) {
        Map<Integer, Integer> map = calculateFrequency(roll);
        int score = C_0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() >= C_2 && e.getKey() > score) score = e.getKey();
        }
        return score * C_2;
    }

    public static int twoPair(Roll roll) {
        Map<Integer, Integer> map = calculateFrequency(roll);
        int occurrence = C_0;
        int score = C_0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() >= C_2) {
                score += e.getKey();
                occurrence++;
            }
        }
        return occurrence == C_2 ? score * C_2 : C_0;
    }

    public static int threeOfAKind(Roll roll) {
        Map<Integer, Integer> map = calculateFrequency(roll);
        return scoreKindNumber(map, C_3);
    }

    public static int fourOfAKind(Roll roll) {
        Map<Integer, Integer> map = calculateFrequency(roll);
        return scoreKindNumber(map, C_4);
    }

    public static int smallStraight(Roll roll) {
        Map<Integer, Integer> map = calculateFrequency(roll);
        return scoreStraight(map, C_1, C_15);
    }

    public static int largeStraight(Roll roll) {
        Map<Integer, Integer> map = calculateFrequency(roll);
        return scoreStraight(map, C_6, C_20);
    }

    public static int fullHouse(Roll roll) {
        Map<Integer, Integer> map = calculateFrequency(roll);
        boolean twoOfAKind = false;
        boolean threeOfAKind = false;
        int score = C_0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() >= C_3) {
                score += e.getKey() * C_3;
                threeOfAKind = true;
            } else if (e.getValue() >= C_2) {
                score += e.getKey() * C_2;
                twoOfAKind = true;
            }
        }
        return twoOfAKind && threeOfAKind ? score : C_0;
    }

    private static int scoreStraight(Map<Integer, Integer> map, int nbStraight, int score) {
        return map.values().stream().allMatch(i -> i == C_1) && map.containsKey(nbStraight) ? score : C_0;
    }

    private static int sumByDiceValue(Roll roll, int diceValue) {
        return Arrays.stream(roll.dices())
                .filter(dice -> dice.isSameValue(diceValue))
                .reduce(C_0, (acc, el) -> acc + el.value(), Integer::sum);
    }

    private static Map<Integer, Integer> calculateFrequency(Roll roll) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Dice> dices = Arrays.stream(roll.dices()).toList();
        for (int i = C_0; i < dices.size(); i++) {
            map.putIfAbsent(dices.get(i).value(), Collections.frequency(dices, dices.get(i)));
        }
        return map;
    }

    private static int scoreKindNumber(Map<Integer, Integer> map, int kindNumber) {
        int score = C_0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() >= kindNumber) score = e.getKey();
        }
        return score * kindNumber;
    }
}



