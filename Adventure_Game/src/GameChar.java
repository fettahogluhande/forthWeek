public abstract class GameChar {
    private int identity;
    private int damage;
    private int health;
    private int money;
    private String name;

    public GameChar(int identity, int damage, int health, int money, String name) {
        this.identity = identity;
        this.damage = damage;
        this.health = health;
        this.money = money;
        this.name = name;
    }

    //region --------GETTER AND SETTER REGION----------

    public int getIdentity() {
        return identity;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //#endregion -----------GETTER AND SETTER END REGION--------------
}
