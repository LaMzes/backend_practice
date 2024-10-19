package main.Entities;

public class SmotanMob extends Creature{

    private static final int STARTING_LIFE = 20;
    private static final int STARTING_DAMAGE = 2;
    private static final int STARTING_ARMOUR = 0;

    public SmotanMob(){
        super();
        this.life = STARTING_LIFE;
        this.damage = STARTING_DAMAGE;
        this.armour = STARTING_ARMOUR;
    }
}
