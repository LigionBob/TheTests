package ligionbob.enemies;

public class Enemy {

    private int attack = 0;
    private int health = 0;
    private String name = "";
    private boolean dead = false;

    public Enemy(int attack, int health, String name) {
        this.attack = attack;
        this.health = health;
        this.name = name;
    }
    public int takeDamage(int damage) {
        this.health -= damage;
        if(this.health < 0) {
            this.health = 0;
        }
        return this.health;
    }
    public String name() {

        return this.name;
    }
    public int health() {

        return this.health;
    }
    public int attack() {

        return this.attack;
    }
    public boolean dead() {

        return this.dead;
    }
    public boolean setDead() {
        this.dead = true;
        return this.dead;
    }
}
