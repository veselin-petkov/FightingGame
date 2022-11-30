package org.example.characters;

import org.example.characters.stats.Defense;

import java.util.Objects;

public class Defender extends Warrior implements Defense {

    private int defense;

    private final int INITIALHEALTH = 60;

    public Defender() {
        super(60, 3);
        this.defense = 2;
    }

    public Defender(int health, int attack, int defense) {
        super(health, attack);
        this.defense = defense;
    }

    @Override
    public void receiveDamage(int attack) {
        super.receiveDamage(Math.max(0, attack - getDefense()));
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }


    @Override
    public void equipWeapon(Weapon weapon) {
        super.equipWeapon(weapon);
        setDefense(Math.max(0,getDefense()+ weapon.getDefense()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Defender defender = (Defender) o;
        return defense == defender.defense;
    }

    @Override
    public int getINITIALHEALTH() {
        return INITIALHEALTH;
    }

    @Override
    public int hashCode() {
        return Objects.hash(defense);
    }
}
