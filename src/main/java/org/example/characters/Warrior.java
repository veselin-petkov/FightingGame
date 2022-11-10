package org.example.characters;

public class Warrior {
    private int health = 50;
    private int attack = 5;


    public Warrior() {
    }

    public boolean isAlive() {
        if (health > 0) {
            return true;
        } else return false;
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
}
