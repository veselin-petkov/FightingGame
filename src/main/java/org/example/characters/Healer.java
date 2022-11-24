package org.example.characters;

public class Healer extends Warrior{

    private int healingPower;

    public Healer() {
        super(60, 0);
        this.healingPower = 2;
    }

    public void heal(Warrior warrior){
        warrior.setHealth(Math.min(warrior.getINITIALHEALTH(), warrior.getHealth())+getHealingPower());
    }

    @Override
    public int hit(IWarrior opponent) {
        return 0;
    }

    protected int getHealingPower() {
        return healingPower;
    }
}
