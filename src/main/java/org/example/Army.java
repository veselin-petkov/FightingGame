package org.example;

import org.example.characters.*;
import org.example.services.CanProcessCommand;
import org.example.services.CharacterHitCommand;
import org.example.services.Command;

import java.util.*;
import java.util.function.Supplier;


public class Army {

   public static class WarriorInArmy implements IWarrior, HasWarriorBehind, CanProcessCommand {
        IWarrior warrior;
        WarriorInArmy nextWarrior;

        public WarriorInArmy(IWarrior warrior) {
            this.warrior = warrior;
        }

        @Override
        public void hit(IWarrior opponent) {

          warrior.hit(opponent);
          processCommand(CharacterHitCommand.HEAL,this);
        }

        public Warrior unwrap(){
            return (Warrior) warrior;

        }

        @Override
        public void processCommand(Command command, WarriorInArmy sender) {
            if (warrior instanceof CanProcessCommand war) {
                war.processCommand(command, sender);
            }
            if (nextWarrior != null) {
                nextWarrior.processCommand(command, this);
            }
        }

        public void setHealth(int health){
            warrior.setHealth(health);
        }
        @Override
        public int getHealth() {
            return warrior.getHealth();
        }

        @Override
        public void receiveDamage(int attack) {
            warrior.receiveDamage(attack);
        }

        @Override
        public int getINITIALHEALTH() {
            return warrior.getINITIALHEALTH();
        }

        @Override
        public int getAttack() {
            return warrior.getAttack();
        }

        @Override
        public IWarrior getNextBehind() {
            return nextWarrior;
        }

        private void setNextWarrior(WarriorInArmy nextWarrior) {
            this.nextWarrior = nextWarrior;
        }
    }

    public Iterator<IWarrior> firstAliveIterator() {
        return new FirstAliveIterator();

    }

    class FirstAliveIterator implements Iterator<IWarrior> {
        Iterator<IWarrior> iterator = troops.iterator();
        IWarrior champion;

        @Override
        public boolean hasNext() {
            if (champion == null || !champion.isAlive()) {
                if (iterator.hasNext()) {
                    champion = iterator.next();
                    return true;
                }
                return false;
            }
            return true;

//            while (iterator.hasNext()) {
//                champion = iterator.next();
//                if (champion.isAlive()) return true;
//            }
//            return false;
        }

        @Override
        public IWarrior next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return champion;
        }
    }

    private Collection<IWarrior> troops = new ArrayList<>();
    private WarriorInArmy lastWarrior;


    void removeDead(){
        troops.removeIf(iWarrior -> !iWarrior.isAlive());
    }


    private void addUnits(Warrior warrior) {
        WarriorInArmy wrapped = new WarriorInArmy(warrior);
        if (lastWarrior != null) {
            lastWarrior.setNextWarrior(wrapped);
        }
        lastWarrior = wrapped;
        troops.add(warrior);
    }

    Army addUnits(Supplier<Warrior> factory, int quantity) {
        for (int i = 0; i < quantity; i++) {
            WarriorInArmy wrapped = new WarriorInArmy(factory.get());
            if (lastWarrior != null) {
                lastWarrior.setNextWarrior(wrapped);
            }
            lastWarrior = wrapped;
            troops.add(wrapped);
        }
        return this;
    }

    public Collection<IWarrior> getTroops() {
        return troops;
    }


    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}