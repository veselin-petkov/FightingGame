package org.example.characters;

import java.util.Objects;

public class Warrior {
    private int health;
    private int attack;


    public Warrior() {
        this.health = 50;
        this.attack = 5;
    }

    public Warrior(int health, int attack) {
        this.health = health;
        this.attack = attack;
    }


    public void hit(Warrior opponent) {
        int damageTaken = opponent.getHealth();
        opponent.receiveDamage(getAttack());
        System.out.println(getClass().getSimpleName() + " hits " + opponent.getClass().getSimpleName()
                + " for " + (damageTaken - opponent.getHealth()) + " damage |"
                + opponent.getClass().getSimpleName() + " Remaining Health: " + opponent.getHealth());
    }

    public void receiveDamage(int attack) {
        setHealth(getHealth() - attack);
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
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