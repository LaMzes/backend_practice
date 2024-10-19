package main.Entities;

import main.Items.Armour;
import main.Items.Item;
import main.Items.Weapon;
import main.Util;

import java.util.Random;

public abstract class Creature {

    protected int life;
    protected int damage;
    protected int armour;
    protected boolean isAlive;

    protected Creature(){
        this.isAlive = true;
    }

    protected void hit(Creature creature){
        if (this.damage > creature.armour){
            creature.life -= (this.damage - creature.armour);
        } else {
            System.out.println("You don't have enough damage to pierce the armour.");
        }
    }

    private void setIsAlive(boolean b) {
        this.isAlive = b;
    }

    private int getArmour() {
        return this.armour;
    }

    private int getLife() {
        return this.life;
    }

    protected void fight(Creature creature){
    }

    private void takeDamage(int damage){
        this.life -= damage;
    }

    protected Item dropItem(){
        int chanceToDropWeapon = new Random().nextInt(100);
        if (chanceToDropWeapon <= 50) {
            return new Armour(Util.randomHealth(), Util.randomArmour(), Util.randomPrice());
        } else {
            return new Weapon(Util.randomDamage(), Util.randomPrice());
        }
    }

    public boolean isAlive(){
        return isAlive;
    }

    protected void getInfo(){}

    public boolean setAlive(){
        if (this.life <= 0){
            return isAlive = false;
        }
        else {
            return isAlive = true;
        }
    }
}
