package org.example.characters;

public interface IWarrior {

    int getHealth();

    default boolean isAlive() {
        return getHealth() > 0;
    }

    void receiveDamage(int attack);

    int getINITIALHEALTH();

    int getAttack();

    default int hit(IWarrior opponent) {
        int healthBefore = opponent.getHealth();
        opponent.receiveDamage(getAttack());
        int damageTaken = healthBefore -opponent.getHealth();
        System.out.println(getClass().getSimpleName() + " hits " + opponent.getClass().getSimpleName()
                + " for " + damageTaken  + " damage |"
                + opponent.getClass().getSimpleName() + " Remaining Health: " + opponent.getHealth());
        return damageTaken;
    }
}