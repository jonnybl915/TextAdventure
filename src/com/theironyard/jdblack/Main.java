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
    }
}