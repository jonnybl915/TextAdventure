package com.theironyard.jdblack;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in); //global variable which can be used anywhere
    static Player player = new Player();
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome Traveler!");


        player.chooseName();
        player.chooseWeapon();
        player.chooseLocation();

        player.findItem("armor");
        player.findItem("potion");

        Enemy orc = new Enemy("Orc", 10, 10);
        player.battle(orc);

        System.out.println(player);
        System.out.println(orc);


//        System.out.println("Type a number...");
//        String num = scanner.nextLine();
//
//        int numInt = Integer.valueOf(num); //converts to an integer
//
//        if (numInt < 0) {
//            System.out.println("That's a negative number");
//        }
//        else {
//            System.out.println("That's a positive number");
//        }
    }
    public static String nextLine() {
        String line = scanner.nextLine();
        while (line.startsWith("/")) {
            if (line.equals("/inv")) {
                for (String item : player.items) {
                    System.out.println(item);
                }
            }
            else {
                System.out.println("Aww Bugger, Command Not Found!!");
            }

            line = scanner.nextLine(); //ready for input again
        }
        return line;
    }
}
