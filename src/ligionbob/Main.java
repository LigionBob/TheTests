package ligionbob;

import ligionbob.chests.Chest;
import ligionbob.enemies.Enemy;
import ligionbob.init.Chests;
import ligionbob.init.Enemies;
import org.json.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class  Main {
    public static Scanner scan;

    //public static String name;
    public static String check;
    public static String input;
    public static String weapon1;
    public static String weapon2;
    public static String weapon3;
    public static String weapon4;
    public static String food1;
    public static String food2;
    public static String food3;
    public static String food4;
    public static String food5;
    public static String weaponSelected;
    public static String foodSelected;
    public static String smallOgre;
    public static String giveItem;
    public static String version;
    public static String dir=System.getProperty("user.dir");
    public static String save1;
    public static String save2;
    public static String save3;
    public static String save4;
    public static String save5;
    public static String map;

    public static int playerX;
    public static int playerY;
    public static int playerHP;
    public static int tpX;
    public static int tpY;

    public static boolean checkBool;
    public static boolean error;
    public static boolean inputError;
    public static boolean game;
    public static boolean cheats;
    public static boolean dev;
    public static boolean attackSuccessful;
    public static boolean keys;

    public static JFrame frame;

    public static Random random;

    public static JSONObject jsonsave1;
    public static JSONObject jsonsave2;
    public static JSONObject jsonsave3;
    public static JSONObject jsonsave4;
    public static JSONObject jsonsave5;
    public static JSONObject jsonMap;

    public static int[][] array =new int[17][17];

    public static void main(String args[]) {
        for(String str : args) {
            if(str.equals("cheats")) {
                cheats=true;
            }
            if(str.equals("dev")) {
                System.out.println("It worked");
                dev=true;
            }

        }

        if(dev) {
            cheats = true;
            System.out.println("Running as developer");
            System.out.println("dir: "+ dir);
        }
        updateUpdater.main();
        init();
        arrayCoords();
        /*
         * System.out.println("Hello! What is your name?");
         * name = scan.nextLine();
         * System.out.println("Is " + name + " correct? (Type exactly 'yes' or 'no') ");
         * check = scan.nextLine();
         * check();
         * errorCheck();
         * while(!checkBool) {
         *     System.out.println("I must've misheard you, what is your name?");
         *     name = scan.nextLine();
         *     System.out.println("Is " + name + " correct? (Type exactly 'yes' or 'no' ");
         *     check = scan.nextLine();
         *     check();
         * }
         * System.out.println("Hello " + name);
         */
        System.out.println("Do you want to play a game? (Type exactly 'yes' or 'no')");
        check = scan.nextLine();
        check();
        if(!checkBool) {
            System.out.println("Fine!");
            System.exit(0);
        }
        game = true;
        System.out.println("Okay, Imagine you are in a desert");
        ask();
    }
    public static void init() {
        scan = new Scanner(System.in);
        random = new Random();
        error = false;
        inputError = false;
        game = false;
        cheats = false;
        dev = false;
        checkBool = false;
        playerX = 8;
        playerY = 8;
        weaponSelected="fists";
        foodSelected="";
        weapon1="";
        weapon2="";
        weapon3="";
        weapon4="";
        food1="";
        food2="";
        food3="";
        food4="";
        food5="";
        version="Beta Release 1.2";
        save1=dir + "/save1.json";
        save2=dir + "/save2.json";
        save3=dir + "/save3.json";
        save4=dir + "/save4.json";
        save5=dir + "/save5.json";
        map=dir + "/map.json";
        try {
            String text1 = new String(Files.readAllBytes(Paths.get(save1)));
            jsonsave1 = new JSONObject(text1);
            String text2 = new String(Files.readAllBytes(Paths.get(save2)));
            jsonsave2 = new JSONObject(text2);
            String text3 = new String(Files.readAllBytes(Paths.get(save3)));
            jsonsave3 = new JSONObject(text3);
            String text4 = new String(Files.readAllBytes(Paths.get(save4)));
            jsonsave4 = new JSONObject(text4);
            String text5 = new String(Files.readAllBytes(Paths.get(save5)));
            jsonsave5 = new JSONObject(text5);
            String tempMap = new String(Files.readAllBytes(Paths.get(map)));
            jsonMap = new JSONObject(tempMap);
        }
        catch(Exception e) {
        }
        playerHP=100;
        attackSuccessful = false;
        smallOgre="Small Ogre";
        Enemies.init();
        Chests.init();
    }
    public static void arrayCoords() {
        //Spawn Point
        array[8][8] = 6;
        //In front of small ogres
        array[8][10] = 1;
        array[15][14] = 1;
        //In front of normal ogres
        array[4][2] = 9;
        //Obstacles
        array[15][15] = 2;
        array[4][9] = 2;
        array[12][4] = 2;
        array[4][3] = 2;
        array[3][4] = 2;
        array[3][5] = 2;
        array[5][4] = 2;
        array[5][5] = 2;
        array[8][13] = 2;
        array[7][11] = 2;
        array[7][12] = 2;
        array[9][11] = 2;
        array[9][12] = 2;
        array[4][5] = 2;
        array[1][15] = 2;
        array[8][11] = 2;
        //In front of chests with iron short swords
        array[4][8] = 3;
        //In front of chests with iron long swords
        array[8][12] = 7;
        //In front of chests with chicken legs
        array[12][3] = 8;
        //In front of chests with turkey legs
        array[1][14] = 12;
        //In front of chests with Magical Broad swords
        array[4][4] = 11;
        //Borders
        array[0][0] = 10;array[16][16] = 10;
        array[0][1] = 10;array[1][0] = 10;array[16][1] = 10;array[1][16] = 10;
        array[0][2] = 10;array[2][0] = 10;array[16][2] = 10;array[2][16] = 10;
        array[0][3] = 10;array[3][0] = 10;array[16][3] = 10;array[3][16] = 10;
        array[0][4] = 10;array[4][0] = 10;array[16][4] = 10;array[4][16] = 10;
        array[0][5] = 10;array[5][0] = 10;array[16][5] = 10;array[5][16] = 10;
        array[0][6] = 10;array[6][0] = 10;array[16][6] = 10;array[6][16] = 10;
        array[0][7] = 10;array[7][0] = 10;array[16][7] = 10;array[7][16] = 10;
        array[0][8] = 10;array[8][0] = 10;array[16][8] = 10;array[8][16] = 10;
        array[0][9] = 10;array[9][0] = 10;array[16][9] = 10;array[9][16] = 10;
        array[0][10] = 10;array[10][0] = 10;array[16][10] = 10;array[10][16] = 10;
        array[0][11] = 10;array[11][0] = 10;array[16][11] = 10;array[11][16] = 10;
        array[0][12] = 10;array[12][0] = 10;array[16][12] = 10;array[12][16] = 10;
        array[0][13] = 10;array[13][0] = 10;array[16][13] = 10;array[13][16] = 10;
        array[0][14] = 10;array[14][0] = 10;array[16][14] = 10;array[14][16] = 10;
        array[0][15] = 10;array[15][0] = 10;array[16][15] = 10;array[15][16] = 10;
        array[0][16] = 10;array[16][0] = 10;


    }
    public static int weaponCheck() {
        if(weapon1 == "") {
            return 0;
        }
        else if(weapon2 == "") {
            return 1;
        }
        else if(weapon3 == "") {
            return 2;
        }
        else if(weapon4 == "") {
            return 3;
        }
        else if(weapon4 != "") {
            return 4;
        }
        else {
            return 0;
        }
    }
    public static int foodCheck() {
        if(food1 == "") {
            return 0;
        }
        else if(food2 == "") {
            return 1;
        }
        else if(food3 == "") {
            return 2;
        }
        else if(food4 == "") {
            return 3;
        }
        else if(food5 == "") {
            return 4;
        }
        else if(food5 != "") {
            return 5;
        }
        else {
            return 0;
        }
    }
    /*public static int saveCheck() {
        if(!Load.save1.exists()) {
            return 0;
        }
        if(!Load.save2.exists()) {
            return 1;
        }
        if(!Load.save3.exists()) {
            return 2;
        }
        if(!Load.save4.exists()) {
            return 3;
        }
        if(!Load.save5.exists()) {
            return 4;
        }
        if(Load.save5.exists()) {
            return 5;
        }
        else {
            return 5;
        }
    }*/
    public static void check() {
        if(check.equals("yes")) {
            checkBool=true;
        }
        else if(check.equals("no")) {
            checkBool=false;
        }
        if(check.equals("yes")||check.equals("no")) {
            error = false;
        }
        else {
            System.out.println("Unknown Response");
            error = true;
        }
        errorCheck();
    }
    public static boolean isParsable(String string) {
        boolean parsable = true;
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            parsable = false;
        }
        return parsable;
    }
    public static void move(String direction, int length) {
        switch (direction) {
            case "forward": playerY = playerY + length;
                break;
            case "backward": playerY = playerY - length;
                break;
            case "right": playerX = playerX + length;
                break;
            case "left": playerX = playerX - length;
                break;
        }
    }
    public static void gameInput() {
        String[] inputArray = input.split(" ");
        for(String args : inputArray) {
            if (cheats) {
                if (args.equals("give")) {
                    give(inputArray[1]);
                    inputError = false;
                    return;
                } else if (args.equals("heal")) {
                    playerHP = 25;
                    System.out.println("Player Healed");
                    inputError = false;
                    return;
                }

            }
            if (dev) {
                if (args.equals("teleport")) {
                    if(isParsable(inputArray[1]) && isParsable(inputArray[2])) {
                        tpX = Integer.parseInt(inputArray[1]);
                        tpY = Integer.parseInt(inputArray[2]);
                    }
                    if (tpX < 16 && tpY < 16) {
                        System.out.println("Teleporting...");
                        playerX = tpX;
                        playerY = tpY;
                    }
                    inputError = false;
                    return;
                }
            }
            if (args.equals("forward")) {
                inputError = false;
                int inputArrayLength = inputArray.length;
                if(inputArrayLength > 1) {
                    if(isParsable(inputArray[1])) {
                        boolean canMove = false;
                        for (int move = Integer.parseInt(inputArray[1]); move > 0; move--) {
                            try {
                                if (array[playerX][playerY + move] != 2) {
                                    if (array[playerX][playerY + move] != 10) {
                                        canMove = true;
                                    } else {
                                        System.out.println("You've run into the border!");
                                        int partialMove = move-1;
                                        move("forward", partialMove);
                                        return;
                                    }
                                } else {
                                    System.out.println("There is something in your way!");
                                    int partialMove = move-1;
                                    System.out.println("You moved as far as you could, which is " + partialMove + " spaces.");
                                    move("forward", partialMove);
                                    return;
                                }
                            } catch (ArrayIndexOutOfBoundsException e) {
                            }
                        }
                        if (canMove) {
                            move("forward", Integer.parseInt(inputArray[1]));
                            return;
                        }
                    }
                } else {
                    if (array[playerX][playerY + 1] != 2) {
                        if (array[playerX][playerY + 1] != 10) {
                            move("forward", 1);
                        } else {
                            System.out.println("You've run into the border!");
                        }
                    } else {
                        System.out.println("There is something in your way!");
                    }
                }
            } else if (args.equals("backward")) {
                inputError = false;
                int inputArrayLength = inputArray.length;
                if(inputArrayLength > 1) {
                    if(isParsable(inputArray[1])) {
                        boolean canMove = false;
                        for (int move = Integer.parseInt(inputArray[1]); move > 0; move--) {
                            try {
                                if (array[playerX][playerY - move] != 2) {
                                    if (array[playerX][playerY - move] != 10) {
                                        canMove = true;
                                    } else {
                                        System.out.println("You've run into the border!");
                                        int partialMove = move-1;
                                        move("backward", partialMove);
                                        return;
                                    }
                                } else {
                                    System.out.println("There is something in your way!");
                                }
                            } catch (ArrayIndexOutOfBoundsException e) {
                            }
                        }
                        if (canMove) {
                            move("backward", Integer.parseInt(inputArray[1]));
                            return;
                        }
                    }
                } else {
                    if (array[playerX][playerY - 1] != 2) {
                        if (array[playerX][playerY - 1] != 10) {
                            move("backward", 1);
                        } else {
                            System.out.println("You've run into the border!");
                        }
                    } else {
                        System.out.println("There is something in your way!");
                    }
                }
            } else if (args.equals("right")) {
                inputError = false;
                int inputArrayLength = inputArray.length;
                if(inputArrayLength > 1) {
                    if(isParsable(inputArray[1])) {
                        boolean canMove = false;
                        for (int move = Integer.parseInt(inputArray[1]); move > 0; move--) {
                            try {
                                if (array[playerX + move][playerY] != 2) {
                                    if (array[playerX + move][playerY] != 10) {
                                        canMove = true;
                                    } else {
                                        System.out.println("You've run into the border!");
                                        int partialMove = move-1;
                                        move("right", partialMove);
                                        return;
                                    }
                                } else {
                                    System.out.println("There is something in your way!");
                                }
                            } catch (ArrayIndexOutOfBoundsException e) {
                            }
                        }
                        if (canMove) {
                            move("right", Integer.parseInt(inputArray[1]));
                            return;
                        }
                    }
                } else {
                    if (array[playerX + 1][playerY] != 2) {
                        if (array[playerX + 1][playerY] != 10) {
                            move("right", 1);
                        } else {
                            System.out.println("You've run into the border!");
                        }
                    } else {
                        System.out.println("There is something in your way!");
                    }
                }
            } else if (input.equals("left")) {
                inputError = false;
                int inputArrayLength = inputArray.length;
                if(inputArrayLength > 1) {
                    if(isParsable(inputArray[1])) {
                        boolean canMove = false;
                        for (int move = Integer.parseInt(inputArray[1]); move > 0; move--) {
                            try {
                                if (array[playerX - move][playerY] != 2) {
                                    if (array[playerX - move][playerY] != 10) {
                                        canMove = true;
                                    } else {
                                        System.out.println("You've run into the border!");
                                        int partialMove = move-1;
                                        move("left", partialMove);
                                        return;
                                    }
                                } else {
                                    System.out.println("There is something in your way!");
                                }
                            } catch (ArrayIndexOutOfBoundsException e) {
                            }
                        }
                        if (canMove) {
                            move("left", Integer.parseInt(inputArray[1]));
                            return;
                        }
                    }
                } else {
                    if (array[playerX - 1][playerY] != 2) {
                        if (array[playerX - 1][playerY] != 10) {
                            playerY--;
                        } else {
                            System.out.println("You've run into the border!");
                        }
                    } else {
                        System.out.println("There is something in your way!");
                    }
                }
            } else if (args.equals("coordinates")) {
                System.out.println("Your X coordinate is " + playerX + " and your Y coordinate is " + playerY);
                inputError = false;
                return;
            } else if (input.equals("weapons")) {
                if (weaponCheck() == 0) {
                    System.out.println("You have no weapons.");
                    ask();
                }
                if (weaponCheck() == 1) {
                    System.out.println("You have a(n) " + weapon1);
                    ask();
                }
                if (weaponCheck() == 2) {
                    System.out.println("You have a(n) " + weapon1 + ", " + weapon2);
                    ask();
                }
                if (weaponCheck() == 3) {
                    System.out.println("You have a(n) " + weapon1 + ", " + weapon2 + ", " + weapon3);
                    ask();
                }
                if (weaponCheck() == 4) {
                    System.out.println("You have a(n) " + weapon1 + ", " + weapon2 + ", " + weapon3 + ", " + weapon4 + ".");
                    ask();
                }
                inputError = false;
            } else if (input.equals("foods")) {
                if (foodCheck() == 0) {
                    System.out.println("You have no food");
                    ask();
                }
                if (foodCheck() == 1) {
                    System.out.println("You have a(n) " + food1);
                    ask();
                }
                if (foodCheck() == 2) {
                    System.out.println("You have a(n) " + food1 + ", " + food2);
                    ask();
                }
                if (foodCheck() == 3) {
                    System.out.println("You have a(n) " + food1 + ", " + food2 + ", " + food3);
                    ask();
                }
                if (foodCheck() == 4) {
                    System.out.println("You have a(n) " + food1 + ", " + food2 + ", " + food3 + ", " + food4 + ".");
                    ask();
                }
                if (foodCheck() == 5) {
                    System.out.println("You have a(n) " + food1 + ", " + food2 + ", " + food3 + ", " + food4 + ", " + food5 + ".");
                    ask();
                }
                inputError = false;
            } else if (input.equals("eat")) {
                if (foodCheck() == 0) {
                    System.out.println("You have no food");
                    ask();
                }
                if (foodCheck() == 1) {
                    System.out.println("You have a(n) " + food1);
                    eat(food1, 1);
                }
                if (foodCheck() == 2) {
                    System.out.println("You have a(n) " + food1 + ", " + food2);
                    input = scan.nextLine();
                    if (input.equals(food1)) {
                        eat(food1, 2);
                        food1 = food2;
                        food2 = "";
                    }
                    if (input.equals(food2)) {
                        eat(food2, 3);
                        food2 = "";
                    } else {
                        System.out.println("You don't have this food.");
                    }
                }
                if (foodCheck() == 3) {
                    System.out.println("You have a(n) " + food1 + ", " + food2 + ", " + food3);
                    input = scan.nextLine();
                    if (input.equals(food1)) {
                        eat(food1, 4);
                        food1 = food2;
                        food2 = food3;
                        food3 = "";
                    }
                    if (input.equals(food2)) {
                        eat(food2, 5);
                        food2 = food3;
                        food3 = "";
                    }
                    if (input.equals(food3)) {
                        eat(food3, 6);
                        food3 = "";
                    } else {
                        System.out.println("You don't have this food.");
                    }
                }
                if (foodCheck() == 4) {
                    System.out.println("You have a(n) " + food1 + ", " + food2 + ", " + food3 + ", " + food4 + ".");
                    input = scan.nextLine();
                    if (input.equals(food1)) {
                        eat(food1, 7);
                        food1 = food2;
                        food2 = food3;
                        food3 = food4;
                        food4 = "";
                    }
                    if (input.equals(food2)) {
                        eat(food2, 8);
                        food2 = food3;
                        food3 = food4;
                        food4 = "";
                    }
                    if (input.equals(food3)) {
                        eat(food3, 9);
                        food3 = food4;
                        food4 = "";
                    }
                    if (input.equals(food4)) {
                        eat(food4, 10);
                        food4 = "";
                    } else {
                        System.out.println("You don't have this food.");
                    }
                }
                if (foodCheck() == 5) {
                    System.out.println("You have a(n) " + food1 + ", " + food2 + ", " + food3 + ", " + food4 + ", " + food5 + ".");
                    input = scan.nextLine();
                    if (input.equals(food1)) {
                        eat(food1, 11);
                        food1 = food2;
                        food2 = food3;
                        food3 = food4;
                        food4 = food5;
                        food5 = "";
                    }
                    if (input.equals(food2)) {
                        eat(food2, 12);
                        food2 = food3;
                        food3 = food4;
                        food4 = food5;
                        food5 = "";
                    }
                    if (input.equals(food3)) {
                        eat(food3, 13);
                        food3 = food4;
                        food4 = food5;
                        food5 = "";
                    }
                    if (input.equals(food4)) {
                        eat(food4, 14);
                        food4 = food5;
                        food5 = "";
                    }
                    if (input.equals(food5)) {
                        eat(food5, 15);
                        food5 = "";
                    } else {
                        System.out.println("You don't have this food.");
                    }
                } else if (input.equals("version")) {
                    System.out.println("You are playing version " + version);
                }
                inputError = false;
            } else if (input.equals("enable cheats")) {
                System.out.println("Are you sure? (Type exactly 'yes' or 'no')");
                check = scan.nextLine();
                check();
                if (checkBool) {
                    cheats = true;
                }
            } else if (input.equals("developer mode")) {
                System.out.println("Are you sure? (Type exactly 'yes' or 'no')");
                check = scan.nextLine();
                check();
                if (checkBool) {
                    cheats = true;
                    dev = true;
                }
            } else if (input.equals("health")) {
                System.out.println("You have " + playerHP + " HP left");
            } else if (input.equals("load")) {
                System.out.println("What slot?");
                int slot = scan.nextInt();
                load(slot);
            } else if (input.equals("save")) {
                System.out.println("What slot?");
                int slot = scan.nextInt();
                try {
                    save(slot);
                } catch (Exception e) {

                }

            } else if (input.equals("delete")) {
                int slot = scan.nextInt();
                delete(slot);
            } else if (input.equals("exit")) {
                System.exit(0);
            } else {
                System.out.println("Unknown Response");
                inputError = true;
            }
        }
        errorInput();
    }
    public static void eat(String food, int foodCase) {
        if(food.equals("Chicken Leg")) {
            playerHP = playerHP + 5;
            System.out.println("Healed 5 HP by eating a chicken leg.");
        }
        if(food.equals("Turkey Leg")) {
            playerHP = playerHP + 10;
            System.out.println("Healed 10 HP by eating a turkey leg.");
        }
        switch(foodCase) {
            case 1:
                food1 = "";
                break;
            case 2:
                food1 = food2;
                food2 = "";
                break;
            case 3:
                food2 = "";
                break;
            case 4:
                food1 = food2;
                food2 = food3;
                food3 = "";
                break;
            case 5:
                food2 = food3;
                food3 = "";
                break;
            case 6:
                food3 = "";
                break;
            case 7:
                food1 = food2;
                food2 = food3;
                food3 = food4;
                food4 = "";
                break;
            case 8:
                food2 = food3;
                food3 = food4;
                food4 = "";
                break;
            case 9:
                food3 = food4;
                food4 = "";
                break;
            case 10:
                food4 = "";
                break;
            case 11:
                food1 = food2;
                food2 = food3;
                food3 = food4;
                food4 = food5;
                food5 = "";
                break;
            case 12:
                food2 = food3;
                food3 = food4;
                food4 = food5;
                food5 = "";
                break;
            case 13:
                food3 = food4;
                food4 = food5;
                food5 = "";
                break;
            case 14:
                food4 = food5;
                food5 = "";
                break;
            case 15:
                food5 = "";
                break;

        }
        if(playerHP>100) {
            playerHP=100;
        }
        ask();
    }
    public static void give(String item) {
        if(item.toLowerCase().equals("iron_short_sword")) {
            if(weapon1.equals("")) {
                weapon1 = "Iron Short Sword";
            }
            else if(weapon2.equals("")) {
                weapon2 = "Iron Short Sword";
            }
            else if(weapon3.equals("")) {
                weapon3 = "Iron Short Sword";
            }
            else if(weapon4.equals("")) {
                weapon4 = "Iron Short Sword";
            }
            else if(!weapon4.equals("")) {
                System.out.println("Your pockets are full!");
            }
        }
        else if(item.equals("Iron Long Sword")) {
            if(weapon1.equals("")) {
                weapon1 = "Iron Long Sword";
            }
            else if(weapon2.equals("")) {
                weapon2 = "Iron Long Sword";
            }
            else if(weapon3.equals("")) {
                weapon3 = "Iron Long Sword";
            }
            else if(weapon4.equals("")) {
                weapon4 = "Iron Long Sword";
            }
            else if(!weapon4.equals("")) {
                System.out.println("Your pockets are full!");
            }
        }
        else if(item.equals("Magical Broad Sword")) {
            if(weapon1.equals("")) {
                weapon1 = "Magical Broad Sword";
            }
            else if(weapon2.equals("")) {
                weapon2 = "Magical Broad Sword";
            }
            else if(weapon3.equals("")) {
                weapon3 = "Magical Broad Sword";
            }
            else if(weapon4.equals("")) {
                weapon4 = "Magical Broad Sword";
            }
            else if(!weapon4.equals("")) {
                System.out.println("Your pockets are full!");
            }
        }
        else if(item.equals("Chicken Leg")) {
            if(food1.equals("")) {
                food1 = "Chicken Leg";
            }
            else if(food2.equals("")) {
                food2 = "Chicken Leg";
            }
            else if(food3.equals("")) {
                food3 = "Chicken Leg";
            }
            else if(food4.equals("")) {
                food4 = "Chicken Leg";
            }
            else if(food5.equals("")) {
                food5 = "Chicken Leg";
            }
            else if(!food5.equals("")) {
                System.out.println("Your pockets are full!");
            }
        }
        else if(item.equals("Turkey Leg")) {
            if(food1.equals("")) {
                food1 = "Turkey Leg";
            }
            else if(food2.equals("")) {
                food2 = "Turkey Leg";
            }
            else if(food3.equals("")) {
                food3 = "Turkey Leg";
            }
            else if(food4.equals("")) {
                food4 = "Turkey Leg";
            }
            else if(food5.equals("")) {
                food5 = "Turkey Leg";
            }
            else if(!food5.equals("")) {
                System.out.println("Your pockets are full!");
            }
        }
        else {
            System.out.println("No such item");
        }
    }
    public static void errorCheck() {
        while(error) {
            System.out.println("I must've misheard you, what did you say?");
            check = scan.nextLine();
            if(check.equals("yes")||check.equals("no")) {
                check();
            }
        }
    }
    public static void errorInput() {
        while(inputError) {
            System.out.println("I must've misheard you, where do you want to go?");
            input = scan.nextLine();
            gameInput();
        }
    }
    public static void coordCheck() {
        switch (array[playerX][playerY]) {
            case 0:
                //nothing
                System.out.println("There is nothing here");
                ask();
                break;
            case 1:
                //Ogre in front
                askAttack(Enemies.smallOgre);
                break;
            case 2:
                //Obstacle
                break;
            case 3:
                //Treasure Chest in front with an Iron Short Sword
                System.out.println("There is a treasure chest in front of you.");
                askChest(Chests.IronShortSwordChest);
                break;
            case 4:
                //Empty treasure chest in front
                System.out.println("There is an empty treasure chest in front of you.");
                ask();
                break;
            case 5:
                System.out.println("An ogre used to stand here.");
                ask();
                break;
            case 6:
                System.out.println("This is where you started.");
                ask();
                break;
            case 7:
                ///System.out.println("There is a treasure chest in front of you.");
                askChest(Chests.IronLongSwordChest);
                break;
            case 8:
                askChest(Chests.ChickenLegChest);
                break;
            case 9:
                askAttack(Enemies.normalOgre);
                break;
            case 10:
                break;
            case 11:
                askChest(Chests.MagicalBroadSwordChest);
                break;
            case 12:
                askChest(Chests.TurkeyLegChest);
                break;
        }
    }
    public static void ask() {
        System.out.println("Do you go forward, backward, left, or right?");
        input = scan.nextLine();
        gameInput();
        coordCheck();
        errorInput();
    }
    public static void askAttack(Enemy enemy) {
        System.out.println("There is a(n) " + enemy.name()  + " in front of you!");
        System.out.println("Do you wish to attack? (type exactly 'yes' or 'no')");
        check = scan.nextLine();
        check();
        if(checkBool) {
            if(!weapon1.equals("") && !weapon2.equals("") && !weapon3.equals("") && !weapon4.equals("")) {
                System.out.println("What weapon do you wish to attack with?" + " fists, " + weapon1 + " " + weapon2 + " " + weapon3 + ", or " + weapon4);
                weaponSelected = scan.nextLine();
                attack(weaponSelected, enemy);
            }
            else if(!weapon1.equals("") && !weapon2.equals("") && !weapon3.equals("")) {
                System.out.println("What weapon do you wish to attack with?" + " fists, " + weapon1 + " " + weapon2 + ", or " + weapon3);
                weaponSelected = scan.nextLine();
                attack(weaponSelected, enemy);
            }
            else if(!weapon1.equals("") && !weapon2.equals("")) {
                System.out.println("What weapon do you wish to attack with?" + " fists, " + weapon1 + ", or " + weapon2);
                weaponSelected = scan.nextLine();
                attack(weaponSelected, enemy);
            }
            else if(!weapon1.equals("")) {
                System.out.println("What weapon do you wish to attack with?" + " fists or " + weapon1);
                weaponSelected = scan.nextLine();
                attack(weaponSelected, enemy);
            }
            else {
                System.out.println("You are attacking with your fists!");
                attack(weaponSelected, enemy);
            }
        }
        else {
            playerY--;
            System.out.println("You take a step backwards to get away");
            ask();
        }
    }
    public static void attack(String weapon, Enemy enemy) {
        int r = random.nextInt(100) + 1;
        if(weapon.equals("fists")) {
            if(r <= 25)  {
                attackSuccessful = true;
                System.out.println("Attack Successful!");
                int enemyHealth = enemy.takeDamage(1);
                if(enemyHealth <= 0) {
                    System.out.println("You have killed the " + enemy.name());
                    enemy.setDead();
                }
                else {
                    System.out.println("The " + enemy.name() + " took 1 HP of damage!");
                    System.out.println("The " + enemy.name() + " has " + enemyHealth + " HP left.");
                }
            }
            else {
                System.out.println("Attack Failed!");
            }


        }
        else if(weapon.equals("Iron Short Sword")) {
            if(r <= 50)  {
                attackSuccessful = true;
                System.out.println("Attack Successful!");
                int enemyHealth = enemy.takeDamage(25);
                if(enemyHealth <= 0) {
                    System.out.println("You have killed the " + enemy.name());
                    enemy.setDead();
                }
                else {
                    System.out.println("The " + enemy.name() + " took 25 HP of damage!");
                    System.out.println("The " + enemy.name() + " has " + enemyHealth + " HP left.");
                }


            }
            else {
                System.out.println("Attack Failed!");
            }
        }
        else if(weapon.equals("Iron Long Sword")) {
            if(r <= 75)  {
                attackSuccessful = true;
                System.out.println("Attack Successful!");
                int enemyHealth = enemy.takeDamage(30);
                if(enemyHealth <= 0) {
                    System.out.println("You have killed the " + enemy.name());
                    enemy.setDead();
                }
                else {
                    System.out.println("The " + enemy.name() + " took 30 HP of damage!");
                    System.out.println("The " + enemy.name() + " has " + enemyHealth + " HP left.");
                }


            }
            else {
                System.out.println("Attack Failed!");
            }
        }
        else if(weapon.equals("Magical Broad Sword")) {
            if(r <= 90)  {
                attackSuccessful = true;
                System.out.println("Attack Successful!");
                int enemyHealth = enemy.takeDamage(50);
                if(enemyHealth <= 0) {
                    System.out.println("You have killed the " + enemy.name());
                    enemy.setDead();
                }
                else {
                    System.out.println("The " + enemy.name() + " took 50 HP of damage!");
                    System.out.println("The " + enemy.name() + " has " + enemyHealth + " HP left.");
                }


            }
            else {
                System.out.println("Attack Failed!");
            }
        }
        if(enemy.dead()==false) {
            System.out.println("The " + enemy.name() + " attacked you!");
            playerHP -= enemy.attack();
            if(playerHP<=0) {
                playerHP += enemy.attack();
                System.out.println("The " + enemy.name() + " killed you!");
                System.out.println("restart? (Type exactly 'yes' or 'no')");
                check = scan.nextLine();
                restartCheck();
            }
            else {
                System.out.println("You now have " + playerHP + " HP left.");
                attackAgain(weapon, enemy);
            }
        }
        else {
            array[playerX][playerY + 1] = 5;
            array[playerX][playerY] = 0;
            ask();
        }
    }
    public static void restartCheck() {
        if(check.equals("yes")) {
            try {
                System.out.println("Function coming soon!");
                save(5);

            } catch (Exception e) {
                System.out.println("Restart Failed. To run from last point, run with the argument 'restart'.");
            }
            //System.out.println("Too bad. In real life, you don't get second chances.");
        }
        else if(check.equals("no")) {
            System.out.println("Okay. Goodbye.");
            System.exit(0);
        }
    }
    public static void attackAgain(String weapon, Enemy enemy)  {
        System.out.println("Will you attack again? (Type exactly 'yes' or 'no')");
        check = scan.nextLine();
        check();
        if(checkBool==true) {
            attack(weapon, enemy);
        }
        else {
            playerY--;
            System.out.println("You take a step backwards to get away");
            ask();
        }
    }
    public static void askChest(Chest chest) {
        System.out.println("There is a treasure chest in front of you! Will you open it? (type exactly 'yes' or 'no')");
        check = scan.nextLine();
        check();
        if(checkBool==true) {
            System.out.println("You opened it and found a(n) " + chest.containedItem() + " inside.");
            give(chest.containedItem());
            array[playerX][playerY] = 4;
            ask();
        }
        else {
            System.out.println("You took a step backwards.");
            playerY--;
            ask();
        }
    }
    public static void load(int slot) {
        switch (slot) {
            case 1:
                Load.load(jsonsave1);
                if(Load.fileExists) {
                    playerX = Load.playerX;
                    playerY = Load.playerY;
                    playerHP = Load.playerHP;

                    weapon1 = Load.weapon1;
                    weapon2 = Load.weapon2;
                    weapon3 = Load.weapon3;
                    weapon4 = Load.weapon4;
                    food1 = Load.food1;
                    food2 = Load.food2;
                    food3 = Load.food3;
                    food4 = Load.food4;
                    food5 = Load.food5;

                    cheats = Load.cheats;
                    dev = Load.dev;

                    array = Load.array;
                }
                break;
            case 2:
                Load.load(jsonsave2);
                if(Load.fileExists) {
                    playerX = Load.playerX;
                    playerY = Load.playerY;
                    playerHP = Load.playerHP;

                    weapon1 = Load.weapon1;
                    weapon2 = Load.weapon2;
                    weapon3 = Load.weapon3;
                    weapon4 = Load.weapon4;
                    food1 = Load.food1;
                    food2 = Load.food2;
                    food3 = Load.food3;
                    food4 = Load.food4;
                    food5 = Load.food5;

                    cheats = Load.cheats;
                    dev = Load.dev;

                    array = Load.array;
                }
                break;
            case 3:
                Load.load(jsonsave3);
                if(Load.fileExists) {
                    playerX = Load.playerX;
                    playerY = Load.playerY;
                    playerHP = Load.playerHP;

                    weapon1 = Load.weapon1;
                    weapon2 = Load.weapon2;
                    weapon3 = Load.weapon3;
                    weapon4 = Load.weapon4;
                    food1 = Load.food1;
                    food2 = Load.food2;
                    food3 = Load.food3;
                    food4 = Load.food4;
                    food5 = Load.food5;

                    cheats = Load.cheats;
                    dev = Load.dev;

                    array = Load.array;
                }
                break;
            case 4:
                Load.load(jsonsave4);
                if(Load.fileExists) {
                    playerX = Load.playerX;
                    playerY = Load.playerY;
                    playerHP = Load.playerHP;

                    weapon1 = Load.weapon1;
                    weapon2 = Load.weapon2;
                    weapon3 = Load.weapon3;
                    weapon4 = Load.weapon4;
                    food1 = Load.food1;
                    food2 = Load.food2;
                    food3 = Load.food3;
                    food4 = Load.food4;
                    food5 = Load.food5;

                    cheats = Load.cheats;
                    dev = Load.dev;

                    array = Load.array;
                }
                break;
            case 5:
                Load.load(jsonsave5);
                if(Load.fileExists) {
                    playerX = Load.playerX;
                    playerY = Load.playerY;
                    playerHP = Load.playerHP;

                    weapon1 = Load.weapon1;
                    weapon2 = Load.weapon2;
                    weapon3 = Load.weapon3;
                    weapon4 = Load.weapon4;
                    food1 = Load.food1;
                    food2 = Load.food2;
                    food3 = Load.food3;
                    food4 = Load.food4;
                    food5 = Load.food5;

                    cheats = Load.cheats;
                    dev = Load.dev;

                    array = Load.array;
                }
                break;
        }
    }
    public static void save(int slot) {
        switch (slot) {
            case 1:
                Save.save(1);
                System.out.println("Game Saved.");
                System.exit(0);
               break;
            case 2:
                Save.save(2);
                System.out.println("Game Saved.");
                System.exit(0);
                break;
            case 3:
                Save.save(3);
                System.out.println("Game Saved.");
                System.exit(0);
                break;
            case 4:
                Save.save(4);
                System.out.println("Game Saved.");
                System.exit(0);
                break;
            case 5:
                Save.save(5);
                System.out.println("Game Saved.");
                //System.exit(0);
                break;
        }
    }
    public static void delete(int slot) {
        switch (slot) {
            case 1:
                DeleteSave.delete(slot, new File("save1.json"));
                break;
        }
    }
    public static void loadCustomMap(JSONObject map) {
        LoadMap.loadMap(map);
    }
    public static void setMap(int[][] map) {
        array = map;
    }

}
