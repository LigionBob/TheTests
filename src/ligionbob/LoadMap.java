package ligionbob;

import com.google.gson.Gson;
import org.json.JSONObject;

public class LoadMap {

    public static Gson gson;
    public static int[][] array;

    public static void loadMap(JSONObject file) {
        array = gson.fromJson(file.getString("array"), int[][].class);
        try {
            Main.setMap(array);
        } catch(Exception e) {
            System.out.println("An error has occurred. Details below:");
            e.printStackTrace();
        }

    }
}
