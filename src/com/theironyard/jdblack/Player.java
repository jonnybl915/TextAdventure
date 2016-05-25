package com.theironyard.jdblack;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by jonathandavidblack on 5/18/16.
 */
public class Player extends Character {
    String weapon;
    String location;

    ArrayList<String> items = new ArrayList<>();

    public Player() {
        this.health = 20;
        this.damage = 20;
    }

    public void chooseName() {
        System.out.println("What is your name?");
        name = Main.nextLine(); //need to store it in a variable,
        System.out.printf("Welcome, %s\n", name);
    }

    public void chooseWeapon() throws Exception {
        System.out.println("Choose your weapon [sword/mace/]");
        weapon = Main.nextLine(); //we can keep using the scanner.nextline to read from the user input

        if (weapon.equalsIgnoreCase("sword")) { //after if statements here do not put a ";"
            System.out.println("The sword is a wonderful choice " + name + "!"); //use string formatting
            //System.out.println("you now have " + items.size() + " items");
        }
        else if (weapon.equalsIgnoreCase("mace")){
            System.out.println("The mace is a wonderful choice " + name + "!"); //use string formatting
            //System.out.println("you now have " + items.size() + " items");
        }
        else {
            throw new Exception("Invalid weapon choice");
        }
    }

     public void chooseLocation() throws Exception {
         System.out.println("Choose your location [forest/tunnel]");
         location = Main.nextLine();

         if (location.equalsIgnoreCase("forest")) {
             System.out.println(name + " is Entering the Forest...");
         }
         else if (location.equalsIgnoreCase("tunnel")) {
             System.out.println(name + " is Entering the Tunnel...");
         }
         else {
             throw new Exception("Invalid location...");
         }
    }

    public String getWeapon() {
        return weapon;
    }

    public String getLocation() {
        return location;
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public void findItem(String item) {
        System.out.printf("You have stumbled upon %s Would you like to pick it up [Y/N]\n", item);
        String answer = Main.nextLine();
        if (answer.equalsIgnoreCase("y")) {
            items.add(item);
            System.out.printf("you now have %s items\n", items.size());
        }
        if (answer.equalsIgnoreCase("n")) {
            System.out.println("it did not look like a good " + item + " anyway");
        }


    }
}

