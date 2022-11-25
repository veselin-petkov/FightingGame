package org.example.combat;

import org.example.Army;
import org.example.characters.IWarrior;
import org.example.characters.Lancer;

public class Battle {

    public static boolean fight(IWarrior warrior1, IWarrior warrior2) {
        while (warrior1.isAlive() && warrior2.isAlive()) {

            warrior1.hit(warrior2);

            if (warrior2.isAlive()) {
                warrior2.hit(warrior1);
            } else {
                System.out.println("Winner: " + warrior1.getClass().getSimpleName() + "       |Health: " + warrior1.getHealth());
                return true;
            }
        }
        System.out.println("Winner: " + warrior2.getClass().getSimpleName() + "       |Health: " + warrior2.getHealth());
        return false;
    }

//    public static boolean fight(Army army1, Army army2) {
//        int army1Counter = 0;
//        int army2Counter = 0;
//        Warrior warrior3 = new Warrior();
//        while (true) {
//            boolean fightResult = false;
//            var warrior1 = army1.getTroops().get(army1Counter);
//            var warrior2 = army2.getTroops().get(army2Counter);
//
//            while (warrior1.isAlive() && warrior2.isAlive()) {
//                if (warrior1 instanceof Lancer) {
//                    if (army2Counter != army2.getTroops().size() - 1) {
//                        warrior3 = army2.getTroops().get(army2Counter + 1);
//                    }
//                    warrior3.receiveDamage(warrior1.hit(warrior2) / 2);
//                } else {
//                    warrior1.hit(warrior2);
//                }
//
//                if (warrior2.isAlive()) {
//                    if (warrior2 instanceof Lancer) {
//                        if (army1Counter != army1.getTroops().size() - 1) {
//                            warrior3 = army1.getTroops().get(army1Counter + 1);
//                        }
//
//                        warrior3.receiveDamage(warrior2.hit(warrior1) / 2);
//                    } else {
//                        warrior2.hit(warrior1);
//                    }
//                } else {
//                    System.out.println("Winner: " + warrior1.getClass().getSimpleName() + "       |Health: " + warrior1.getHealth());
//                    fightResult = true;
//                    break;
//                }
//            }
//
//            System.out.println("Army1: " + army1.getTroops().get(army1Counter).getClass().getSimpleName() + " " + army1Counter
//                    + " vs Army2: " + army2.getTroops().get(army2Counter).getClass().getSimpleName() + " " + army2Counter
//                    + " |        Winner: " + (fightResult ? "One" : "Two") + "   Remaining health: "
//                    + (fightResult ? army1.getTroops().get(army1Counter).getHealth() : army2.getTroops().get(army2Counter).getHealth()));
//
//            if (fightResult && army2Counter + 1 != army2.getTroops().size()) {
//                army2Counter++;
//            } else if (army1Counter + 1 == army1.getTroops().size() && !fightResult) {
//                return false;
//            } else if (army2Counter + 1 == army2.getTroops().size() && fightResult) {
//                break;
//            } else army1Counter++;
//        }
//        return true;
//    }

    public static boolean fight(Army army1, Army army2) {
        var it1 = army1.firstAliveIterator();
        var it2 = army2.firstAliveIterator();

        while (it1.hasNext() && it2.hasNext()) {
            var fighter1 = it1.next().getClass().getSimpleName();
            var fighter2 = it2.next().getClass().getSimpleName();

            boolean fightResult = fight(it1.next(), it2.next());


            System.out.println("Fight result: Army One: " + fighter1
                    + " vs Army Two: " + fighter2
                    + " |        Winner: " + (fightResult ? "Army One " + fighter1 : "Army Two " + fighter2));
        }

        System.out.println("Battle winner: " + (it1.hasNext() ? "Army One" : "Army Two"));
        return it1.hasNext();
    }


    public static boolean straightFight(Army army1, Army army2) {
        var it1 = army1.firstAliveIterator();
        var it2 = army2.firstAliveIterator();

        while (true) {
            var fighter1 = it1.next().getClass().getSimpleName();
            var fighter2 = it2.next().getClass().getSimpleName();
        }
    }


    //  NOT WORKING
    public static boolean battleNew(Army army1, Army army2) {
        var it1 = army1.firstAliveIterator();
        var it2 = army2.firstAliveIterator();

        while (it1.hasNext() && it2.hasNext()) {
            var fighter1 = it1.next().getClass().getSimpleName();
            var fighter2 = it2.next().getClass().getSimpleName();

            var warrior1 = it1.next();
            var warrior2 = it2.next();
            var warrior3 = it2.next();


            while (true) {
                if (warrior1 instanceof Lancer)
                   // warrior3.receiveDamage(warrior1.hit(warrior2) / 2);

                if (warrior2.isAlive()) {
                    warrior2.hit(warrior1);

                } else {
                    System.out.println("Winner: " + warrior1.getClass().getSimpleName() + "       |Health: " + warrior1.getHealth());
                    return true;
                }
            }


//            System.out.println("Fight result: Army One: " + fighter1
//                    + " vs Army Two: " + fighter2
//                    + " |        Winner: " + (fightResult ? "Army One " + fighter1 : "Army Two " + fighter2));
        }

        System.out.println("Battle winner: " + (it1.hasNext() ? "Army One" : "Army Two"));
        return it1.hasNext();
    }


}
