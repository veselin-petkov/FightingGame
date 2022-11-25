package org.example.characters;

public class Lancer extends Warrior {

    int PIERCING_POWER = 50;

    public Lancer() {
        super(50, 6);
    }


    @Override
    public void hit(IWarrior opponent) {
        int healthBeforeHit = opponent.getHealth();

        super.hit(opponent);
        int damageDone = healthBeforeHit - opponent.getHealth();
        if (opponent instanceof HasWarriorBehind opponentWithNext) {
            IWarrior nextWarrior = opponentWithNext.getNextBehind();
            if (nextWarrior != null) {
                nextWarrior.receiveDamage(damageDone * PIERCING_POWER / 100);
            }
        }
    }
}
