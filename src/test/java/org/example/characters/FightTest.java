package org.example.characters;

import org.example.combat.Fight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FightTest {

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


}