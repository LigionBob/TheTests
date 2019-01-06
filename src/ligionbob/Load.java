package ligionbob;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import sun.awt.Symbol;
import sun.misc.CharacterEncoder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Load {

    public static int playerX=8;
    public static int playerY=8;
    public static int playerHP=100;

    public static String weapon1="";
    public static String weapon2="";
    public static String weapon3="";
    public static String weapon4="";
    public static String food1="";
    public static String food2="";
    public static String food3="";
    public static String food4="";
    public static String food5="";
    public static Object jarray;

    public static int[][] array;

    public static boolean cheats;
    public static boolean dev;

    public static FileWriter save1;
    public static BufferedOutputStream save2;
    public static BufferedOutputStream save3;
    public static BufferedOutputStream save4;
    public static BufferedOutputStream save5;

    public static JSONObject jsave1;

    public static Gson gson = new Gson();

    public static String dir = System.getProperty("user.dir");
    public static boolean fileExists;

    public static void load(JSONObject file) {
        if(file==null) {
            System.out.println("File not found.");
            fileExists=false;
        }
        else {
            fileExists=true;
            playerX = file.getInt("playerX");
            playerY = file.getInt("playerY");
            playerHP = file.getInt("playerHP");

            weapon1 = file.getString("weapon1");
            weapon2 = file.getString("weapon2");
            weapon3 = file.getString("weapon3");
            weapon4 = file.getString("weapon4");
            food1 = file.getString("food1");
            food2 = file.getString("food2");
            food3 = file.getString("food3");
            food4 = file.getString("food4");
            food5 = file.getString("food5");

            jarray = file.getString("array");
            array = gson.fromJson(file.getString("array"), int[][].class);

            cheats = file.getBoolean("cheats");
            dev = file.getBoolean("dev");
        }
    }
}
