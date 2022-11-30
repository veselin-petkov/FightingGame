package org.example.characters.stats;

public interface Health {

   int getHealth();
   default boolean isAlive(){
       return getHealth()>0;
   }
}
