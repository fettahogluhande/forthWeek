public class ToolStore extends NormalLoc {

    public ToolStore(Player player) {
        super(player, "Tool Store");
    }

    @Override
    public boolean onLocation() {
        System.out.println("------------------------------------------------------");
        System.out.println("Welcome to the store!");
        boolean showMenu = true;
        while (showMenu){
            System.out.println("1- Guns");
            System.out.println("2- Armors");
            System.out.println("3- Exit");
            System.out.print("Your choice: ");
            int selectCase = Location.scanner.nextInt();
            while (selectCase < 1 || selectCase > 3) {
                System.out.println("Invalid value");
                selectCase = Location.scanner.nextInt();
            }
            switch (selectCase) {
                case 1:
                    printGuns();
                    buyGuns();
                    break;
                case 2:
                    printArmors();
                    buyArmors();
                    break;
                case 3:
                    System.out.println("See you!");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }

    public void printGuns() {
        System.out.println("------------------------Guns: ------------------------");
        for (Guns gun : Guns.guns()) {
            System.out.println(gun.getId() + "-" +
                    gun.getName() + "<Money:" +
                    gun.getPrice() + ",Damage: " +
                    gun.getDamage() + ">");
        }
        System.out.println("Press '0' for exit");
    }
    public void buyGuns() {
        System.out.print("Choose a gun: ");

        int selectGun = scanner.nextInt();
        while (selectGun < 0 || selectGun > Guns.guns().length) {
            System.out.println("Invalid value");
            selectGun = scanner.nextInt();
        }

        if (selectGun != 0){
            Guns selectedGun = Guns.getGunObjByID(selectGun);

            if (selectedGun != null) {
                if (selectedGun.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Money is not enough!");
                } else {
                    System.out.println(selectedGun.getName() + " taken");
                    int balance = this.getPlayer().getMoney() - selectedGun.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Updated money: " + this.getPlayer().getMoney());
                    System.out.println("Previous gun: " + this.getPlayer().getInventory().getGuns().getName());
                    this.getPlayer().getInventory().setGuns(selectedGun);
                    System.out.println("New gun: " + this.getPlayer().getInventory().getGuns().getName());
                }
            }
        }
    }
    public void printArmors() {
        System.out.println("-------------------------Armors: ------------------------");
        for (Armor a : Armor.armors()) {
            System.out.println(a.getId() + "- " + a.getName() +
                    " < Money: " + a.getPrice() +
                    ", Armor: " + a.getBlock() + ">");
        }
        System.out.println("Press '0' for exit");
    }
    public void buyArmors(){
        System.out.print("Choose a armor: ");

        int selectArmor = scanner.nextInt();
        while ( selectArmor < 0 ||  selectArmor > Armor.armors().length) {
            System.out.println("Invalid value");
            selectArmor = scanner.nextInt();
        }
        if (selectArmor != 0){
            Armor selectedArmor = Armor.getArmorObjByID(selectArmor);
            if (selectedArmor != null){
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("Money is not enough!");
                }else{
                    System.out.println("--------------------------------Buying------------------- ");
                    System.out.println(selectedArmor.getName() + " taken");
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Updated money: " + this.getPlayer().getMoney());
                    System.out.println("-----------------------------------------------------------");

                }
            }
        }
    }
}
