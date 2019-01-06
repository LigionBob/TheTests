package ligionbob;

import java.io.File;
import java.nio.file.Files;

public class DeleteSave {

    public static void delete(int slot, File fileSlot) {
        switch (slot) {
            case 1:
                fileSlot.delete();
                break;
        }
    }
}
