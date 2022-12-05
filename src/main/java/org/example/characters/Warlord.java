package org.example.characters;

public class Warlord extends Defender{

    private int INITIALHELTH = 100;
    public Warlord() {
        super(100,4,2);
    }


    public int getINITIALHELTH() {
        return INITIALHELTH;
    }
}
