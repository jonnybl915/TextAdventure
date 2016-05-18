package com.theironyard.jdblack;

/**
 * Created by jonathandavidblack on 5/18/16.
 */
public class Player {
    String name;
    String weapon;
    String location;

    public void chooseName() {
        System.out.println("What is your name?");
        String name = Main.scanner.nextLine(); //need to store it in a variable
        System.out.println("Welcome, " + name);
    }

    public void chooseWeapon() throws Exception {
        System.out.println("Choose your weapon [sword/mace/]");
        String weapon = Main.scanner.nextLine(); //we can keep using the scanner.nextline to read from the user input

        if (weapon.equalsIgnoreCase("sword")) { //after if statements here do not put a ";"
            System.out.println("Sword is a wonderful choice " + name + "!");
        }
        else if (weapon.equalsIgnoreCase("mace")){
            System.out.println("Mace is a wonderful choice " + name + "!");
        }
        else {
            throw new Exception("Invalid weapon choice");
        }
    }

     public void chooseLocation() throws Exception {
         System.out.println("Choose your location [forest/tunnel");
         String location = Main.scanner.nextLine();

         if (location.equalsIgnoreCase("forest")) {
             System.out.println("Entering Forest...");
         }
         else if (location.equalsIgnoreCase("tunnel")) {
             System.out.println("Entering tunnel...");
         }
         else {
             throw new Exception("Invalid location...");
         }
    }
}

