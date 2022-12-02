package org.example.characters;

import org.example.Army;
import org.example.characters.stats.HealingPower;
import org.example.services.CanProcessCommand;
import org.example.services.CharacterHitCommand;
import org.example.services.Command;

public class Healer extends Warrior implements HealingPower,CanProcessCommand {

    private int healingPower;


    public Healer() {
        super(60, 0);
        this.healingPower = 2;

    }

    @Override
    public void processCommand(Command command, Army.WarriorInArmy sender) {
        if (command instanceof CharacterHitCommand) {
            heal(sender);
        }
    }

    public void heal(Army.WarriorInArmy warrior) {

        int healthBefore = warrior.getHealth();
        warrior.setHealth(Math.min(warrior.getINITIALHEALTH(), warrior.getHealth() + getHealingPower()));
        int healedAmount = warrior.getHealth() - healthBefore;
        //System.out.println(getClass().getSimpleName() + " heals the " + warrior.getClass().getSimpleName() + " for " + healedAmount);


    }

    @Override
    public void hit(IWarrior opponent) {
       //do nothing because it has no attack points
    }

    public int getHealingPower() {
        return healingPower;
    }

    public void setHealingPower(int healingPower) {
        this.healingPower = healingPower;
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        super.equipWeapon(weapon);
        setHealingPower(Math.max(0,getHealingPower()+weapon.getHealingPower()));
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
