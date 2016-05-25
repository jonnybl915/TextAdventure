package com.theironyard.jdblack;

import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    static final String SAVE_FILE = "game.json";
    static Scanner scanner = new Scanner(System.in); //global variable which can be used anywhere
    static Player player;

    public static void main(String[] args) throws Exception {
        player = loadGame();
        if(player == null){
            player = new Player();
            System.out.println("Starting new game.");
        }

        System.out.println("Welcome Traveler!");

        if (player.name == null) player.chooseName();
        if (player.weapon == null) player.chooseWeapon();
        if (player.location == null) player.chooseLocation();

        if(player.items.isEmpty()) {
        player.findItem("armor");
        player.findItem("potion");
        }

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

        File f = new File(SAVE_FILE);
        try {
            FileWriter fw = new FileWriter(f);
            fw.write(json);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Player loadGame() {
        File f = new File(SAVE_FILE);
        try {
            Scanner scanner = new Scanner(f);
            scanner.useDelimiter("\\Z");
            String contents = scanner.next();
            JsonParser parser = new JsonParser();
            return parser.parse(contents, Player.class);
        } catch (FileNotFoundException e) {
        }
        return null;
    }
}
