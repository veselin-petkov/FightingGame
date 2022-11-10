package org.example.characters;

public class Battle {

    public static boolean fight(Warrior warrior1,Warrior warrior2) {
        while (warrior1.isAlive()) {

            warrior2.setHealth(warrior2.getHealth()- warrior1.getAttack());
            if (warrior2.isAlive()) {
                warrior1.setHealth(warrior1.getHealth()- warrior2.getAttack());
            } else return true;

        }
        return false;
    }
}
