package org.example;

import org.example.characters.Defender;
import org.example.characters.Knight;
import org.example.characters.Vampire;
import org.example.characters.Warrior;

import org.example.combat.Fight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FightTest {

    static class Rookie extends Warrior {
        @Override
        public int getAttack() {
            return 1;
        }
    }

    private Warrior warrior1;
    private Warrior warrior2;
    private Warrior knight;

    @BeforeEach
    public void setup() {
        warrior1 = new Warrior();
        warrior2 = new Warrior();
        knight = new Knight();
    }

    @Test
    @DisplayName("1. Fight: Warrior vs Knight, Winner should be Knight")
    void warriorVsKnight() {
        assertFalse(Fight.fight(warrior1, knight));
    }

    @Test
    @DisplayName("2. Fight: Knight vs Warrior, Winner should be Knight")
    void knightVsWarrior() {
        assertTrue(Fight.fight(knight, warrior1));
    }

    @Test
    @DisplayName("3. Fight: Warrior vs Warrior, Winner should be Warrior One")
    void warriorVsWarrior() {
        assertTrue(Fight.fight(warrior1, warrior2));
    }

    @Test
    @DisplayName("4. Fight: Knight vs Warrior, Knight should be alive")
    void knightVsWarriorCheckIfAliveKnight() {
        Fight.fight(knight, warrior1);
        assertTrue(knight.isAlive());
    }


    @Test
    @DisplayName("5. Fight: Warrior vs Warrior, Warrior Two should be dead")
    void warriorVsWarriorCheckIfAliveWarriorTwo() {

        Fight.fight(warrior1, warrior2);
        assertFalse(warrior2.isAlive());
    }

    @Test
    @DisplayName("6. Fight: Warrior vs Knight, Knight should be Alive")
    void warriorVsKnightCheckIfAliveKnight() {
        Fight.fight(warrior1, knight);
        assertTrue(knight.isAlive());
    }

    @Test
    @DisplayName("7. Fight: Warrior vs Knight Vs Warrior, Knight should lose second battle")
    void warriorVsKnightVsWarriorCheckIfKnightLosesSecondBattle() {
        Fight.fight(warrior1, knight);
        assertFalse(Fight.fight(knight, warrior2));
    }

    @Test
    @DisplayName("8. Fight: Defender vs Rookie, Defender health must 60")
    void defenderVsRookie() {
        Defender defender = new Defender();
        Rookie rookie = new Rookie();
        Fight.fight(defender, rookie);
        assertEquals(defender.getHealth(), 60);
    }

    @Test
    @DisplayName("9. Fight: Defender Vs Rookie Vs Warrior, Defender should beat Warrior")
    void defenderVsRookieVsWarrior() {
        Defender defender = new Defender();
        Rookie rookie = new Rookie();
        Fight.fight(defender, rookie);
        assertTrue(Fight.fight(defender, warrior1));
    }

    @Test
    @DisplayName("10. Fight: Defender Vs Rookie Vs Warrior, Defender should beat Warrior")
    void vampireTest() {
        Vampire vampire = new Vampire();
        Warrior warrior = new Warrior();
        assertTrue(Fight.fight(vampire, warrior));
    }
}