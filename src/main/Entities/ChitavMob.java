package main.Entities;

public class ChitavMob extends Creature{

    private static final int STARTING_LIFE = 80;
    private static final int STARTING_DAMAGE = 4;
    private static final int STARTING_ARMOUR = 2;

    public ChitavMob(){
        this.life = STARTING_LIFE;
        this.damage = STARTING_DAMAGE;
        this.armour = STARTING_ARMOUR;
    }
}
