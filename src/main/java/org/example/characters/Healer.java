package org.example.characters;

import lombok.extern.slf4j.Slf4j;
import org.example.Army;
import org.example.characters.stats.HealingPower;
import org.example.services.CanProcessCommand;
import org.example.services.CharacterHitCommand;
import org.example.services.Command;
@Slf4j
public class Healer extends Warrior implements HealingPower,CanProcessCommand {

    private int healingPower;
    private int INITIALHEALTH = 60;

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
        if (healthBefore > 0) {
            warrior.setHealth(Math.min(warrior.getINITIALHEALTH(), warrior.getHealth() + getHealingPower()));
        }
        int healedAmount = warrior.getHealth() - healthBefore;
        //System.out.println(getClass().getSimpleName() + " heals the " + warrior.getClass().getSimpleName() + " for " + healedAmount);
        log.atDebug().log("{} heals the {} for {}",getClass().getSimpleName(),warrior.getClass().getSimpleName(),healedAmount);
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
    public int getINITIALHEALTH() {
        return INITIALHEALTH;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
