package ligionbob.init;

import ligionbob.enemies.Enemy;
import ligionbob.enemies.EnemyNormalOgre;
import ligionbob.enemies.EnemySmallOgre;

public class Enemies {
    public static Enemy smallOgre;
    public static Enemy normalOgre;

    public static void init() {
        smallOgre = new EnemySmallOgre(10, 50, "small ogre");
        normalOgre = new EnemyNormalOgre(20, 100, "normal ogre");
    }
}
