package org.example.combat;

import org.example.characters.Defender;
import org.example.characters.Warrior;

//import static org.example.characters.Warrior.attack;

public class Fight {

    public static void oldAttack(Warrior attacker, Warrior defender) {
        if (defender.getClass().equals(Defender.class)) {
            if (attacker.getAttack() > ((Defender) defender).getDefense()) {
                defender.setHealth(defender.getHealth() - (attacker.getAttack() - ((Defender) defender).getDefense()));
                System.out.println(attacker.getClass().getSimpleName() + " hits " + defender.getClass().getSimpleName()
                        + " for " + (attacker.getAttack() - ((Defender) defender).getDefense()) + " damage |"
                        + defender.getClass().getSimpleName() + " Remaining Health: " + defender.getHealth());
            } else {
                System.out.println(attacker.getClass().getSimpleName() + " hits " + defender.getClass().getSimpleName()
                        + " for 0 damage |" + defender.getClass().getSimpleName() + " Remaining Health: " + defender.getHealth());
            }
        } else {
            defender.setHealth(defender.getHealth() - attacker.getAttack());
            System.out.println(attacker.getClass().getSimpleName() + " hits " + defender.getClass().getSimpleName()
                    + " for " + attacker.getAttack() + " damage |" + defender.getClass().getSimpleName() + " Remaining Health: " + defender.getHealth());
        }
    }

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