package org.example.services;

import org.example.Army;
import org.example.services.Command;

public interface CanProcessCommand {
    default void processCommand(Command command, Army.WarriorInArmy sender) {
    }
}
