public class SafeHouse extends NormalLoc{
    public SafeHouse(Player player) {
        super(player,"Safe House");
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are in Safe House.");
        System.out.println("Your life is full.");
        this.getPlayer().setHealth(this.getPlayer().getOrijinalHealth());
        return true;
    }

}
