package main.Items;

public class Armour extends Item{

    private final int life;
    private final int armour;

    public Armour(int life, int armour, int cost){
        super(cost);
        this.life = life;
        this.armour = armour;
    }

    public int getLife() {
        return this.life;
    }

    public int getArmour() {
        return this.armour;
    }
}
