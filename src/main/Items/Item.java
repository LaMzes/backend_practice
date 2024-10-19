package main.Items;

public abstract class Item {

    private final int cost;

    protected Item(int cost){
        this.cost = cost;
    }

    public int getCost() {
        return this.cost;
    }
}
