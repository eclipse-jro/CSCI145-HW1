import java.util.Scanner;

public class DungeonGame {
    private DungeonMap map;
    private Player player;
    private Scanner input;

    public void play(){
        Scanner input = new Scanner(System.in);
        String classChoice;

        printIntro();

        System.out.print("Choose your class, Warrior or Thief? (W/T): ");
        classChoice = input.nextLine();
        player = new Player(classChoice);
        player.setPosition(new Point2d(0,0));

        map = new DungeonMap(10,10,player);

        System.out.println(player.getEntranceText());
        beginGameText();

        while(player.isAlive()&& player.getGold() < 100){
            printDivide();
            printDisplay();


            Room room = new Room();
            room.enter(player, input);

        }
        if(player.isAlive()){
            System.out.println("You acquired 100 cookies! YOU WIN!");
        }
        else{
            System.out.println("GAME OVER!");
        }


    }

    private void printIntro(){
        System.out.println(" ________________________________________________________________________________");
        System.out.println("|    ___    __    __   _  _ ___  ____     ___    _    _  ____   _____  _______   |");
        System.out.println("|   /   \\  /  \\  /  \\  | /   |   |       /   \\   |    |  |     |    |     |      |");
        System.out.println("|  |      |    ||    | |/    |   |__    |     |  |    |  |___   \\___      |      |");
        System.out.println("|   \\   |  \\  /  \\  /  | \\   |   |       \\  \\/   |    |  |          |     |      |");
        System.out.println("|     --    --    --   '  '  ---  ---     -- \\    \\__/    ---- |____/     |      |");
        System.out.println("|________________________________________________________________________________|");

        System.out.println();

        System.out.println("One hero needs to collect 100 cookies to satisfy the evil King.");
        System.out.println("You are camped outside the fabled Dungeon of Delights, to gather those cookies.");
        System.out.println("You will not alone in the dungeon...");
        System.out.println("In each room, you may find goodies, or one of the greedy inhabitants.");
        System.out.println("Don't let its inhabitants get you...");
        System.out.println();
    }

    public void beginGameText(){
        System.out.println();
        System.out.println("You enter the dungeon...");
        System.out.println();
    }

    public void printDivide(){
        System.out.println("---------------------------------------------------");
        System.out.println("---------------------------------------------------");
    }

    public void printDisplay(){
        map.Print();
        System.out.printf("Health: %d/%d\n", player.getHealth(), player.getMaxHealth());
        System.out.printf("Cookies: %d/100\n", player.getGold());
        System.out.println();
    }
}
