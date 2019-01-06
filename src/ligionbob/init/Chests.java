package ligionbob.init;

import ligionbob.chests.*;

public class Chests {
    public static Chest IronShortSwordChest;
    public static Chest IronLongSwordChest;
    public static Chest MagicalBroadSwordChest;
    public static Chest ChickenLegChest;
    public static Chest TurkeyLegChest;

    public static void init() {
        IronShortSwordChest = new ChestIronShortSword("Iron Short Sword");
        IronLongSwordChest = new ChestIronLongSword("Iron Long Sword");
        MagicalBroadSwordChest = new ChestMagicalBroadSword("Magical Broad Sword");
        ChickenLegChest = new ChestChickenLeg("Chicken Leg");
        TurkeyLegChest = new ChestTurkeyLeg("Turkey Leg");

    }
}
