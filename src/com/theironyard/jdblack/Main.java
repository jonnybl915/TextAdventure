package com.theironyard.jdblack;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in); //global variable which can be used anywhere

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome Traveler!");

        Player player = new Player();

        player.chooseName();
        player.chooseWeapon();
        player.chooseLocation();
        player.findItem("armor");
        player.findItem("potion");
        player.findItem("sword");
        player.findItem("mace");




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
}