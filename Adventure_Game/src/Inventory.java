public class Inventory {
    private Guns guns;
    private Armor armor;

    public Inventory() {
        this.guns = new Guns("Impact",-1,0,0);
        this.armor = new Armor(-1,"null",0,0);
    }

    public Guns getGuns() {
        return guns;
    }

    public void setGuns(Guns guns) {
        this.guns = guns;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }
}
