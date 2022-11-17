package org.example.combat;

import org.example.characters.Warrior;

public class Fight {

    public static boolean fight(Warrior warrior1, Warrior warrior2) {
        while (warrior1.isAlive() && warrior2.isAlive()) {

            warrior1.hit(warrior2);
            if (warrior2.isAlive()) {
                warrior2.hit(warrior1);
            } else {
                System.out.println("Winner: " + warrior1.getClass().getSimpleName() + "       |Health: " + warrior1.getHealth());
                return true;
            }
        }
        System.out.println("Winner: " + warrior2.getClass().getSimpleName() + "       |Health: " + warrior2.getHealth());
        return false;
    }
}