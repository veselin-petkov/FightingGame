package org.example.characters;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
@Slf4j
public class Warrior implements IWarrior {
    private int health;
    private int attack;
    private int INITIALHEALTH = 50;


    public Warrior() {
        this.health = 50;
        this.attack = 5;
    }

    public Warrior(int health, int attack) {
        this.health = health;
        this.attack = attack;
    }

    public void hit(IWarrior opponent) {
        int healthBefore = opponent.getHealth();
        opponent.receiveDamage(getAttack());
        int damageTaken = healthBefore - opponent.getHealth();
//        System.out.println(getClass().getSimpleName() + " hits " + opponent.getClass().getSimpleName()
//                + " for " + damageTaken + " damage |"
//                + opponent.getClass().getSimpleName() + " Remaining Health: " + opponent.getHealth());
        log.atDebug().log("{} hits {} for damage| {}  Remaining Health: {}",
                getClass().getSimpleName(),opponent.getClass().getSimpleName(),damageTaken,opponent.getClass().getSimpleName(),opponent.getHealth());

    }
    public void receiveDamage(int attack) {
        setHealth(getHealth() - attack);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        setHealth(getHealth() + weapon.getHealth());
        setAttack(getAttack() + weapon.getAttack());
        INITIALHEALTH = getHealth();
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getINITIALHEALTH() {
        return INITIALHEALTH;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Warrior warrior = (Warrior) o;
        return health == warrior.health && attack == warrior.attack;
    }


    @Override
    public int hashCode() {
        return Objects.hash(health, attack);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}