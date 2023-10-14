public class Guns {
    private String name;
    private int id;
    private int damage;
    private int price;

    public Guns(String name, int id, int damage, int price) {
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.price = price;
    }

    public static Guns[] guns() {
        Guns[] GunsList = new Guns[3];
        GunsList[0] = new Guns("Tabanca", 1, 2, 5);
        GunsList[1] = new Guns("Kılıç", 2, 3, 35);
        GunsList[2] = new Guns("Tüfek", 3, 7, 45);
        return GunsList;
    }

    public static Guns getGunObjByID(int id){
        for (Guns gun : Guns.guns()){
            if (gun.getId() == id){
                return gun;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
