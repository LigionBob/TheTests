package ligionbob;

import com.google.gson.Gson;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Save {

    public static JSONObject jsave1;
    public static JSONObject jsave2;
    public static JSONObject jsave3;
    public static JSONObject jsave4;
    public static JSONObject jsave5;
    public static JSONObject jsave6;

    public static Gson gson;
    public static String json;

    public static FileWriter save1;
    public static FileWriter save2;
    public static FileWriter save3;
    public static FileWriter save4;
    public static FileWriter save5;
    public static FileWriter save6;

    public static void save(int slot) {

        switch (slot) {
            case 1:
                createFiles(slot);
                jsave1 = new JSONObject();
                //System.out.print("Check 1");
                jsave1.put("playerX", Main.playerX);
                jsave1.put("playerY", Main.playerY);
                jsave1.put("playerHP", Main.playerHP);
                //System.out.print("Check 2");
                jsave1.put("weapon1", Main.weapon1);
                jsave1.put("weapon2", Main.weapon2);
                jsave1.put("weapon3", Main.weapon3);
                jsave1.put("weapon4", Main.weapon4);
                jsave1.put("food1", Main.food1);
                jsave1.put("food2", Main.food2);
                jsave1.put("food3", Main.food3);
                jsave1.put("food4", Main.food4);
                jsave1.put("food5", Main.food5);
                //System.out.print("Check 3");
                jsave1.put("cheats", Main.cheats);
                jsave1.put("dev", Main.dev);
                //System.out.print("Check 4");
                json = gson.toJson(Main.array);
                jsave1.put("array", json);
                //System.out.print("Check 5");
                try {
                    save1.write(jsave1.toJSONString());
                    save1.close();
                    //System.out.print("Check 6");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                createFiles(slot);
                jsave2 = new JSONObject();
                //System.out.print("Check 1");
                jsave2.put("playerX", Main.playerX);
                jsave2.put("playerY", Main.playerY);
                jsave2.put("playerHP", Main.playerHP);
                //System.out.print("Check 2");
                jsave2.put("weapon1", Main.weapon1);
                jsave2.put("weapon2", Main.weapon2);
                jsave2.put("weapon3", Main.weapon3);
                jsave2.put("weapon4", Main.weapon4);
                jsave2.put("food1", Main.food1);
                jsave2.put("food2", Main.food2);
                jsave2.put("food3", Main.food3);
                jsave2.put("food4", Main.food4);
                jsave2.put("food5", Main.food5);
                //System.out.print("Check 3");
                jsave2.put("cheats", Main.cheats);
                jsave2.put("dev", Main.dev);
                //System.out.print("Check 4");
                json = gson.toJson(Main.array);
                jsave2.put("array", json);
                //System.out.print("Check 5");
                try {
                    save2.write(jsave2.toJSONString());
                    save2.close();
                    //System.out.print("Check 6");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                createFiles(slot);
                jsave3 = new JSONObject();
                //System.out.print("Check 1");
                jsave3.put("playerX", Main.playerX);
                jsave3.put("playerY", Main.playerY);
                jsave3.put("playerHP", Main.playerHP);
                //System.out.print("Check 2");
                jsave3.put("weapon1", Main.weapon1);
                jsave3.put("weapon2", Main.weapon2);
                jsave3.put("weapon3", Main.weapon3);
                jsave3.put("weapon4", Main.weapon4);
                jsave3.put("food1", Main.food1);
                jsave3.put("food2", Main.food2);
                jsave3.put("food3", Main.food3);
                jsave3.put("food4", Main.food4);
                jsave3.put("food5", Main.food5);
                //System.out.print("Check 3");
                jsave3.put("cheats", Main.cheats);
                jsave3.put("dev", Main.dev);
                //System.out.print("Check 4");
                json = gson.toJson(Main.array);
                jsave3.put("array", json);
                //System.out.print("Check 5");
                try {
                    save3.write(jsave3.toJSONString());
                    save3.close();
                    //System.out.print("Check 6");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 4:
                createFiles(slot);
                jsave4 = new JSONObject();
                //System.out.print("Check 1");
                jsave4.put("playerX", Main.playerX);
                jsave4.put("playerY", Main.playerY);
                jsave4.put("playerHP", Main.playerHP);
                //System.out.print("Check 2");
                jsave4.put("weapon1", Main.weapon1);
                jsave4.put("weapon2", Main.weapon2);
                jsave4.put("weapon3", Main.weapon3);
                jsave4.put("weapon4", Main.weapon4);
                jsave4.put("food1", Main.food1);
                jsave4.put("food2", Main.food2);
                jsave4.put("food3", Main.food3);
                jsave4.put("food4", Main.food4);
                jsave4.put("food5", Main.food5);
                //System.out.print("Check 3");
                jsave4.put("cheats", Main.cheats);
                jsave4.put("dev", Main.dev);
                //System.out.print("Check 4");
                json = gson.toJson(Main.array);
                jsave4.put("array", json);
                //System.out.print("Check 5");
                try {
                    save4.write(jsave4.toJSONString());
                    save4.close();
                    //System.out.print("Check 6");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 5:
                createFiles(slot);
                jsave5 = new JSONObject();
                //System.out.print("Check 1");
                jsave5.put("playerX", Main.playerX);
                jsave5.put("playerY", Main.playerY);
                jsave5.put("playerHP", Main.playerHP);
                //System.out.print("Check 2");
                jsave5.put("weapon1", Main.weapon1);
                jsave5.put("weapon2", Main.weapon2);
                jsave5.put("weapon3", Main.weapon3);
                jsave5.put("weapon4", Main.weapon4);
                jsave5.put("food1", Main.food1);
                jsave5.put("food2", Main.food2);
                jsave5.put("food3", Main.food3);
                jsave5.put("food4", Main.food4);
                jsave5.put("food5", Main.food5);
                //System.out.print("Check 3");
                jsave5.put("cheats", Main.cheats);
                jsave5.put("dev", Main.dev);
                //System.out.print("Check 4");
                json = gson.toJson(Main.array);
                jsave5.put("array", json);
                //System.out.print("Check 5");
                try {
                    save5.write(jsave5.toJSONString());
                    save5.close();
                    //System.out.print("Check 6");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }

    }

    public static void createFiles(int slot) {
        gson = new Gson();
        switch(slot) {
            case 1:
        //System.out.println("1");
                try {
                    //System.out.println("2");
                    save1 = new FileWriter("save1.json");
                    //save1.write(jsave1.toJSONString());
                    //save1.close();

                }
                catch(Exception e) {
                    System.out.println("Error Saving; details below:");
                    System.out.println(e.toString());
                }
                break;
            case 2:
                try {
                    save2 = new FileWriter("save2.json");
                }
                catch(Exception e) {
                    System.out.println("Error Saving; details below:");
                    System.out.println(e.toString());
                }
                break;
            case 3:
                try {
                    save3 = new FileWriter("save3.json");
                }
                catch(Exception e) {
                    System.out.println("Error Saving; details below:");
                    System.out.println(e.toString());
                }
                break;
            case 4:
                try {
                    save4 = new FileWriter("save4.json");
                }
                catch(Exception e) {
                    System.out.println("Error Saving; details below:");
                    System.out.println(e.toString());
                }
                break;
            case 5:
                try {
                    save5 = new FileWriter("save5.json");
                }
                catch(Exception e) {
                    System.out.println("Error Saving; details below:");
                    System.out.println(e.toString());
                }
                break;
        }
    }
}
