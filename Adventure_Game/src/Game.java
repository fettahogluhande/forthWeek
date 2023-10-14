import java.util.Scanner;

public class Game {
    private Scanner scanner = new Scanner(System.in);
    private String playerName;
    public void start(){
        System.out.println("Welcome to the Adventure Game !");
        System.out.print("Please enter a name: ");
        playerName = scanner.nextLine();
        Player player = new Player(playerName);
        System.out.println("Dear " + player.getName() + " welcome to this foggy and dark island !");
        System.out.println("Everything that happens in here is real !");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("Charater List: ");
        player.selectChar();

        Location location = null;

        while (true){
            player.printInfo();
            System.out.println();
            System.out.println("-------------------Locations: ---------------------");
            System.out.println("1- Safe House");
            System.out.println("2- Tool Store");
            System.out.println("3- Cave");
            System.out.println("4- Forest");
            System.out.println("5- River");
            System.out.println("Press '0' for exit");
            System.out.print("Please choose a location: ");
            int selectLoc = scanner.nextInt();
            switch (selectLoc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                default:
                    location = new SafeHouse(player);
            }
            if (location == null){
                System.out.println("The game is over ! See you again !");
                break;
            }
            if(!location.onLocation()){
                System.out.println("Game over!");
                break;
            }
        }


    }
}
