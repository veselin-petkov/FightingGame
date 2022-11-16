package org.example;

import org.example.characters.Defender;
import org.example.combat.Battle;
import org.example.characters.Knight;
import org.example.characters.Warrior;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BattleTest {

    @DisplayName("Army Battle test")
    @ParameterizedTest(name = "[{index}] {0} fights against {1}, expected result = {2}")
    @MethodSource
    void parameterizedTest(Army army1, Army army2, boolean expected) {
        var test = Battle.battle(army1, army2);
        assertEquals(expected, test);
    }

    static List<Arguments> parameterizedTest() {
        return List.of(
                arguments(new Army().addUnits(Warrior::new, 1), new Army().addUnits(Warrior::new, 2), false),
                arguments(new Army().addUnits(Warrior::new, 2), new Army().addUnits(Warrior::new, 3), false),
                arguments(new Army().addUnits(Warrior::new, 5), new Army().addUnits(Warrior::new, 7), false),
                arguments(new Army().addUnits(Warrior::new, 20), new Army().addUnits(Warrior::new, 21), true),
                arguments(new Army().addUnits(Warrior::new, 10), new Army().addUnits(Warrior::new, 11), true),
                arguments(new Army().addUnits(Warrior::new, 11), new Army().addUnits(Warrior::new, 7), true),
                arguments(new Army().addUnits(Warrior::new, 5).addUnits(Defender::new, 4).addUnits(Defender::new, 5), new Army().addUnits(Warrior::new, 4), true),
                arguments(new Army().addUnits(Defender::new, 5).addUnits(Warrior::new, 20).addUnits(Defender::new, 4), new Army().addUnits(Warrior::new, 21), true),
                arguments(new Army().addUnits(Warrior::new, 10).addUnits(Defender::new, 5).addUnits(Warrior::new, 5), new Army().addUnits(Warrior::new, 5), true),
                arguments(new Army().addUnits(Defender::new, 2).addUnits(Warrior::new, 1).addUnits(Defender::new, 1), new Army().addUnits(Warrior::new, 5), false)
        );
    }

    @Test
    @DisplayName("1. Battle: 1 Warrior vs 2 Warriors")
    void oneWarriorVsTwoWarriors() {
        Army army1 = new Army();
        army1.addUnits(Warrior::new, 1);

        Army army2 = new Army();
        army2.addUnits(Warrior::new, 2);

        assertFalse(Battle.battle(army1, army2));
    }

    @Test
    @DisplayName("2. Battle: 2 Warrior vs 3 Warriors")
    void twoWarriorsVsThreeWarriors() {
        Army army1 = new Army();
        army1.addUnits(Warrior::new, 2);

        Army army2 = new Army();
        army2.addUnits(Warrior::new, 3);

        assertFalse(Battle.battle(army1, army2));
    }

    @Test
    @DisplayName("3. Battle: 5 Warrior vs 7 Warriors")
    void fiveWarriorsVsSevenWarriors() {
        Army army1 = new Army();
        army1.addUnits(Warrior::new, 5);

        Army army2 = new Army();
        army2.addUnits(Warrior::new, 7);

        assertFalse(Battle.battle(army1, army2));
    }

    @Test
    @DisplayName("4. Battle: 20 Warrior vs 21 Warriors")
    void twentyWarriorsVsTwentyOneWarriors() {
        Army army1 = new Army();
        army1.addUnits(Warrior::new, 20);

        Army army2 = new Army();
        army2.addUnits(Warrior::new, 21);

        assertTrue(Battle.battle(army1, army2));
    }


    @Test
    @DisplayName("5. Battle: 10 Warrior vs 11 Warriors")
    void tenWarriorsVsElevenWarriors() {
        Army army1 = new Army();
        army1.addUnits(Warrior::new, 10);

        Army army2 = new Army();
        army2.addUnits(Warrior::new, 11);

        assertTrue(Battle.battle(army1, army2));
    }

    @Test
    @DisplayName("6. Battle: 11 Warrior vs 7 Warriors")
    void elevenWarriorsVsSevenWarriors() {
        Army army1 = new Army();
        army1.addUnits(Warrior::new, 11);

        Army army2 = new Army();
        army2.addUnits(Warrior::new, 7);

        assertTrue(Battle.battle(army1, army2));
    }

    //Custom test by me
    @Test
    @DisplayName("7. Battle: 7 Knights vs 9 Warriors(Custom)")
    void sevenKnightsVsNineWarriors() {
        Army army1 = new Army();
        army1.addUnits(Knight::new, 7);

        Army army2 = new Army();
        army2.addUnits(Warrior::new, 9);

        assertTrue(Battle.battle(army1, army2));
    }
}