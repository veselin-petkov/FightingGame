package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.characters.*;
import org.example.services.CanProcessCommand;
import org.example.services.CharacterHitCommand;
import org.example.services.Command;

import java.util.*;
import java.util.function.Supplier;


@Slf4j
public class Army {

    public static class WarriorInArmy implements IWarrior, HasWarriorBehind, CanProcessCommand {
        public IWarrior warrior;
        WarriorInArmy nextWarrior;

        public WarriorInArmy(IWarrior warrior) {
            this.warrior = warrior;
        }

        @Override
        public void hit(IWarrior opponent) {

            warrior.hit(opponent);
            processCommand(CharacterHitCommand.HEAL, this);
        }

        public Warrior unwrap() {
            return (Warrior) warrior;

        }

        @Override
        public void processCommand(Command command, WarriorInArmy sender) {
            if (warrior instanceof CanProcessCommand war) {
                war.processCommand(command, sender);
            }
            if (nextWarrior != null && nextWarrior.isAlive()) {
                nextWarrior.processCommand(command, this);
            }
        }

        public void setHealth(int health) {
            warrior.setHealth(health);
        }

        @Override
        public void equipWeapon(Weapon weapon) {
            warrior.equipWeapon(weapon);
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
        public WarriorInArmy getNextBehind() {
            return nextWarrior;
        }

        private void setNextWarrior(WarriorInArmy nextWarrior) {
            this.nextWarrior = nextWarrior;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            WarriorInArmy that = (WarriorInArmy) o;

            if (!warrior.equals(that.warrior)) return false;
            return nextWarrior.equals(that.nextWarrior);
        }

        @Override
        public String toString() {
            return warrior.getClass().getSimpleName();
        }
    }

    public Iterator<IWarrior> firstAliveIterator() {
        return new FirstAliveIterator();

    }

    class FirstAliveIterator implements Iterator<IWarrior> {
        Iterator<IWarrior> iterator = troops.iterator();
        IWarrior champion = iterator.next();

        @Override
        public boolean hasNext() {
            if (champion == null || !champion.isAlive()) {
                if (iterator.hasNext()) {
                    champion = iterator.next();
                    if (champion.isAlive()) {
                        return true;
                    }
                }
                return false;
            }
            return true;
//            while (champion != null) {
//                if (champion.isAlive()) {
//                    System.out.println("true");
//                    return true;
//                } else {
//                    if (iterator().hasNext()) {
//                        champion = iterator.next();
//                    }
//                }
//            }
//            return false;
        }

        @Override
        public IWarrior next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            //return ((WarriorInArmy) champion).unwrap();
            return champion;
        }
    }

    public Iterator<IWarrior> iterator() {
        return new ArmyIterator();

    }

    class ArmyIterator implements Iterator<IWarrior> {
        Iterator<IWarrior> iterator = troops.iterator();
        IWarrior nextAlive;

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public IWarrior next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            nextAlive = iterator.next();
            return ((WarriorInArmy) nextAlive).unwrap();
            //return nextAlive;
        }
    }

    private List<IWarrior> troops = new ArrayList<>();
    private WarriorInArmy lastWarrior;
    public boolean haveWarlord = false;


    public void removeDead() {
        troops.removeIf(iWarrior -> !iWarrior.isAlive());
    }


    private void addUnits(Warrior warrior) {
        if (warrior instanceof Warlord) {
            WarriorInArmy wrapped = new WarriorInArmy(warrior);
            if (lastWarrior != null) {
                lastWarrior.setNextWarrior(wrapped);
            }
            lastWarrior = wrapped;
            troops.add(wrapped);
            haveWarlord = true;
            return;
        }

        WarriorInArmy wrapped = new WarriorInArmy(warrior);
        if (lastWarrior != null) {
            lastWarrior.setNextWarrior(wrapped);
        }
        lastWarrior = wrapped;
        troops.add(wrapped);
    }

    Army addUnits(Supplier<Warrior> factory, int quantity) {
        if (factory.get() instanceof Warlord) {
            WarriorInArmy wrapped = new WarriorInArmy(factory.get());
            if (lastWarrior != null) {
                lastWarrior.setNextWarrior(wrapped);
            }
            lastWarrior = wrapped;
            troops.add(wrapped);
            haveWarlord = true;
            return this;
        }

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

    public Army moveArmy() {
        Army rearrangedArmy = new Army();
        List<IWarrior> lancers = getTroops().stream().filter(el -> el.toString().equals("Lancer")).toList();


        List<IWarrior> healers = troops.stream().filter(el -> el.toString().equals("Healer")).toList();
        List<IWarrior> fighters = troops.stream().filter(el -> !(el.toString().equals("Lancer") || el.toString().equals("Healer") || el.toString().equals("Warlord"))).toList();


        if (!lancers.isEmpty()) {
            log.atDebug().log("Adding lancer first");
            WarriorInArmy wrapper = (WarriorInArmy) lancers.get(0);
            Warrior unwrapper = wrapper.unwrap();
            rearrangedArmy.addUnits(unwrapper);

        } else if (!fighters.isEmpty()) {
            log.atDebug().log("There is no lancer so we get first fighter");
            WarriorInArmy wrapper = (WarriorInArmy) fighters.get(0);
            Warrior unwrapper = wrapper.unwrap();
            rearrangedArmy.addUnits(unwrapper);
        }
        for (var el : healers) {
            log.atDebug().log("Then we add healers");
            WarriorInArmy wrapper = (WarriorInArmy) el;
            Warrior unwrapper = wrapper.unwrap();
            rearrangedArmy.addUnits(unwrapper);
        }

        if (lancers.size() != 1 && !lancers.isEmpty()) {
            for (int i = 1; i < lancers.size(); i++) {
                log.atDebug().log("Then the rest of the lancers ");
                WarriorInArmy wrapper = (WarriorInArmy) lancers.get(i);
                Warrior unwrapper = wrapper.unwrap();
                rearrangedArmy.addUnits(unwrapper);
            }
            for (var el : fighters) {
                log.atDebug().log("Then the rest of the fighters ");
                WarriorInArmy wrapper = (WarriorInArmy) el;
                Warrior unwrapper = wrapper.unwrap();
                rearrangedArmy.addUnits(unwrapper);
            }
        } else if (lancers.isEmpty()) {
            for (int i = 1; i < fighters.size(); i++) {
                log.atDebug().log("If no lancers add fighters from second");
                WarriorInArmy wrapper = (WarriorInArmy) fighters.get(i);
                Warrior unwrapper = wrapper.unwrap();
                rearrangedArmy.addUnits(unwrapper);
            }
        }

        Optional<IWarrior> matchingObject = troops.stream().
                filter(el -> el.toString().equals("Warlord")).findFirst();

        if (!matchingObject.isEmpty()) {

            log.atDebug().log("And finally warlord ");
            WarriorInArmy wrapper = (WarriorInArmy) matchingObject.get();
            Warrior unwrapper = wrapper.unwrap();
            //System.out.println(unwrapper);
            rearrangedArmy.addUnits(unwrapper);
        }

        this.troops = rearrangedArmy.troops;
        this.lastWarrior = rearrangedArmy.lastWarrior;

        return rearrangedArmy;
    }


    public void equipWarriorAtPosition(int position, Weapon weapon) {
        troops.get(position).equipWeapon(weapon);
    }

    public List<IWarrior> getTroops() {
        return troops;
    }

    @Override
    public String toString() {
        return "Army{" +
                "troops=" + troops +
                '}';
    }
}