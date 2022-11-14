package org.example.combat;

import org.example.Army;

public class Battle extends Fight {

    public static boolean battle(Army army1, Army army2) {
        int army1Counter = 0;
        int army2Counter = 0;
        while (true) {

            boolean fightResult = fight(army1.getTroops().get(army1Counter), army2.getTroops().get(army2Counter));

            System.out.println("Army1: " + army1.getTroops().get(army1Counter).getClass().getSimpleName() + " " + army1Counter
                    + " vs Army2: " + army2.getTroops().get(army2Counter).getClass().getSimpleName() + " " + army2Counter
                    + " |        Winner: " + (fightResult ? "One" : "Two") + "   Remaining health: "
                    + (fightResult ? army1.getTroops().get(army1Counter).getHealth() : army2.getTroops().get(army2Counter).getHealth()));

            if (fightResult && army2Counter + 1 != army2.getTroops().size()) {
                army2Counter++;
            } else if (army1Counter + 1 == army1.getTroops().size() && !fightResult) {
                return false;
            } else if (army2Counter + 1 == army2.getTroops().size() && fightResult) {
                break;
            } else army1Counter++;
        }
        return true;
    }
}
