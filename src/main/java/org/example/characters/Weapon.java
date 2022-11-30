package org.example.characters;

import lombok.Builder;
import org.example.characters.stats.*;

@Builder
public class Weapon implements Attack, Health, HealingPower, Defense, Vampirism {

    private int attack;
    private int health;
    private int defense;
    private int healingPower;
    private int vampirism;

    public Weapon() {
    }

    public Weapon(int health,int attack, int defense, int vampirism, int healingPower) {
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.vampirism = vampirism;
        this.healingPower = healingPower;
    }

    @Override
    public int getAttack() {
        return attack;
    }

    @Override
    public int getDefense() {
        return defense;
    }

    @Override
    public int getHealingPower() {
        return healingPower;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getVampirism() {
        return vampirism;
    }
}
