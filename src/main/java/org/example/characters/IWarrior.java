package org.example.characters;

import org.example.characters.stats.Health;

public interface IWarrior extends Health {

    void receiveDamage(int attack);

    int getINITIALHEALTH();

    int getAttack();

    default void hit(IWarrior opponent) {
        int healthBefore = opponent.getHealth();
        opponent.receiveDamage(getAttack());
        int damageTaken = healthBefore - opponent.getHealth();
        System.out.println(getClass().getSimpleName() + " hits " + opponent.getClass().getSimpleName()
                + " for " + damageTaken + " damage |"
                + opponent.getClass().getSimpleName() + " Remaining Health: " + opponent.getHealth());

    }

    default void setHealth(int health){
        this.setHealth(health);
    }

    void equipWeapon(Weapon weapon);

}
