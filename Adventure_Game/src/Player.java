import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int orijinalHealth;
    private int money;
    private int selectChar;
    private String name;
    private String character;
    private Scanner scanner;
    private Inventory inventory;


    //default constructor
    public Player() {

    }

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar() {
        GameChar[] gameChars = {new Samurai(), new Archer(), new Knight()};

        for (GameChar gameChar : gameChars) {
            System.out.println(" Identity : " + gameChar.getIdentity() + " |"
                    + " Character: " + gameChar.getName() + " |"
                    + " Damage: " + gameChar.getDamage() + " |"
                    + " Health: " + gameChar.getHealth() + " |"
                    + " Money: " + gameChar.getMoney());
        }
        System.out.print("Please choose a character: ");

        this.scanner = new Scanner(System.in);
        this.selectChar = this.scanner.nextInt();
        switch (selectChar) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }
        System.out.println("Character: " + this.getCharacter() + " => "
                + " Damage : " + this.getDamage() + ","
                + " Health: " + this.getHealth() + ","
                + " Money: " + this.getMoney());
        System.out.println("------------------------------------------------------------");
    }

    public void printInfo(){
        System.out.println("Materials: ");
        System.out.print("Gun : " + this.getInventory().getGuns().getName() + ","+
                " Armor : " + this.getInventory().getArmor().getName() + "," +
                " Block : " + this.getInventory().getArmor().getBlock() + ","+
                " Damage : " + this.getTotalDamage() + ","
                + " Health: " + this.getHealth() + ","
                + " Money: " + this.getMoney());
    }

    public void initPlayer(GameChar gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setOrijinalHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharacter(gameChar.getName());
    }

    //#region ---------GETTER AND SETTER REGION---------
    public int getTotalDamage(){
        return damage + this.getInventory().getGuns().getDamage();
    }
    public int getDamage() {
        return damage + this.getInventory().getGuns().getDamage();
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

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getOrijinalHealth() {
        return orijinalHealth;
    }

    public void setOrijinalHealth(int orijinalHealth) {
        this.orijinalHealth = orijinalHealth;
    }
    //#endregion ------------GETTER AND SETTER END REGION-------------
}
