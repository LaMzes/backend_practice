package main.Locations;

import main.Entities.Player;

import java.util.ArrayList;

public class Forest {

    private ArrayList<Player> players = new ArrayList<>();

    public void enterForest(Player player){
        this.players.add(player);
    }

    public void leaveForest(Player player){
        this.players.remove(player);
    }
}
