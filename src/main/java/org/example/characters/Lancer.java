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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Lancer lancer = (Lancer) o;

        return PIERCING_POWER == lancer.PIERCING_POWER;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + PIERCING_POWER;
        return result;
    }
}
