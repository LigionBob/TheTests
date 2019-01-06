package ligionbob.chests;

public class Chest {
    private String containedItem = "";

    public Chest(String containedItem) {

        this.containedItem = containedItem;
    }
    public String containedItem() {

        return this.containedItem;
    }
}
