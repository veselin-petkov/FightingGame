package org.example.characters;


public interface Command {
}

public enum CharacterHitCommand implements Command {
    INSTANCE
}

public interface CanProcessCommand {
    default void processCommand(Command command, IWarrior sender) {
    }
}

public interface IWarrior extends CanProcessCommand {

    int getHealth();

    default boolean isAlive() {
        return getHealth() > 0;
    }

    void receiveDamage(int attack);

    int getINITIALHEALTH();

    int getAttack();

    default int hit(IWarrior opponent) {
        opponent.receiveDamage(getAttack());
        return 0;
    }
}
