package org.example;

import org.example.characters.Warrior;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Army {
    public List<Warrior> troops = new ArrayList<>();

    Army addUnits(Supplier<Warrior> factory, int quantity) {
        for (int i = 0; i < quantity; i++) {
            troops.add(factory.get());
        }
        return this;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}