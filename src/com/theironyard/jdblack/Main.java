package com.theironyard.jdblack;

import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

    }

    public static String nextLine() {
        String line = scanner.nextLine();
        while (line.startsWith("/")) {
            if (line.equals("/inv")) {
                for (String item : player.items) {
                    System.out.println(item);
                }
            }
            else if(line.equals("/save")) {
                saveGame();
            }
            else {
                System.out.println("Aww Bugger, Command Not Found!!");
            }

            line = scanner.nextLine(); //ready for input again
        }
        return line;
    }

    public static void saveGame() {
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.include("*").serialize(player);

        File f = new File("game.json");
        try {
            FileWriter fw = new FileWriter(f);
            fw.write(json);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
