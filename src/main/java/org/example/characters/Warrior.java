package org.example.characters;

import java.util.Objects;

public class Warrior implements IWarrior {
    private int health;
    private int attack;
    private final int INITIALHEALTH = 50;


    public Warrior() {
        this.health = 50;
        this.attack = 5;
    }

    public Warrior(int health, int attack) {
        this.health = health;
        this.attack = attack;
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