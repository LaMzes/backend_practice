package main.Items;

public class Weapon extends Item {

    private final int damage;

    public Weapon(int damage, int cost){
        super(cost);
        this.damage = damage;
    }

    public int getDamage() {
        return this.damage;
    }
}
