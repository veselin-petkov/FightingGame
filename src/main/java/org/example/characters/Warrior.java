package org.example.characters;

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

    public static void attack(Warrior warrior1, Warrior warrior2) {
        warrior2.setHealth(warrior2.getHealth() - warrior1.getAttack());
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
}
