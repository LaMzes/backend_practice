package main.Entities;

import main.Items.Armour;
import main.Items.Item;
import main.Items.Weapon;

import java.util.ArrayList;
import java.util.Random;

public class Player extends Creature{

    private static final int MAXIMUM_NUMBER_WEAPONS = 2;
    private static final int MAXIMUM_NUMBER_ARMOURS = 5;
    private static final int STARTING_LIFE = 100;
    private static final int STARTING_DAMAGE = 5;
    private static final int STARTING_ARMOUR = 0;

    private int maximumLife;

    public ArrayList<Armour> armours = new ArrayList<>();
    public ArrayList<Weapon> weapons = new ArrayList<>();

    public int gold;
    public int timesSleptInPub;
    public int kills;

    public Player(){
        this.life = STARTING_LIFE;
        this.damage = STARTING_DAMAGE;
        this.armour = STARTING_ARMOUR;
        this.maximumLife = this.life;
    }

    @Override
    public void fight(Creature creature) {
        while(true){
            if (creature instanceof TegavMob) {
                int chanceToHit = new Random().nextInt(100) + 1;
                if (chanceToHit > 30) {
                    this.hit(creature);
                    if (checkIfCreatureIsKilled(creature)){
                        break;
                    }
                }
                creature.hit(this);
                if (!this.setAlive()) {
                    System.out.println("The monster has killed you");
                    break;
                }
            } else {
                if (creature.setAlive()) {
                    this.hit(creature);
                    if (checkIfCreatureIsKilled(creature)){
                        break;
                    }
                }
                if (this.setAlive()) {
                    creature.hit(this);
                    if (!this.setAlive()) {
                        System.out.println("The monster has killed you");
                        break;
                    }
                }
            }
        }
    }

    private void collectItem(Item item){
        if (item instanceof Armour){
            if (armours.size() < MAXIMUM_NUMBER_ARMOURS) {
                this.armours.add((Armour) item);
                addDefensiveStats((Armour)item);
            } else {
                replaceWorstDefensiveItem((Armour)item);
            }
        } else {
            if (weapons.size() < MAXIMUM_NUMBER_WEAPONS) {
                this.weapons.add((Weapon) item);
                addOffensiveStats((Weapon) item);
            } else {
                replaceWorstOffensiveItem((Weapon)item);
            }
        }
    }

    private void addDefensiveStats(Armour armour){
        this.maximumLife += armour.getLife();
        this.armour += armour.getArmour();
    }

    public void removeDefensiveStats(Armour armour){
        if (this.maximumLife - armour.getLife() < this.life){
            this.life = this.maximumLife - armour.getLife();
        }
        this.maximumLife -= armour.getLife();
        this.armour -= armour.getArmour();
    }

    private void addOffensiveStats(Weapon weapon){
        this.damage += weapon.getDamage();
    }

    public void removeOffensiveStats(Weapon weapon){
        this.damage -= weapon.getDamage();
    }

    //Automatically checks if the new defensive item is better than one of your currently equipped ones and replaces it.
    private void replaceWorstDefensiveItem(Armour newArmour){
        Armour worstArmour = null;

        for (Armour armour : armours) {
            if (worstArmour == null || (armour.getLife() < worstArmour.getLife()
                    && armour.getArmour() < worstArmour.getArmour())) {
                worstArmour = armour;
            }
        }

        if (newArmour.getLife() > worstArmour.getLife()
                && newArmour.getArmour() > worstArmour.getArmour()) {
            armours.remove(worstArmour);
            removeDefensiveStats(worstArmour);
            armours.add(newArmour);
            addDefensiveStats(newArmour);
        }
    }

    private void replaceWorstOffensiveItem(Weapon newWeapon){
        Weapon worstWeapon = null;

        for (Weapon weapon : weapons){
            if (worstWeapon == null || weapon.getDamage() < worstWeapon.getDamage()){
                worstWeapon = weapon;
            }
        }

        if (newWeapon.getDamage() > worstWeapon.getDamage()) {
            weapons.remove(worstWeapon);
            removeOffensiveStats(worstWeapon);
            weapons.add(newWeapon);
            addOffensiveStats(newWeapon);
        }
    }

    private boolean checkIfCreatureIsKilled(Creature creature){
        if (!creature.setAlive()) {
            System.out.println("Congratulations, you've killed the creature!");
            this.collectItem(creature.dropItem());
            this.kills++;
            return true;
        }
        return false;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getGold() {
        return this.gold;
    }

    public void heal(){
        this.life = maximumLife;
    }

    public void increaseTimesSleptInPub(){
        this.timesSleptInPub++;
    }

    public ArrayList<Armour> getArmours() {
        return armours;
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    @Override
    public void getInfo() {
        System.out.println("Life: " + life + "/" + maximumLife + "\nArmour: " + armour + "\nDamage: "
                + damage + "\nKills: " + kills + "\nTimes slept in pub: " + timesSleptInPub + "\nGold: " + gold);
    }
}
