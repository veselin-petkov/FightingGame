package org.example.combat;

import org.example.characters.Warrior;

import static org.example.characters.Warrior.attack;

public class Fight {

    public static boolean fight(Warrior warrior1, Warrior warrior2) {
        while (warrior1.isAlive()) {

//            warrior2.setHealth(warrior2.getHealth()- warrior1.getAttack());
//            if (warrior2.isAlive()) {
//                warrior1.setHealth(warrior1.getHealth()- warrior2.getAttack());
//            } else return true;

            attack(warrior1,warrior2);
            if (warrior2.isAlive()) {
                attack(warrior2,warrior1);
            } else return true;
        }
        return false;
    }


}