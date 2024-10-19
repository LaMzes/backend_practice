package main.Locations;

import main.Entities.Player;
import main.Items.Armour;
import main.Items.Item;
import main.Items.Weapon;

import java.util.ArrayList;

public class Pub {

    private ArrayList<Player> players = new ArrayList<>();
    private int costForRest;

    public Pub(int costForRest){
        this.costForRest = costForRest;
    }

    public void enterPub(Player player){
        this.players.add(player);
    }

    public void leavePub(Player player){
        this.players.remove(player);
    }

    public void letPlayerRestInPub(Player player){
        if (players.contains(player)) {
            if (player.getGold() >= costForRest){
                chargeFeeForRest(player);
                rest(player);
            } else {
                System.out.println("NO MONEY, GO WORK IN THE GARDEN TO REST!");
                rest(player);
            }
        } else {
            System.out.println("There is no such human in my PUB!");
        }
    }

    public void rest(Player player){
        player.heal();
        player.increaseTimesSleptInPub();
    }

    private void chargeFeeForRest(Player player){
        player.setGold(player.getGold() - costForRest);
    }

    public void buyItem(Item item, Player player){
        if (!(item == null)) {
            player.setGold(player.getGold() + item.getCost());
            if (item instanceof Armour){
                player.getArmours().remove(item);
                player.removeDefensiveStats((Armour)item);
            } else if (item instanceof Weapon){
                player.getWeapons().remove(item);
                player.removeOffensiveStats((Weapon)item);
            }
        } else {
            System.out.println("There's no item in that slot");
        }
    }
}
