package org.example;

import org.example.characters.*;
import org.example.characters.weapons.Shield;
import org.example.characters.weapons.Sword;
import org.example.combat.Battle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class WarlordTest {

    @DisplayName("Warlord Battle test")
    @ParameterizedTest(name = "[{index}] {0} fights against {1}, expected result = {2}")
    @MethodSource
    void parameterizedTest(Army army1, Army army2, boolean expected) {
        var test = Battle.fight(army1, army2);
        assertEquals(expected, test);
    }

    static List<Arguments> parameterizedTest() {
        return List.of(
                arguments(new Army()
                                .addUnits(Warlord::new, 1)
                                .addUnits(Warrior::new, 2)
                                .addUnits(Lancer::new, 2)
                                .addUnits(Healer::new, 2),
                        new Army().addUnits(Warlord::new, 1)
                                .addUnits(Vampire::new, 1)
                                .addUnits(Healer::new, 2)
                                .addUnits(Knight::new, 2),
                        false),
                arguments(new Army()
                                .addUnits(Warrior::new, 2)
                                .addUnits(Lancer::new, 2)
                                .addUnits(Defender::new, 1)
                                .addUnits(Warlord::new, 1),
                        new Army().addUnits(Warlord::new, 2)
                                .addUnits(Vampire::new, 1)
                                .addUnits(Healer::new, 5)
                                .addUnits(Knight::new, 2),
                        false),
                arguments(new Army()
                                .addUnits(Warrior::new, 2)
                                .addUnits(Lancer::new, 3)
                                .addUnits(Defender::new, 1)
                                .addUnits(Warlord::new, 4),
                        new Army().addUnits(Warlord::new, 1)
                                .addUnits(Vampire::new, 1)
                                .addUnits(FightTest.Rookie::new, 1)
                                .addUnits(Knight::new, 1),
                        true)
        );
    }


    @Test
    @DisplayName("1. Warlord: Defender vs Warlord, Winner should be Warlord")
    void defenderVsWarlord() {
        var defender = new Defender();
        var warlord = new Warlord();
        assertFalse(Battle.fight(defender, warlord));
    }


    @Test
    @DisplayName("2. Warlord: Warlord vs Vampire, Winner should be Warlord")
    void warlordVsVampire() {
        var vampire = new Vampire();
        var warlord = new Warlord();
        assertTrue(Battle.fight(warlord, vampire));
    }

    @Test
    @DisplayName("3. Warlord: Warlord vs Knight, Winner should be Warlord")
    void warlordVSKnight() {
        var knight = new Knight();
        var warlord = new Warlord();
        assertTrue(Battle.fight(warlord, knight));
    }
    @Test
    @DisplayName("4. Warlord Battle With Weapons, Winner should be Army 2")
    void warlordBattleWithWeapons() {
        Army army1 = new Army()
                .addUnits(Warrior::new, 2)
                .addUnits(Lancer::new, 3)
                .addUnits(Defender::new, 1)
                .addUnits(Warlord::new, 1);
        Army army2 = new Army().addUnits(Warlord::new, 5)
                .addUnits(Vampire::new, 1)
                .addUnits(FightTest.Rookie::new, 1)
                .addUnits(Knight::new, 1);
        army1.equipWarriorAtPosition(0,new Sword());
        army2.equipWarriorAtPosition(0,new Shield());
        assertFalse(Battle.fight(army1,army2));
    }

}
