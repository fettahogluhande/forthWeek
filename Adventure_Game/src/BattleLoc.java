import java.util.Random;

public class BattleLoc extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obsNum = this.randomObstacleNumber();
        System.out.println("------------------------------------------------------------------");
        System.out.println("You are in the " + this.getName());
        System.out.println("Watch out! " + obsNum + " " + this.getObstacle().getName() + " lives here ");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("<F>ight & <R>un");
        String selectCase = scanner.nextLine().toUpperCase();
        if (selectCase.equals("F")) {
            if (combat(obsNum)) {
                System.out.println(this.getName() + " you win!");
                return true;
            }
        }
        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("You dead");
            return false;
        }
        return true;
    }

    public boolean combat(int obsNumber) {
        for (int i = 1; i <= obsNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getOrijinalHealth());
            playerStat();
            obstacleStat(i);
            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                System.out.println("<H>it & <R>un");
                String selectCombat = scanner.nextLine();
                if (selectCombat.equals("H")) {
                    System.out.println();
                    System.out.println("You hit");
                    this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                    afterHit();
                    if (getObstacle().getHealth() > 0) {
                        System.out.println();
                        System.out.println("Obstacle hit you");
                        int obstacleDamage = this.getObstacle().getHealth() - this.getPlayer().getInventory().getArmor().getBlock();
                        if (obstacleDamage < 0) {
                            obstacleDamage = 0;
                        }

                        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                        afterHit();
                    }
                } else {
                    return false;
                }
            }
            if (this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
                System.out.println("You are winner!");
                System.out.println("You gained " + this.getObstacle().getAward());
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                System.out.println("Updated money: " + this.getPlayer().getMoney());
            }
        }
        return false;
    }

    public void afterHit() {
        System.out.println("Player Health: " + this.getPlayer().getHealth());
        System.out.println("Obstacle Health: " + this.getObstacle().getHealth());
        System.out.println();
    }

    public void playerStat() {
        System.out.println("Player values:");
        System.out.println("--------------------------------------------");
        System.out.println("Health: " + this.getPlayer().getHealth());
        System.out.println("Damage: " + this.getPlayer().getTotalDamage());
        System.out.println("Gun: " + this.getPlayer().getInventory().getGuns().getName());
        System.out.println("Armor: " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Block: " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Money: " + this.getPlayer().getMoney());
        System.out.println("---------------------------------------------");
    }

    public void obstacleStat(int i) {
        System.out.println(i + "." + this.getObstacle().getName() + " values");
        System.out.println("---------------------------------------------");
        System.out.println("Health: " + this.getObstacle().getHealth());
        System.out.println("Damage: " + this.getObstacle().getDamage());
        System.out.println("Award: " + this.getObstacle().getAward());
        System.out.println("----------------------------------------------");
    }

    public int randomObstacleNumber() {
        Random random = new Random();
        return random.nextInt(this.getMaxObstacle()) + 1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
