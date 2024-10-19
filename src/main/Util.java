package main;

import java.util.Random;

public class Util {

    public static int randomHealth(){
        return new Random().nextInt(10, 1000);
    }
    public static int randomArmour(){
        return new Random().nextInt(10,100);
    }
    public static int randomDamage(){
        return new Random().nextInt(50,100);
    }
    public static int randomPrice(){
        return new Random().nextInt(20,50);
    }
}
