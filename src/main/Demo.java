package main;

import main.Entities.*;
import main.Locations.Forest;
import main.Locations.Pub;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Player player = new Player();
        Spaska spaska = new Spaska();
        Forest forest = new Forest();
        Pub pub = new Pub(10);

        while(true){
            player.getInfo();
            if (!player.isAlive() || !spaska.isAlive()){
                System.out.println(player.isAlive() ? "YOU WON" : "YOU LOST");
                break;
            }
            System.out.println("Please select one of the following numbers to continue:");
            System.out.println("""
                    - 1 -> отивай да тренираш в гората
                    - 2 -> отивай да си почиваш в хана
                    - 3 -> отивай да се пробваш срещу Спаска""");

            int choice = sc.nextInt();
            switch(choice){
                case 1: {
                    forest.enterForest(player);
                    System.out.println("Please select one of the following options to continue:");
                    System.out.println("""
                            - 1 -> fight normal Gadinka
                            - 2 -> fight magic Gadinka
                            - 3 -> fight rare Gadinka""");

                    int choiceWhichMobToFight = sc.nextInt();
                    switch (choiceWhichMobToFight) {
                        case 1: {
                            SmotanMob smotanMob = new SmotanMob();
                            player.fight(smotanMob);
                            forest.leaveForest(player);
                            break;
                        }
                        case 2: {
                            ChitavMob chitavMob = new ChitavMob();
                            player.fight(chitavMob);
                            forest.leaveForest(player);
                            break;
                        }
                        case 3: {
                            TegavMob tegavMob = new TegavMob();
                            player.fight(tegavMob);
                            forest.leaveForest(player);
                            break;
                        }
                        default:
                            System.out.println("Please don't choose a different option that the ones provided");
                            break;
                    }
                } break;
                case 2: {
                    System.out.println("Please select one of the following options to continue:");
                    System.out.println("""
                            - 1 -> преспи в хана
                            - 2 -> продай предмет""");

                    pub.enterPub(player);
                    int choiceWhatToDoInPub = sc.nextInt();
                    switch(choiceWhatToDoInPub){
                        case 1: {
                            pub.letPlayerRestInPub(player);
                            break;
                        }
                        default: {
                            System.out.println("Please select which Item you want to sell");
                            System.out.println("""
                                    - 1 -> Armour in 1st slot
                                    - 2 -> Armour in 2nd slot
                                    - 3 -> Armour in 3rd slot
                                    - 4 -> Armour in 4th slot
                                    - 5 -> Armour in 5th slot
                                    - 6 -> Weapon in 1st slot
                                    - 7 -> Weapon in 2nd slot""");

                            int whichWeaponToSell = sc.nextInt();
                            switch(whichWeaponToSell){
                                case 1 -> pub.buyItem(player.getArmours().get(0), player);
                                case 2 -> pub.buyItem(player.getArmours().get(1), player);
                                case 3 -> pub.buyItem(player.getArmours().get(2), player);
                                case 4 -> pub.buyItem(player.getArmours().get(3), player);
                                case 5 -> pub.buyItem(player.getArmours().get(4), player);
                                case 6 -> pub.buyItem(player.getWeapons().get(0), player);
                                default -> pub.buyItem(player.getWeapons().get(1), player);
                            }
                        }
                    }
                    pub.leavePub(player);
                } break;
                default: {
                    player.fight(spaska);
                }
            }
        }
    }
}
