package org.example.characters;

import java.util.Objects;

public class Defender extends Warrior {

    private int defense;

    public Defender() {
        super(60, 3);
        this.defense = 2;
    }

    @Override
    public void receiveDamage(int attack) {
        if (attack - getDefense() > 0) {
            super.receiveDamage(attack - getDefense());
        } else super.receiveDamage(0);

    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Defender defender = (Defender) o;
        return defense == defender.defense;
    }

    @Override
    public int hashCode() {
        return Objects.hash(defense);
    }
}
