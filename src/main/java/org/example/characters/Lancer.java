package org.example.characters;

public class Lancer extends Warrior {

    int PIERCING_POWER = 50;

    public Lancer() {
        super(50, 6);
    }


    @Override
    public int hit(IWarrior opponent) {

        int damageDone = super.hit(opponent);
        if (opponent instanceof HasWarriorBehind opponentWithNext) {
            IWarrior nextWarrior = opponentWithNext.getNextBehind();
            if (nextWarrior != null) {
                nextWarrior.receiveDamage(damageDone * PIERCING_POWER / 100);
            }
        }
        return damageDone;
    }
}
