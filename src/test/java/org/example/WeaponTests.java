package org.example;

import org.example.characters.*;
import org.example.characters.weapons.*;
import org.example.combat.Battle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WeaponTests {

    @BeforeEach
    public void setup() {

    }

    @Test
    @DisplayName("1. Weapon: Warrior vs Knight, Winner should be Knight")
    void warriorWeaponVsVampireSword() {
        var warrior = new Warrior();
        var vampire = new Vampire();
        Weapon weapon = new Weapon(-10, 5, 0, 40, 0);
        Weapon sword = new Sword();
        warrior.equipWeapon(weapon);
        vampire.equipWeapon(sword);
        assertTrue(Battle.fight(warrior, vampire));
    }

    @Test
    @DisplayName("2. Weapon: Defender with Shield vs Lancer WithGreat Axe, Winner should be Lancer")
    void defenderWithShieldVsLancerWithGreatAxe() {
        var defender = new Defender();
        var lancer = new Lancer();
        Weapon shield = new Shield();
        Weapon greatAxe = new GreatAxe();
        defender.equipWeapon(shield);
        lancer.equipWeapon(greatAxe);
        assertFalse(Battle.fight(defender, lancer));
    }

    @Test
    @DisplayName("3. Weapon: Healer With MagicWand  vs Knight with Katana , Winner should be Knight ")
    void healerWithMagicWandVsKnightwithKatana() {
        var healer = new Healer();
        var knight = new Knight();
        healer.equipWeapon(new MagicWand());
        knight.equipWeapon(new Katana());

        assertFalse(Battle.fight(healer, knight));
    }

    @Test
    @DisplayName("4. Weapon:  vs , Winner should be ")
    void defenderWithShieldAndMagicWandVsVampirewithShieldAndKatana() {
        var defender = new Defender();
        var vampire = new Vampire();
        defender.equipWeapon(new Shield());
        defender.equipWeapon(new MagicWand());
        vampire.equipWeapon(new Shield());
        vampire.equipWeapon(new Katana());
        assertFalse(Battle.fight(defender, vampire));
    }

    @Test
    @DisplayName("5. Weapon:  vs , Winner should be ")
    void magicWandsVsGreatAxeAndArmies() {
        Weapon weapon1 = new MagicWand();
        Weapon weapon2 = new GreatAxe();
        Army army1 = new Army().addUnits(Knight::new, 1).addUnits(Lancer::new, 1);
        Army army2 = new Army().addUnits(Vampire::new, 1).addUnits(Healer::new, 1);
        army1.equipWarriorAtPosition(0, weapon1);
        army1.equipWarriorAtPosition(1, weapon2);
        army2.equipWarriorAtPosition(0, weapon1);
        army2.equipWarriorAtPosition(1, weapon2);
        assertTrue(Battle.fight(army1, army2));
    }

    @Test
    @DisplayName("6. Weapon:  vs , Winner should be ")
    void weapon6Armies() {
        Weapon weapon1 = new Sword();
        Weapon weapon2 = new GreatAxe();
        Army army1 = new Army().addUnits(Defender::new, 1).addUnits(Warrior::new, 1);
        Army army2 = new Army().addUnits(Knight::new, 1).addUnits(Healer::new, 1);
        army1.equipWarriorAtPosition(0, weapon2);
        army1.equipWarriorAtPosition(1, weapon2);
        army2.equipWarriorAtPosition(0, weapon1);
        army2.equipWarriorAtPosition(1, weapon1);
        assertTrue(Battle.fight(army1, army2));
    }


    @Test
    @DisplayName("7. Weapon:  vs , Winner should be ")
    void weapon7Armies() {
        Weapon weapon1 = new Katana();
        Weapon weapon2 = new Shield();
        Army army1 = new Army().addUnits(Defender::new, 2);
        Army army2 = new Army().addUnits(Knight::new, 1).addUnits(Vampire::new, 1);
        army1.equipWarriorAtPosition(0, weapon1);
        army1.equipWarriorAtPosition(1, weapon1);
        army2.equipWarriorAtPosition(0, weapon1);
        army2.equipWarriorAtPosition(1, weapon1);
        assertFalse(Battle.fight(army1, army2));
    }


    @Test
    @DisplayName("8. Weapon:  vs , Winner should be ")
    void weapon8() {
        Weapon weapon1 = new Weapon(-20, 6, 1, 40, -2);
        Weapon weapon2 = new Weapon(20, -2, 2, -55, 3);
        Army army1 = new Army().addUnits(Knight::new, 3);
        Army army2 = new Army().addUnits(Warrior::new, 1).addUnits(Defender::new, 2);
        army1.equipWarriorAtPosition(0, weapon1);
        army1.equipWarriorAtPosition(1, weapon1);
        army1.equipWarriorAtPosition(2, weapon2);
        army2.equipWarriorAtPosition(0, weapon1);
        army2.equipWarriorAtPosition(1, weapon2);
        army2.equipWarriorAtPosition(2, weapon2);
        assertTrue(Battle.fight(army1, army2));
    }

    @Test
    @DisplayName("9. Weapon:  vs , Winner should be ")
    void weapon9() {
        Weapon weapon1 = new Weapon(-20, 1, 1, 40, -2);
        Weapon weapon2 = new Weapon(20, -2, 2, -55, 3);
        Army army1 = new Army().addUnits(Vampire::new, 3);
        Army army2 = new Army().addUnits(Warrior::new, 1).addUnits(Defender::new, 2);
        army1.equipWarriorAtPosition(0, weapon1);
        army1.equipWarriorAtPosition(1, weapon1);
        army1.equipWarriorAtPosition(2, weapon2);
        army2.equipWarriorAtPosition(0, weapon1);
        army2.equipWarriorAtPosition(1, weapon2);
        army2.equipWarriorAtPosition(2, weapon2);
        assertFalse(Battle.straightFight(army1, army2));
    }

    @Test
    @DisplayName("10. Weapon:  vs , Winner should be ")
    void weapon10() {
        Weapon weapon1 = new Katana();
        Weapon weapon2 = new Shield();
        Army army1 = new Army().addUnits(Vampire::new, 2).addUnits(FightTest.Rookie::new, 2);
        Army army2 = new Army().addUnits(Warrior::new, 1).addUnits(Defender::new, 2);
        army1.equipWarriorAtPosition(0, weapon2);
        System.out.println(army1.getTroops().get(0).getAttack());
        army1.equipWarriorAtPosition(0, weapon1);
        army1.equipWarriorAtPosition(1, weapon1);
        army1.equipWarriorAtPosition(2, weapon2);
        army2.equipWarriorAtPosition(0, weapon1);
        army2.equipWarriorAtPosition(1, weapon2);
        army2.equipWarriorAtPosition(2, weapon2);
        assertTrue(Battle.straightFight(army1, army2));
    }

    @Test
    @DisplayName("11. Weapon:  vs , Winner should be ")
    void weapon11() {
        Weapon weapon1 = new Sword();
        Weapon weapon2 = new GreatAxe();
        Army army1 = new Army().addUnits(Vampire::new, 3);
        Army army2 = new Army().addUnits(Warrior::new, 1).addUnits(Defender::new, 1);
        army1.equipWarriorAtPosition(1, weapon2);
        army1.equipWarriorAtPosition(2, weapon2);
        army2.equipWarriorAtPosition(0, weapon1);
        army2.equipWarriorAtPosition(1, weapon1);
        assertTrue(Battle.straightFight(army1, army2));
    }

    @Test
    @DisplayName("12. Weapon:  vs , Winner should be ")
    void weapon12() {
        Weapon weapon1 = new Sword();
        Weapon weapon2 = new MagicWand();
        Army army1 = new Army().addUnits(FightTest.Rookie::new, 3);
        Army army2 = new Army().addUnits(Defender::new, 1).addUnits(Healer::new, 1);
        army1.equipWarriorAtPosition(0, weapon1);
        army1.equipWarriorAtPosition(1, weapon1);
        army1.equipWarriorAtPosition(2, weapon1);
        army2.equipWarriorAtPosition(0, weapon2);
        army2.equipWarriorAtPosition(1, weapon2);
        assertFalse(Battle.straightFight(army1, army2));
    }
}