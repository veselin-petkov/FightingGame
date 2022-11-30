package org.example.characters;

import org.example.characters.stats.Vampirism;

public class Vampire extends Warrior implements Vampirism {

    private int vampirism;
    private final int INITIALHEALTH = 40;


    public Vampire() {
        super(40, 4);
        this.vampirism = 50;
    }

    private void heal(int amount) {
        this.setHealth(Math.min(INITIALHEALTH, getHealth() + amount));
    }

    @Override
    public void hit(IWarrior opponent) {
        int healthBeforeHit = opponent.getHealth();
        opponent.receiveDamage(getAttack());
        int leech = 0;

        if (getHealth() != getINITIALHEALTH()) {
            leech = ((healthBeforeHit - opponent.getHealth()) * getVampirism() / 100);
        }
        this.heal(leech);
        System.out.println(getClass().getSimpleName() + " hits " + opponent.getClass().getSimpleName()
                + " for " + (healthBeforeHit - opponent.getHealth()) + " damage |"
                + opponent.getClass().getSimpleName() + " Remaining Health: " + opponent.getHealth() +
                " Vampire leeched health: " + leech);
    }

    @Override
    public int getINITIALHEALTH() {
        return INITIALHEALTH;
    }

    public void setVampirism(int vampirism) {
        this.vampirism = vampirism;
    }

    public int getVampirism() {
        return vampirism;
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        super.equipWeapon(weapon);
        setVampirism(Math.max(0, getVampirism() + weapon.getVampirism()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Vampire vampire = (Vampire) o;

        if (vampirism != vampire.vampirism) return false;
        return INITIALHEALTH == vampire.INITIALHEALTH;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + vampirism;
        result = 31 * result + INITIALHEALTH;
        return result;
    }
}
