package com.theironyard.jdblack;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here
        System.out.println("Welcome Traveler!");
        System.out.println("What is your name?");

        Scanner scanner = new Scanner(System.in); //read variable, looks for input

        String name = scanner.nextLine(); //need to store it in a variable
        System.out.println("Welcome, " + name);

        System.out.println("Choose your weapon [sword/mace/]");
        String weapon = scanner.nextLine(); //we can keep using the scanner.nextline to read from the user input

        if (weapon.equalsIgnoreCase("sword")) { //after if statements here do not put a ";"
            System.out.println("Sword is a wonderful choice " + name + "!");
        }
        else if (weapon.equalsIgnoreCase("mace")){
            System.out.println("Mace is a wonderful choice " + name + "!");
        }
        else {
            throw new Exception("Invalid weapon choice");
        }
        System.out.println("Choose your location [forest/tunnel");
        String location = scanner.nextLine();

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