package main.Entities;

public class Spaska extends Creature{

    private static final int STARTING_LIFE = 10000;
    private static final int STARTING_DAMAGE = 100;
    private static final int STARTING_ARMOUR = 50;

    public Spaska(){
        super();
        this.life = STARTING_LIFE;
        this.damage = STARTING_DAMAGE;
        this.armour = STARTING_ARMOUR;
    }
}
