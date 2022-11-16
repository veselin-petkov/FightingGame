package org.example.characters;

public class Vampire extends Warrior {

    private int vampirism;

    public Vampire() {
        super(40, 4);
        this.vampirism = 50;
    }

    private void heal(int amount){
        this.setHealth(getHealth()+amount);
    }
    @Override
    public void hit(Warrior opponent) {
        int damageTaken = opponent.getHealth();
        opponent.receiveDamage(getAttack());

        int leech = (int) ((damageTaken - opponent.getHealth()) * ((double)vampirism/100));
        this.heal(leech);

        System.out.println(getClass().getSimpleName() + " hits " + opponent.getClass().getSimpleName()
                + " for " + (damageTaken - opponent.getHealth()) + " damage |"
                + opponent.getClass().getSimpleName() + " Remaining Health: " + opponent.getHealth() +
                " Vampire leeched health: " + leech);
    }
}
