package org.example;

import org.example.characters.Warrior;
import org.example.characters.Weapon;

public class Main {
    public static void main(String[] args) {

        int a = 3, b = 25;
        int result = (a << 3) + (b >> 3);

        System.out.println(result);

        Weapon weapon = Weapon.builder().attack(20).health(20).defense(5).vampirism(20).healingPower(0).build();
        System.out.println(weapon.getAttack());

        Warrior voin = new Warrior();

        voin.equipWeapon(weapon);
        System.out.println(voin.getHealth());
    }
}