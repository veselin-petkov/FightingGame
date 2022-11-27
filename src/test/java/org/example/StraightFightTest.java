package org.example;

import org.example.characters.*;

import org.example.combat.Battle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class StraightFightTest {
    @DisplayName("Straight Fight Battle test")
    @ParameterizedTest(name = "[{index}] {0} fights against {1}, expected result = {2}")
    @MethodSource
    void parameterizedTest(Army army1, Army army2, boolean expected) {
        var test = Battle.straightFight(army1, army2);
        assertEquals(expected, test);
    }

    static List<Arguments> parameterizedTest() {
        return List.of(
                arguments(new Army().addUnits(Lancer::new, 5).addUnits(Vampire::new, 3).addUnits(Warrior::new, 4).addUnits(Defender::new, 2),
                        new Army().addUnits(Warrior::new, 4).addUnits(Defender::new, 4).addUnits(Vampire::new, 6).addUnits(Lancer::new, 5),
                        false),
                arguments(new Army().addUnits(Lancer::new, 7).addUnits(Vampire::new, 3).addUnits(Warrior::new, 4).addUnits(Defender::new, 2),
                        new Army().addUnits(Warrior::new, 4).addUnits(Defender::new, 4).addUnits(Vampire::new, 6).addUnits(Lancer::new, 4), true),
                arguments(new Army().addUnits(Lancer::new, 7).addUnits(Vampire::new, 3).addUnits(Healer::new,1)
                                .addUnits(Warrior::new, 4).addUnits(Healer::new,1).addUnits(Defender::new, 2),
                        new Army().addUnits(Warrior::new, 4).addUnits(Defender::new, 4).addUnits(Healer::new,1)
                                .addUnits(Vampire::new, 6).addUnits(Lancer::new, 4), false),

                arguments(new Army().addUnits(Lancer::new, 4).addUnits(Warrior::new, 3).addUnits(Healer::new,1)
                                .addUnits(Warrior::new, 4).addUnits(Healer::new,1).addUnits(Knight::new, 2),
                        new Army().addUnits(Warrior::new, 4).addUnits(Defender::new, 4).addUnits(Healer::new,1)
                                .addUnits(Vampire::new, 2).addUnits(Lancer::new, 4), true)
        );
    }

    @Test
    @DisplayName("Test name")
    void methodName() {

       Army army1 = new Army().addUnits(Lancer::new, 5).addUnits(Vampire::new, 3).addUnits(Warrior::new, 4).addUnits(Defender::new, 2);
        Army army2 = new Army().addUnits(Warrior::new, 4).addUnits(Defender::new, 4).addUnits(Vampire::new, 6).addUnits(Lancer::new, 5);

        assertTrue(Battle.straightFight(army1, army2));
    }
}
