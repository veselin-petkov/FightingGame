package org.example.characters;

import org.example.characters.stats.Health;

public interface IWarrior extends Health {

    void receiveDamage(int attack);

    int getINITIALHEALTH();

    int getAttack();

    void hit(IWarrior opponent);


    default void setHealth(int health){
        this.setHealth(health);
    }

    void equipWeapon(Weapon weapon);

}
