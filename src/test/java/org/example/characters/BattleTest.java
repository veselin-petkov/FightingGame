package org.example.characters;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BattleTest {

    @Test
    @DisplayName("1. Fight: Warrior vs Knight, Winner should be Knight")
    void warriorVsKnight() {
//        "1. Fight": [
//        prepare_test(middle_code='''carl = Warrior()
//        jim = Knight()''',
//        test="fight(carl, jim)",
//                answer=False)
//                ],
        Warrior carl  = new Warrior();
        Warrior jim = new Knight();
        boolean result = Battle.fight(carl , jim);
        assertFalse(result);

    }

    @Test
    @DisplayName("2. Fight: Knight vs Warrior, Winner should be Knight")
    void knightVsWarrior() {
//        "2. Fight": [
//        prepare_test(middle_code='''ramon = Knight()
//        slevin = Warrior()''',
//        test="fight(ramon, slevin)",
//                answer=True)
//                ],
        Warrior ramon  = new Knight();
        Warrior slevin = new Warrior();
        boolean result = Battle.fight(ramon , slevin);
        assertTrue(result);
    }

    @Test
    @DisplayName("3. Fight: Warrior vs Warrior, Winner should be Warrior One")
    void warriorVsWarrior() {
//        "3. Fight": [
//        prepare_test(middle_code='''bob = Warrior()
//        mars = Warrior()
//        fight(bob, mars)''',
//        test="bob.is_alive",
//                answer=True)
//                ],
        Warrior bob  = new Warrior();
        Warrior mars = new Warrior();
        boolean result = Battle.fight(bob , mars);
        assertTrue(result);
    }

    @Test
    @DisplayName("4. Fight: Knight vs Warrior, Knight should be alive")
    void knightVsWarriorCheckIfAliveKnight() {
//        "4. Fight": [
//        prepare_test(middle_code='''zeus = Knight()
//          godkiller = Warrior()
//      fight(zeus, godkiller)''',
//                     test="zeus.is_alive",
//                     answer=True)
//                ],
        Warrior zeus  = new Knight();
        Warrior godkiller = new Warrior();
        Battle.fight(zeus , godkiller);
        assertTrue(zeus.isAlive());
    }


    @Test
    @DisplayName("5. Fight: Warrior vs Warrior, Warrior Two should be dead")
    void warriorVsWarriorCheckIfAliveWarriorTwo() {
//      "5. Fight": [
//        prepare_test(middle_code='''husband = Warrior()
//          wife = Warrior()
//          fight(husband, wife)''',
//                     test="wife.is_alive",
//                     answer=False)
//                ],
        Warrior husband  = new Knight();
        Warrior wife = new Warrior();
        Battle.fight(husband , wife);
        assertFalse(wife.isAlive());
    }

    @Test
    @DisplayName("6. Fight: Warrior vs Knight, Knight should be Alive")
    void warriorVsKnightCheckIfAliveKnight() {
//    "6. Fight": [
//        prepare_test(middle_code='''dragon = Warrior()
//          knight = Knight()
//          fight(dragon, knight)''',
//                     test="knight.is_alive",
//                     answer=True)
//                ],
        Warrior dragon  = new Warrior();
        Warrior knight = new Knight();
        Battle.fight(dragon , knight);
        assertTrue(knight.isAlive());
    }

    @Test
    @DisplayName("7. Fight: Warrior vs Knight Vs Warrior, Knight should lose second battle")
    void warriorVsKnightVsWarriorCheckIfKnightLosesSecondBattle() {
//    "7. Fight": [
//        prepare_test(middle_code='''unit_1 = Warrior()
//          unit_2 = Knight()
//          unit_3 = Warrior()
//          fight(unit_1, unit_2)''',
//                     test="fight(unit_2, unit_3)",
//                     answer=False)
//                ]
        Warrior unit_1  = new Warrior();
        Warrior unit_2 = new Knight();
        Warrior unit_3 = new Warrior();

        Battle.fight(unit_1 , unit_2);
        boolean result = Battle.fight(unit_2 , unit_3);

        assertFalse(result);
    }





}