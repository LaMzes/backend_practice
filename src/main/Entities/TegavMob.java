package main.Entities;

public class TegavMob extends Creature{

    private static final int STARTING_LIFE = 120;
    private static final int STARTING_DAMAGE = 6;
    private static final int STARTING_ARMOUR = 3;

    public TegavMob(){
        super();
        this.life = STARTING_LIFE;
        this.damage = STARTING_DAMAGE;
        this.armour = STARTING_ARMOUR;
    }
}
